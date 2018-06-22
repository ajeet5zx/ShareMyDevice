package com.singhnextjuggernaut.ajeetkumar.sharemydevice;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.singhnextjuggernaut.ajeetkumar.sharemydevice.constant.AppConstant;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.Data;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.DeviceData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.database.CommonData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.retrofit.ApiCaller;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyAndroidDevices extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<DeviceData> myDeviceList;
    private MyAndroidDevicesAdapter mAdapter;
    private ImageButton adddevice;
    private LinearLayout linearLayout;
    SwipeRefreshLayout mSwipeRefreshLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_android_devices);
        adddevice = findViewById(R.id.android_add_button);
        adddevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyAndroidDevices.this, AddDevices.class);
                startActivity(intent);
            }
        });
        linearLayout = findViewById(R.id.my_android_devices);
        RecyclerView recyclerView = findViewById(R.id.my_android_devices_recycler);


        mSwipeRefreshLayout = findViewById(R.id.swipeToRefresh);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            public void onRefresh() {

                autologin();
//                    myDeviceList = CommonData.getRegisterationData().getDeviceData();
//                    mAdapter = new MyAndroidDevicesAdapter(MyAndroidDevices.this, linearLayout, myDeviceList);
//                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//                    recyclerView.setLayoutManager(mLayoutManager);
//                    recyclerView.setItemAnimator(new DefaultItemAnimator());
//                    mAdapter.notifyDataSetChanged();
//                    recyclerView.setAdapter(mAdapter);
//                    recyclerView.invalidate();

                mSwipeRefreshLayout.setRefreshing(false);
            }
        });


        myDeviceList = CommonData.getRegisterationData().getDeviceData();
        mAdapter = new MyAndroidDevicesAdapter(MyAndroidDevices.this, linearLayout, myDeviceList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(mAdapter);
        recyclerView.invalidate();

    }

    public void autologin() {
        HashMap<String, Object> body = new HashMap<>();
        body.put("deviceToken", CommonData.getFCMToken());
        body.put("deviceType", AppConstant.DEVICE_TYPE);
        Call<Data> call = ApiCaller.getApiInterface().accesstokenlogin(CommonData.getAccessToken(), body);
        call.enqueue(new Callback<Data>() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onResponse(Call<Data>

                                           call, Response<Data> response) {
                if (response.isSuccessful()) {
                    //Log.d("Token",response.body().getAccessToken());
                    CommonData.saveAccessToken("Bearer " + response.body().getAccessToken());
                    CommonData.saveRegisterationData(response.body());
                    recreate();



                } else {


                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Log.d("err", t.getMessage());
                Log.d("SSGS", "dgahAEhAEH");
                Intent intent = new Intent(MyAndroidDevices.this, MainActivity.class);
                startActivity(intent);

            }
        });


    }
}
