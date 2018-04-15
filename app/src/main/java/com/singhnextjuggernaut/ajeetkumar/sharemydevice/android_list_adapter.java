package com.singhnextjuggernaut.ajeetkumar.sharemydevice;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/*
CREATED BY AJEET SINGH
*/public class android_list_adapter extends RecyclerView.Adapter<android_list_adapter.ProductViewHolder> {

    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private ArrayList<device_list> deviceList;

    //getting the context and product list with constructor
    public android_list_adapter(Context mCtx, ArrayList<device_list> deviceList) {
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
            device_list device = deviceList.get(position);

        String status;
        //binding the data with the viewholder views
        if(device.isStatus()) {

        status="FREE";
        }
        else {
        status="NOT FREE";
        }

        holder.status.setText(status);
        holder.tvowner.setText(device.getOwner_name());
        holder.tvstickerno.setText(device.getSticker_no()+"");
        holder.tyversion.setText(device.getVersion());
        holder.scree.setText(device.getScreen_size());
        holder.reso.setText(device.getResolution());
        holder.brand.setText(device.getBrand());
        holder.model.setText(device.getModel());
        holder.ibt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }


    @Override
    public int getItemCount() {
        return deviceList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView status,tvowner,tvstickerno,tyversion,scree,reso,brand,model;
        ImageButton ibt;

        public ProductViewHolder(View itemView) {
            super(itemView);
            status = itemView.findViewById(R.id.status);
            tvowner = itemView.findViewById(R.id.owner_name);
            tvstickerno = itemView.findViewById(R.id.sticker_no);
            tyversion = itemView.findViewById(R.id.android_version);
            scree = itemView.findViewById(R.id.screen_size);
            reso = itemView.findViewById(R.id.resolution);
            brand = itemView.findViewById(R.id.brand_name);
            model = itemView.findViewById(R.id.model_name);
            ibt = itemView.findViewById(R.id.request_button);
        }
    }
}
