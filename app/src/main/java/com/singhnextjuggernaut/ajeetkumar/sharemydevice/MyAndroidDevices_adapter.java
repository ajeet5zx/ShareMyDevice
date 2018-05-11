package com.singhnextjuggernaut.ajeetkumar.sharemydevice;

import android.content.Context;
import android.graphics.ColorSpace;
import android.media.MediaPlayer;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.singhnextjuggernaut.ajeetkumar.sharemydevice.constant.AppConstant;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.DeviceData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.ResponseMessage;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.UserData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.database.CommonData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.retrofit.ApiCaller;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/*
CREATED BY AJEET SINGH
*/
public class MyAndroidDevices_adapter extends RecyclerView.Adapter<MyAndroidDevices_adapter.ProductViewHolder> {

    //this context we will use to inflate the layout
    private Context mCtx;
    private LinearLayout linearLayout;

    //we are storing all the products in a list

    private List<DeviceData> deviceList;



    //getting the context and product list with constructor
    public MyAndroidDevices_adapter(Context mCtx,LinearLayout linearLayout ,List<DeviceData> deviceList) {
        this.mCtx = mCtx;
        this.deviceList = deviceList;
        this.linearLayout=linearLayout;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.android_list_item, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        //getting the product of the specified position
        DeviceData device = deviceList.get(position);


        String status;
        //binding the data with the viewholder views
        if(device.getAvailable()) {
            status="FREE";
            holder.change_device_status.setOnCheckedChangeListener (null);
            holder.change_device_status.setChecked(true);
        }
        else {
            holder.tv_status.setBackgroundResource(R.color.red);
            status="NOT FREE";
            holder.change_device_status.setOnCheckedChangeListener (null);
            holder.change_device_status.setChecked(false);

        }
        holder.tv_status.setText(status);
        //holder.tv_owner_name.setText(""+ ((AbstractMap<String,String>) device.getOwnerId()).get("name"));
        holder.tv_sticker_no.setText(""+device.getStickerNo());
        holder.tv_android_version.setText(""+device.getVersion());
        holder.tv_screen_size.setText(""+device.getScreen_size());
        holder.tv_resolution.setText(""+device.getResolution());
        holder.tv_brand_name.setText(""+device.getBrand());
        holder.tv_model_name.setText(""+device.getModel());



        holder.change_device_status.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton cb, boolean on){
                if(on)
                {   DeviceData deviceData=new DeviceData();
                deviceData.setId(device.getId());
                deviceData.setAvailable(true);

                    changeStatus(deviceData);
                    Snackbar snackbar = Snackbar
                            .make(linearLayout, "Device marked as FREE", Snackbar.LENGTH_LONG);
                    View snackbar_view = snackbar.getView();
                    snackbar_view.setBackgroundResource(R.color.red);
                    snackbar.show();
                }
                else
                {
                    Snackbar snackbar = Snackbar
                            .make(linearLayout, "Device marked Not FREE", Snackbar.LENGTH_LONG);
                    View snackbar_view = snackbar.getView();
                    snackbar_view.setBackgroundResource(R.color.red);
                    snackbar.show();
                }
            }
        });
        if(device.getDeviceCategory().compareTo(AppConstant.DEVICE_CATEGORY_CABLE ) == 0) {
            holder.tv_android_version.setVisibility(View.GONE);
            holder.tv_screen_size.setVisibility(View.GONE);
            holder.tv_resolution.setVisibility(View.GONE);
            holder.tv_owner_name.setVisibility(View.GONE);
            holder.change_device_status.setVisibility(View.VISIBLE);
            holder.tv_current_owner.setText("HELLO");
            holder.tv_owner_name.setText("WOOO");





        } else {

            holder.tv_owner_name.setVisibility(View.GONE);
            holder.change_device_status.setVisibility(View.VISIBLE);


        }
    }


    @Override
    public int getItemCount() {
        return deviceList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView tv_status,tv_owner_name,tv_sticker_no,tv_android_version,tv_screen_size,tv_resolution,tv_brand_name,tv_model_name,tv_current_owner;
        Button request_device_button;
        Switch change_device_status;


        public ProductViewHolder(View itemView) {
            super(itemView);
            tv_status = itemView.findViewById(R.id.status);
            tv_owner_name = itemView.findViewById(R.id.owner_name);
            tv_sticker_no = itemView.findViewById(R.id.sticker_no);
            tv_android_version = itemView.findViewById(R.id.android_version);
            tv_screen_size = itemView.findViewById(R.id.screen_size);
            tv_resolution = itemView.findViewById(R.id.resolution);
            tv_current_owner=itemView.findViewById(R.id.current_owner);
            change_device_status=itemView.findViewById(R.id.change_status);
            tv_brand_name = itemView.findViewById(R.id.brand_name);
            tv_model_name = itemView.findViewById(R.id.model_name);
            request_device_button = itemView.findViewById(R.id.request_button);
            change_device_status = itemView.findViewById(R.id.change_status);

        }
    }
    public void changeStatus(DeviceData deviceData) {
        Call<ResponseMessage> call = ApiCaller.getApiInterface().adddevice(CommonData.getAccessToken(),deviceData);
        call.enqueue(new Callback<ResponseMessage>() {
            @Override
            public void onResponse(Call<ResponseMessage> call, Response<ResponseMessage> response) {
                if(response.isSuccessful()) {
                    Snackbar snackbar = Snackbar
                            .make(linearLayout, "Device marked sucessfully FREE", Snackbar.LENGTH_LONG);
                    View snackbar_view = snackbar.getView();
                    snackbar_view.setBackgroundResource(R.color.red);
                    snackbar.show();
                } else {
                    Snackbar snackbar = Snackbar
                            .make(linearLayout, " loda lelo bc", Snackbar.LENGTH_LONG);
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
    };
}


