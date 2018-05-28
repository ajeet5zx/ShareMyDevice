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

import com.singhnextjuggernaut.ajeetkumar.sharemydevice.constant.AppConstant;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.DeviceData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.database.CommonData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.retrofit.ApiCaller;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class Cables_fragment extends Fragment {

    List<DeviceData> cables;
    RecyclerView recyclerView;
    SwipeRefreshLayout mSwipeRefreshLayout;


    public Cables_fragment() {


        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        // Inflate the layout for this fragment
        View rootview=inflater.inflate(R.layout.fragment_cables_fragment, container, false);
        //getting the recyclerview from xml
        recyclerView = rootview.findViewById(R.id.cable_tab_recycler);


        mSwipeRefreshLayout = rootview.findViewById(R.id.swipeToRefreshCable);
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
                            cables = CommonData.getCableList();
                            //creating recyclerview adapter
                            Cables_list_adapter adapter = new Cables_list_adapter(getActivity(), cables);
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
//                        mSectionsPagerAdapter = new home.SectionsPagerAdapter(getSupportFragmentManager());
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



        //recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //initializing the productlist
        cables = CommonData.getCableList();

        //creating recyclerview adapter
        Cables_list_adapter adapter = new Cables_list_adapter(getActivity(),cables);


        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);


        return rootview;
       // return inflater.inflate(R.layout.fragment_cables_fragment, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        Cables_list_adapter adapter = new Cables_list_adapter(getActivity(),CommonData.getCableList());
        recyclerView.setAdapter(adapter);
    }

}
