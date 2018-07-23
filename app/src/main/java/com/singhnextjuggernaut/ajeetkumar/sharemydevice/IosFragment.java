package com.singhnextjuggernaut.ajeetkumar.sharemydevice;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.SearchView;

import com.singhnextjuggernaut.ajeetkumar.sharemydevice.constant.AppConstant;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.DeviceData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.database.CommonData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.retrofit.ApiCaller;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class IosFragment extends Fragment implements Filterable {

    List<DeviceData> devices;
    List<DeviceData> devices2;
    RecyclerView recyclerView;
    DeviceListAdapter adapter;
    SearchView searchView;

    SwipeRefreshLayout mSwipeRefreshLayout;
    public IosFragment() {
        devices=CommonData.getIOSList();
        devices2 = new ArrayList<>(devices);
        // Required empty public constructor
    }
    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<DeviceData> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(devices2);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (DeviceData item : devices2) {
                    String s = item.getStickerNo();
                    String s1=item.getBrand();
                    String s2=item.getModel();
                    String s3=item.getResolution();
                    String s4=item.getScreen_size();
                    String s5=item.getVersion();
                    String s6=((AbstractMap<String,String>) item.getOwnerId()).get("name");

                    if (s.toLowerCase().contains(filterPattern)||s1.toLowerCase().contains(filterPattern)||s2.toLowerCase().contains(filterPattern)||s3.toLowerCase().contains(filterPattern)||s4.toLowerCase().contains(filterPattern)||s5.toLowerCase().contains(filterPattern)||s6.toLowerCase().contains(filterPattern))
                    {
                        filteredList.add(item);
                    }
                }

            }

            FilterResults results = new FilterResults();
            results.values = filteredList;


            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            devices.clear();
            // deviceList.addAll(results.values);
            devices.addAll((List<DeviceData>) results.values);
            adapter.notifyDataSetChanged();
        }
    };




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview=inflater.inflate(R.layout.fragment_ios, container, false);
        //getting the recyclerview from xml
        recyclerView = rootview.findViewById(R.id.ios_tab_recycler);
        //recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));


        mSwipeRefreshLayout = rootview.findViewById(R.id.swipeToRefreshIos);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            public void onRefresh() {
                Call<List<DeviceData>> device_list_api = ApiCaller.getApiInterface().devicelist(CommonData.getAccessToken());
                device_list_api.enqueue(new Callback<List<DeviceData>>() {
                    @Override
                    public void onResponse(Call<List<DeviceData>> call, Response<List<DeviceData>> response) {
                        if (response.isSuccessful()) {
                            ArrayList<DeviceData> android, ios, cable;
                            android = new ArrayList<>();
                            ios = new ArrayList<>();
                            cable = new ArrayList<>();
                            for (int i = 0; i < response.body().size(); i++) {
                                switch (response.body().get(i).getDeviceCategory()) {
                                    case AppConstant.DEVICE_CATEGORY_ANDROID: {
                                        android.add(response.body().get(i));
                                        break;
                                    }
                                    case AppConstant.DEVICE_CATEGORY_IOS: {
                                        ios.add(response.body().get(i));
                                        break;
                                    }
                                    case AppConstant.DEVICE_CATEGORY_CABLE: {
                                        cable.add(response.body().get(i));
                                        break;
                                    }
                                }
                            }
                            CommonData.saveAndroidList(android);
                            CommonData.saveIOSList(ios);
                            CommonData.saveCableList(cable);
                            recyclerView.removeAllViews();
                            recyclerView.setHasFixedSize(true);
                            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                            //initializing the productlist
                            devices = CommonData.getIOSList();
                            //creating recyclerview adapter
                            adapter = new DeviceListAdapter(getActivity(), devices);
                            //setting adapter to recyclerview
                            adapter.notifyDataSetChanged();
                            recyclerView.setAdapter(adapter);
                            recyclerView.invalidate();
                            //Log.d("BODYSIZE","BODYSIZE : "+response.body().size());
                            //Log.d("COUNT","ADDROID:"+CommonData.getAndroidList().size()+" IOS:"+CommonData.getIOSList().size()+" Cable:"+CommonData.getCableList().size());

                        } else {

                        }


//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
                        // Create the adapter that will return a fragment for each of the three
                        // primary sections of the activity.
//                        mSectionsPagerAdapter = new HomeActivity.SectionsPagerAdapter(getSupportFragmentManager());
//
//                        // Set up the ViewPager with the sections adapter.
//                        mViewPager = (ViewPager) findViewById(R.id.container);
//                        mViewPager.setAdapter(mSectionsPagerAdapter);
//
//                        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
//
//                        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//                        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

                    }

                    @Override
                    public void onFailure(Call<List<DeviceData>> call, Throwable t) {
                        Log.d("err", t.getMessage());
                    }
                });

                mSwipeRefreshLayout.setRefreshing(false);
            }
        });






















        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //initializing the productlist
        //creating recyclerview adapter
        DeviceListAdapter adapter = new DeviceListAdapter(getActivity(), CommonData.getIOSList());
        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

        searchView = rootview.findViewById(R.id.searchViewIos);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                exampleFilter.filter(newText);
                return false;
            }
        });
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                //Do something on collapse Searchview
                return false;
            }
        });



        return rootview;
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_ios, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        DeviceListAdapter adapter = new DeviceListAdapter(getActivity(), CommonData.getIOSList());
        recyclerView.setAdapter(adapter);
    }
    public Filter getFilter() {
        return exampleFilter;
    }
}
