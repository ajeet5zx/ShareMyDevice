package com.singhnextjuggernaut.ajeetkumar.sharemydevice;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.singhnextjuggernaut.ajeetkumar.sharemydevice.constant.AppConstant;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.Data;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.DeviceData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.ResponseMessage;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.database.CommonData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.retrofit.ApiCaller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class home extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private ImageView side_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Call<List<DeviceData>> device_list_api = ApiCaller.getApiInterface().devicelist(CommonData.getAccessToken());
        device_list_api.enqueue(new Callback<List<DeviceData>>() {
            @Override
            public void onResponse(Call<List<DeviceData>> call, Response<List<DeviceData>> response) {
                if (response.isSuccessful()) {
                    ArrayList<DeviceData> android,ios,cable;
                    android = new ArrayList<>();
                    ios = new ArrayList<>();
                    cable = new ArrayList<>();
                    for(int i=0;i<response.body().size();i++) {
                        switch (response.body().get(i).getDeviceCategory()) {
                            case AppConstant.DEVICE_CATEGORY_ANDROID : { android.add(response.body().get(i));
                            break;
                            }
                            case AppConstant.DEVICE_CATEGORY_IOS : { ios.add(response.body().get(i));
                            break;
                            }
                            case AppConstant.DEVICE_CATEGORY_CABLE: { cable.add(response.body().get(i));
                            break;
                            }
                        }
                    }
                    CommonData.saveAndroidList(android);
                    CommonData.saveIOSList(ios);
                    CommonData.saveCableList(cable);
                    //Log.d("BODYSIZE","BODYSIZE : "+response.body().size());
                    //Log.d("COUNT","ADDROID:"+CommonData.getAndroidList().size()+" IOS:"+CommonData.getIOSList().size()+" Cable:"+CommonData.getCableList().size());

                } else {

                }


//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
                // Create the adapter that will return a fragment for each of the three
                // primary sections of the activity.
                mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

                // Set up the ViewPager with the sections adapter.
                mViewPager = (ViewPager) findViewById(R.id.container);
                mViewPager.setAdapter(mSectionsPagerAdapter);

                TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

                mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout){

                    @Override
                    public void onPageSelected(int position) {
                        super.onPageSelected(position);

                        Fragment fragment = ((SectionsPagerAdapter)mViewPager.getAdapter()).getFragment(position);

                        if (position ==1 && fragment != null)
                        {
                            fragment.onResume();
                        }
                    }



                });
                tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

            }

            @Override
            public void onFailure(Call<List<DeviceData>> call, Throwable t) {
                Log.d("err", t.getMessage());
            }
        });

        side_menu = (ImageView) findViewById(R.id.menu_button);
        side_menu.setVisibility(View.VISIBLE);

        side_menu.setOnClickListener(new View.OnClickListener()


        {
            @Override
            public void onClick(View view) {
                PopupWindow popupSort;


                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View layout = inflater.inflate(R.layout.side_menu,
                        (ViewGroup) findViewById(R.id.side_menu_card));
                popupSort = new PopupWindow(layout, ViewGroup.LayoutParams.WRAP_CONTENT
                        , ViewGroup.LayoutParams.WRAP_CONTENT, true);
                popupSort.showAtLocation(view, Gravity.TOP | Gravity.RIGHT, 0, 50);
                popupSort.setElevation(10);
                RelativeLayout back_dim_layout = (RelativeLayout) findViewById(R.id.bac_dim_layout);

//                back_dim_layout.setVisibility(layout.VISIBLE);

                TextView menu_profile = layout.findViewById(R.id.side_menu_profile);
                //TextView menu_ios = layout.findViewById(R.id.side_menu_ios);
                TextView menu_android = layout.findViewById(R.id.side_menu_android);
               // TextView menu_cables = layout.findViewById(R.id.side_menu_cables);
                TextView menu_about = layout.findViewById(R.id.side_menu_about);
                TextView menu_logout = layout.findViewById(R.id.side_menu_logout);


                menu_profile.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(home.this, Profile.class);
                        startActivity(intent);
                    }
                });
//                menu_ios.setOnClickListener(new View.OnClickListener() {
//                    public void onClick(View v) {
//                        Intent intent = new Intent(home.this, Add_devices.class);
//                        startActivity(intent);
//                    }
//                });
                menu_android.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(home.this, MyAndroidDevices.class);
                        startActivity(intent);
                    }
                });
//                menu_cables.setOnClickListener(new View.OnClickListener() {
//                    public void onClick(View v) {
//                        Intent intent = new Intent(home.this, Add_cables.class);
//                        startActivity(intent);
//                    }
//                });
                menu_about.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(home.this, AboutSection.class);
                        startActivity(intent);
                    }
                });
                menu_logout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Call<ResponseMessage> call = ApiCaller.getApiInterface().logout(CommonData.getAccessToken());
                        call.enqueue(new Callback<ResponseMessage>() {
                            @TargetApi(Build.VERSION_CODES.M)
                            @Override
                            public void onResponse(Call<ResponseMessage> call, Response<ResponseMessage> response) {
                                if(response.isSuccessful()) {

                                    Intent intent = new Intent(home.this, MainActivity.class);
                                    startActivity(intent);


                                } else {}
                            }

                            @Override
                            public void onFailure(Call<ResponseMessage> call, Throwable t) {
                            }
                        });
                    }

                });


            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_home, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }



    }



    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */


    public class SectionsPagerAdapter extends FragmentPagerAdapter {


    private Map<Integer, String> mFragmentTags;
    FragmentManager fm ;

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);


            mFragmentTags = new HashMap<Integer,String>();
            this.fm=fm;


        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    Android_Fragment tab1 = new Android_Fragment();
                    return tab1;
                case 1:
                    IosFragment tab2 = new IosFragment();
                    return tab2;
                case 2:
                    Cables_fragment tab3 = new Cables_fragment();
                    return tab3;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Object obj = super.instantiateItem(container, position);
            if (obj instanceof Fragment) {
                // record the fragment tag here.
                Fragment f = (Fragment) obj;
                String tag = f.getTag();
                mFragmentTags.put(position, tag);
            }
            return obj;
        }

        public Fragment getFragment(int position) {
            String tag = mFragmentTags.get(position);
            if (tag == null)
                return null;
            return fm.findFragmentByTag(tag);
        }


        @Override
        public void startUpdate(ViewGroup container) {
            super.startUpdate(container);
        }
    }

}
