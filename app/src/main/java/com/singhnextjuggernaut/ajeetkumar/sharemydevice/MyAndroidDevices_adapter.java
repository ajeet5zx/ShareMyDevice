package com.singhnextjuggernaut.ajeetkumar.sharemydevice;

import android.content.Context;
import android.graphics.ColorSpace;
import android.media.MediaPlayer;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.singhnextjuggernaut.ajeetkumar.sharemydevice.constant.AppConstant;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.DeviceData;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;


/*
CREATED BY AJEET SINGH
*/
public class MyAndroidDevices_adapter extends RecyclerView.Adapter<MyAndroidDevices_adapter.ProductViewHolder> {

    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<DeviceData> deviceList;

    //getting the context and product list with constructor
    public MyAndroidDevices_adapter(Context mCtx, List<DeviceData> deviceList) {
        this.mCtx = mCtx;
        this.deviceList = deviceList;
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
        }
        else {
            status="NOT FREE";
        }
        holder.tv_status.setText(status);
        //holder.tv_owner_name.setText(""+ ((AbstractMap<String,String>) device.getOwnerId()).get("name"));
        holder.tv_sticker_no.setText(""+device.getStickerNo());
        holder.tv_android_version.setText(""+device.getVersion());
        holder.tv_screen_size.setText(""+device.getScreen_size());
        holder.tv_resolution.setText(""+device.getResolution());
        holder.tv_brand_name.setText(""+device.getBrand());
        holder.tv_model_name.setText(""+device.getModel());
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
        }
    }
}

