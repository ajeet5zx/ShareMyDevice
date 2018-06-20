package com.singhnextjuggernaut.ajeetkumar.sharemydevice;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.singhnextjuggernaut.ajeetkumar.sharemydevice.constant.AppConstant;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.DeviceData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.ResponseMessage;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.database.CommonData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.retrofit.ApiCaller;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.utils.Validations.Utils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddDevices extends AppCompatActivity {
    private EditText et_brand, et_model, et_sticker_no, et_os_version, et_screen_resolution, et_screen_size;
    private TextView et_os_version_text, et_screen_resolution_text, et_screen_size_text;
    private Button save_data;
    private Spinner device_categories;
    private LinearLayout linearLayout;
    private String device_category;
    private String  brand, model, sticker_no, os_version, screen_resolution, screen_size;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_devices);
        device_category = AppConstant.DEVICE_CATEGORY_ANDROID;
        et_brand = findViewById(R.id.Device_brand);
        et_model = findViewById(R.id.device_model);
        et_sticker_no = findViewById(R.id.device_stickerid);
        et_os_version = findViewById(R.id.device_os_version);
        et_screen_resolution = findViewById(R.id.device_resolution);
        et_screen_size = findViewById(R.id.device_screen_size);

        et_os_version_text=findViewById(R.id.device_os_version_text);
        et_screen_resolution_text=findViewById(R.id.device_resolution_text);
        et_screen_size_text=findViewById(R.id.screen_size_text);

        device_categories = findViewById(R.id.add_device_category);
        save_data = findViewById(R.id.device_save);
        linearLayout=findViewById(R.id.linear_layout_add_devices);

        ArrayList<String> categories = new ArrayList<>();
        categories.add(AppConstant.DEVICE_CATEGORY_ANDROID);
        categories.add(AppConstant.DEVICE_CATEGORY_IOS);
        categories.add(AppConstant.DEVICE_CATEGORY_CABLE);

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        device_categories.setAdapter(dataAdapter);

        device_categories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0 || position == 1) {
                    et_os_version.setVisibility(View.VISIBLE);
                    et_screen_resolution.setVisibility(View.VISIBLE);
                    et_screen_size.setVisibility(View.VISIBLE);
                    et_os_version_text.setVisibility(View.VISIBLE);
                    et_screen_resolution_text.setVisibility(View.VISIBLE);
                    et_screen_size_text.setVisibility(View.VISIBLE);
                    device_category = position == 0 ? AppConstant.DEVICE_CATEGORY_ANDROID : AppConstant.DEVICE_CATEGORY_IOS;
                } else {
                    et_os_version.setVisibility(View.GONE);
                    et_screen_resolution.setVisibility(View.GONE);
                    et_screen_size.setVisibility(View.GONE);
                    device_category = AppConstant.DEVICE_CATEGORY_CABLE;

                    et_os_version_text.setVisibility(View.GONE);
                    et_screen_resolution_text.setVisibility(View.GONE);
                    et_screen_size_text.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        save_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeviceData deviceData = new DeviceData();
                brand=et_brand.getText().toString();
                model=et_model.getText().toString();
                sticker_no=et_sticker_no.getText().toString();
                os_version=et_os_version.getText().toString();
                screen_resolution=et_screen_resolution.getText().toString();
                screen_size=et_screen_size.getText().toString();
                if( device_category.compareTo(AppConstant.DEVICE_CATEGORY_CABLE) == 0 ) {
                    if(Utils.chkLength(brand,1) && Utils.chkLength(model,1) && Utils.chkLength(sticker_no,1)) {
                        deviceData.setBrand(brand);
                        deviceData.setModel(model);
                        deviceData.setStickerNo(sticker_no);
                        deviceData.setDeviceCategory(device_category);
                        deviceData.setDeviceToken(CommonData.getFCMToken());
                        deviceData.setDeviceType(AppConstant.DEVICE_TYPE);

                        addDeviceData(deviceData);
                    } else {
                        Snackbar snackbar = Snackbar
                                .make(linearLayout, "All fields are required!", Snackbar.LENGTH_LONG);
                        View snackbar_view = snackbar.getView();
                        snackbar_view.setBackgroundResource(R.color.red);
                        snackbar.show();
                    }

                } else {
                    if(Utils.chkLength(brand,1) && Utils.chkLength(model,1) && Utils.chkLength(sticker_no,1) && Utils.chkLength(os_version,1) && Utils.chkLength(screen_resolution,1) && Utils.chkLength(screen_size,1)) {
                        deviceData.setBrand(brand);
                        deviceData.setModel(model);
                        deviceData.setStickerNo(sticker_no);
                        deviceData.setResolution(screen_resolution);
                        deviceData.setScreen_size(screen_size);
                        deviceData.setVersion(os_version);

                        deviceData.setDeviceCategory(device_category);
                        deviceData.setDeviceToken(CommonData.getFCMToken());
                        deviceData.setDeviceType(AppConstant.DEVICE_TYPE);

                        addDeviceData(deviceData);
                    } else {
                        //all fields are mandetory
                        Snackbar snackbar = Snackbar
                                .make(linearLayout, "All fields are required!", Snackbar.LENGTH_LONG);
                        View snackbar_view = snackbar.getView();
                        snackbar_view.setBackgroundResource(R.color.red);
                        snackbar.show();

                    }
                }
            }
        });

    }

    public void addDeviceData(DeviceData deviceData) {
        Call<ResponseMessage> call = ApiCaller.getApiInterface().adddevice(CommonData.getAccessToken(),deviceData);
        call.enqueue(new Callback<ResponseMessage>() {
            @Override
            public void onResponse(Call<ResponseMessage> call, Response<ResponseMessage> response) {
                if(response.isSuccessful()) {


                    Snackbar snackbar = Snackbar
                            .make(linearLayout, "Device added sucessfully", Snackbar.LENGTH_LONG);
                    View snackbar_view = snackbar.getView();
                    snackbar_view.setBackgroundResource(R.color.green);
                    snackbar.show();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(AddDevices.this, HomeActivity.class);
                            startActivity(intent);
                        }
                    }, 1700);
                    //



                } else {
                    Snackbar snackbar = Snackbar
                            .make(linearLayout, "Please check your connection or restart", Snackbar.LENGTH_LONG);
                    View snackbar_view = snackbar.getView();
                    snackbar_view.setBackgroundResource(R.color.red);
                    snackbar.show();
                }
            }

            @Override
            public void onFailure(Call<ResponseMessage> call, Throwable t) {
                Log.d("err",t.getMessage());
            }
        });
    }
}

