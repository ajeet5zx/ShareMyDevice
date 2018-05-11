package com.singhnextjuggernaut.ajeetkumar.sharemydevice;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Switch;

import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.DeviceData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.database.CommonData;

import java.util.List;

public class MyAndroidDevices extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<DeviceData> myDeviceList;
    private MyAndroidDevices_adapter mAdapter;
    private ImageButton adddevice;
    private LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_android_devices);
        adddevice = findViewById(R.id.android_add_button);
        adddevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyAndroidDevices.this, Add_devices.class);
                startActivity(intent);
            }
        });
        linearLayout=findViewById(R.id.my_android_devices);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_android_devices_recycler);
        myDeviceList = CommonData.getRegisterationData().getDeviceData();
        mAdapter = new MyAndroidDevices_adapter(MyAndroidDevices.this,linearLayout,myDeviceList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);




    }
}
