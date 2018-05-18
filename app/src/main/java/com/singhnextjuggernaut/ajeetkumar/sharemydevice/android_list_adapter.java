package com.singhnextjuggernaut.ajeetkumar.sharemydevice;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.internal.LinkedHashTreeMap;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.constant.AppConstant;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.DeviceData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.ResponseMessage;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.UserData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.database.CommonData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.retrofit.ApiCaller;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.retrofit.ApiInterface;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
CREATED BY AJEET SINGH
*/
public class android_list_adapter extends RecyclerView.Adapter<android_list_adapter.ProductViewHolder> {

    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<DeviceData> deviceList;

    //getting the context and product list with constructor
    public android_list_adapter(Context mCtx, List<DeviceData> deviceList) {
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
            holder.tv_status.setBackgroundResource(R.color.red);
        }
        holder.tv_status.setText(status);
        holder.tv_owner_name.setText(""+ ((AbstractMap<String,String>) device.getOwnerId()).get("name"));
        holder.tv_sticker_no.setText(""+device.getStickerNo());
        holder.tv_android_version.setText(""+device.getVersion());
        holder.tv_screen_size.setText(""+device.getScreen_size());
        holder.tv_resolution.setText(""+device.getResolution());
        holder.tv_brand_name.setText(""+device.getBrand());
        holder.tv_model_name.setText(""+device.getModel());
        holder.request_device_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, Object>  body = new HashMap<>();
                body.put("owner_id",((AbstractMap<String, String>) device.getOwnerId()).get("_id"));
                body.put("message","Hi "+((AbstractMap<String, String>) device.getOwnerId()).get("name")+", "+CommonData.getRegisterationData().getUserData().getName()
                        +" has requested for your device with Sticker No-"+((AbstractMap<String, String>) device.getOwnerId()).get("sticker_no"));
                body.put("isAccepted",false);
                body.put("isRequested",true);
                body.put("assignee_id",CommonData.getRegisterationData().getUserData().getId());
                body.put("device_id",device.getId());
                Call<ResponseMessage> device_request = ApiCaller.getApiInterface().deviceNotification(CommonData.getAccessToken(),body);
                device_request.enqueue(new Callback<ResponseMessage>() {
                    @Override
                    public void onResponse(Call<ResponseMessage> call, Response<ResponseMessage> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(mCtx,response.body().getMessage(),Toast.LENGTH_LONG).show();
                        } else {}
                    }

                    @Override
                    public void onFailure(Call<ResponseMessage> call, Throwable t) {

                    }
                });
            }
        });


    }


    @Override
    public int getItemCount() {
        return deviceList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView tv_status,tv_owner_name,tv_sticker_no,tv_android_version,tv_screen_size,tv_resolution,tv_brand_name,tv_model_name;
        Button request_device_button;

        public ProductViewHolder(View itemView) {
            super(itemView);
            tv_status = itemView.findViewById(R.id.status);
            tv_owner_name = itemView.findViewById(R.id.owner_name);
            tv_sticker_no = itemView.findViewById(R.id.sticker_no);
            tv_android_version = itemView.findViewById(R.id.android_version);
            tv_screen_size = itemView.findViewById(R.id.screen_size);
            tv_resolution = itemView.findViewById(R.id.resolution);
            tv_brand_name = itemView.findViewById(R.id.brand_name);
            tv_model_name = itemView.findViewById(R.id.model_name);
            request_device_button = itemView.findViewById(R.id.request_button);
        }
    }
}

