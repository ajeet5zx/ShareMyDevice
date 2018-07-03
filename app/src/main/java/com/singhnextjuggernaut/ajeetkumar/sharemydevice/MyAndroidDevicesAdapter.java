package com.singhnextjuggernaut.ajeetkumar.sharemydevice;

import android.content.Context;
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
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.singhnextjuggernaut.ajeetkumar.sharemydevice.constant.AppConstant;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.Data;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.DeviceData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.ResponseMessage;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.database.CommonData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.retrofit.ApiCaller;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/*
CREATED BY AJEET SINGH
*/
public class MyAndroidDevicesAdapter extends RecyclerView.Adapter<MyAndroidDevicesAdapter.ProductViewHolder> {

    //this context we will use to inflate the layout
    private Context mCtx;
    private LinearLayout linearLayout;
    //SwipeRefreshLayout swiper;

    //we are storing all the products in a list

    private List<DeviceData> deviceList;


    //getting the context and product list with constructor
    public MyAndroidDevicesAdapter(Context mCtx, LinearLayout linearLayout, List<DeviceData> deviceList) {
        this.mCtx = mCtx;
        this.deviceList = deviceList;
        this.linearLayout = linearLayout;
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
        if (device.getAvailable()) {
            status = "FREE";
            holder.change_device_status.setOnCheckedChangeListener(null);
            holder.change_device_status.setChecked(true);
            holder.tv_status.setBackgroundResource(R.color.green);
        } else {
            holder.tv_status.setBackgroundResource(R.color.red);
            status = "NOT FREE";
            holder.change_device_status.setOnCheckedChangeListener(null);
            holder.change_device_status.setChecked(false);

        }

        holder.tv_status.setText(status);
        //holder.tv_owner_name.setText(""+ ((AbstractMap<String,String>) device.getOwnerId()).get("name"));
        holder.tv_sticker_no.setText("" + device.getStickerNo());
        holder.tv_android_version.setText("" + device.getVersion());
        holder.tv_screen_size.setText("" + device.getScreen_size());
        holder.tv_resolution.setText("" + device.getResolution());
        holder.tv_brand_name.setText("" + device.getBrand());
        holder.tv_model_name.setText("" + device.getModel());
        holder.status_message.setText("Change status");


        holder.change_device_status.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton cb, boolean on) {
                String status;
                if (on) {
                    DeviceData deviceData = new DeviceData();
                    deviceData.setId(device.getId());
                    deviceData.setAvailable(true);
                    deviceList.get(position).setAvailable(true);
                    changeStatus(deviceData);
                    Snackbar snackbar = Snackbar
                            .make(linearLayout, "Device marked as FREE", Snackbar.LENGTH_LONG);
                    View snackbar_view = snackbar.getView();
                    snackbar_view.setBackgroundResource(R.color.green);
                    snackbar.show();

                    status = "FREE";
                    holder.tv_status.setBackgroundResource(R.color.green);
                    holder.tv_status.setText(status);


                } else {

                    DeviceData deviceData = new DeviceData();
                    deviceData.setId(device.getId());
                    deviceData.setAvailable(false);
                    deviceList.get(position).setAvailable(false);
                    changeStatus(deviceData);
                    Snackbar snackbar = Snackbar
                            .make(linearLayout, "Device marked as BUSY", Snackbar.LENGTH_LONG);
                    View snackbar_view = snackbar.getView();
                    snackbar_view.setBackgroundResource(R.color.red);
                    snackbar.show();

                    status = "NOT FREE";
                    holder.tv_status.setText(status);
                    holder.tv_status.setBackgroundResource(R.color.red);
                }
                Data data = CommonData.getRegisterationData();
                data.setDeviceData(deviceList);
                CommonData.saveRegisterationData(data);
            }
        });


        if (device.getDeviceCategory().compareTo(AppConstant.DEVICE_CATEGORY_CABLE) == 0) {
            holder.tv_android_version.setVisibility(View.GONE);
            holder.tv_screen_size.setVisibility(View.GONE);
            holder.tv_resolution.setVisibility(View.GONE);
            holder.tv_owner_name.setVisibility(View.GONE);
            holder.change_device_status.setVisibility(View.VISIBLE);


            holder.return_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HashMap<String, Object> body = new HashMap<>();
                    body.put("owner_id", ((AbstractMap<String, String>) device.getOwnerId()).get("_id"));
                    body.put("message", "Hi " + ((AbstractMap<String, String>) device.getOwnerId()).get("name") + ", " + CommonData.getRegisterationData().getUserData().getName()
                            + " has returned your device with Sticker No-" + device.getStickerNo());
                    body.put("isAccepted", false);
                    body.put("isRequested", true);
                    body.put("device_id", device.getId());
                    Call<ResponseMessage> device_request = ApiCaller.getApiInterface().ReturnDevice(CommonData.getAccessToken(), body);
                    device_request.enqueue(new Callback<ResponseMessage>() {
                        @Override
                        public void onResponse(Call<ResponseMessage> call, Response<ResponseMessage> response) {
                            if (response.isSuccessful()) {

                                Toast.makeText(mCtx, "Return request made!!", Toast.LENGTH_LONG).show();
                            } else {
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseMessage> call, Throwable t) {

                        }
                    });
                }
            });


        } else {

            holder.tv_owner_name.setVisibility(View.GONE);
            holder.change_device_status.setVisibility(View.VISIBLE);
            holder.return_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HashMap<String, Object> body = new HashMap<>();
                    body.put("owner_id", ((AbstractMap<String, String>) device.getOwnerId()).get("_id"));
                    body.put("message", "Hi " + ((AbstractMap<String, String>) device.getOwnerId()).get("name") + ", " + CommonData.getRegisterationData().getUserData().getName()
                            + " has returned your device with Sticker No-" + device.getStickerNo());
                    body.put("isAccepted", false);
                    body.put("isRequested", true);
                    body.put("device_id", device.getId());
                    Call<ResponseMessage> device_request = ApiCaller.getApiInterface().ReturnDevice(CommonData.getAccessToken(), body);
                    device_request.enqueue(new Callback<ResponseMessage>() {
                        @Override
                        public void onResponse(Call<ResponseMessage> call, Response<ResponseMessage> response) {
                            if (response.isSuccessful()) {
                                MyAndroidDevices activity = MyAndroidDevices.instance;

                                if (activity != null) {
                                    // we are calling here activity's method
                                    activity.autologin();
                                }

                                Toast.makeText(mCtx, "Return request made!!", Toast.LENGTH_LONG).show();
                            } else {
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseMessage> call, Throwable t) {

                        }
                    });
                }
            });


        }


        if (device.getAssigneeId() != null && ((AbstractMap<String, String>) device.getAssigneeId()).get("_id") != null) {
            Log.v("if", "if");
            holder.tv_current_owner.setText("" + ((AbstractMap<String, String>) device.getAssigneeId()).get("name"));

            if ((((AbstractMap<String, String>) device.getOwnerId()).get("_id")).compareTo(CommonData.getRegisterationData().getUserData().getId()) != 0) {
                holder.upper_cardview.setCardBackgroundColor(mCtx.getResources().getColor(R.color.grey));
                holder.change_device_status.setVisibility(View.GONE);
                holder.return_button.setVisibility(View.VISIBLE);
                holder.status_message.setText("return device!!");
                // holder.bottom_cardview.setVisibility(View.INVISIBLE);
//                RelativeLayout.LayoutParams parms = new RelativeLayout.LayoutParams(0,0);
//                holder.bottom_layout.setLayoutParams(parms);
                holder.bottom_layout.setVisibility(View.GONE);
                holder.swipe_card.setVisibility(View.INVISIBLE);
                holder.return_device_button.setVisibility(View.GONE);


            } else {
                Log.v("else", "else");
                // holder.tv_current_owner.setText("" + ((AbstractMap<String, String>) device.getOwnerId()).get("name"));
                holder.bottom_cardview.setVisibility(View.INVISIBLE);
                holder.swipe_card.setVisibility(View.INVISIBLE);
//                RelativeLayout.LayoutParams parms = new RelativeLayout.LayoutParams(0,0);
//                holder.bottom_layout.setLayoutParams(parms);
                holder.bottom_layout.setVisibility(View.GONE);
                holder.upper_cardview.setCardBackgroundColor(mCtx.getResources().getColor(R.color.colorPrimary));
                holder.return_device_button.setVisibility(View.GONE);
                String s1, s2;
                s1 = "" + ((AbstractMap<String, String>) device.getAssigneeId()).get("name");
                s2 = "" + ((AbstractMap<String, String>) device.getOwnerId()).get("name");
                int x = s1.compareTo(s2);
                if (x != 0)

                {
                    holder.change_device_status.setVisibility(View.GONE);
                    holder.tv_owner_name.setVisibility(View.VISIBLE);
                    holder.status_message.setText("Message");
                    holder.tv_owner_name.setText("Your is assigned!!");
                }
            }
        }
    }


    @Override
    public int getItemCount() {
        return deviceList.size();
    }

    public void changeStatus(DeviceData deviceData) {
        Call<ResponseMessage> call = ApiCaller.getApiInterface().updateDeviceStatus(CommonData.getAccessToken(), deviceData);
        call.enqueue(new Callback<ResponseMessage>() {
            @Override
            public void onResponse(Call<ResponseMessage> call, Response<ResponseMessage> response) {
                if (response.isSuccessful()) {
//                    Snackbar snackbar = Snackbar
//                            .make(linearLayout, "Device status changed", Snackbar.LENGTH_LONG);
//                    View snackbar_view = snackbar.getView();
//                    snackbar_view.setBackgroundResource(R.color.green);
//                    snackbar.show();

                } else {
                    Snackbar snackbar = Snackbar
                            .make(linearLayout, " ", Snackbar.LENGTH_LONG);
                    View snackbar_view = snackbar.getView();
                    snackbar_view.setBackgroundResource(R.color.red);
                    snackbar.show();
                }
            }

            @Override
            public void onFailure(Call<ResponseMessage> call, Throwable t) {
                Log.d("err", t.getMessage());
            }
        });
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView status_message, tv_status, tv_owner_name, tv_sticker_no, tv_android_version, tv_screen_size, tv_resolution, tv_brand_name, tv_model_name, tv_current_owner;
        Button return_device_button;
        CardView bottom_cardview, upper_cardview;
        LinearLayout swipe_card;
        Switch change_device_status;
        RelativeLayout bottom_layout;
        ImageView return_button;


        public ProductViewHolder(View itemView) {
            super(itemView);
            bottom_layout = itemView.findViewById(R.id.android_item_bottom_view_relative);
            tv_status = itemView.findViewById(R.id.status);
            tv_owner_name = itemView.findViewById(R.id.owner_name);
            tv_sticker_no = itemView.findViewById(R.id.sticker_no);
            tv_android_version = itemView.findViewById(R.id.android_version);
            tv_screen_size = itemView.findViewById(R.id.screen_size);
            tv_resolution = itemView.findViewById(R.id.resolution);
            tv_current_owner = itemView.findViewById(R.id.current_owner);
            change_device_status = itemView.findViewById(R.id.change_status);
            tv_brand_name = itemView.findViewById(R.id.brand_name);
            tv_model_name = itemView.findViewById(R.id.model_name);
            return_device_button = itemView.findViewById(R.id.request_button);
            change_device_status = itemView.findViewById(R.id.change_status);
            bottom_cardview = itemView.findViewById(R.id.android_item_bottom_view_card);
            upper_cardview = itemView.findViewById(R.id.android_list_item_cardview);
            swipe_card = itemView.findViewById(R.id.swipe_bar);
            return_button = itemView.findViewById(R.id.return_button);
            status_message = itemView.findViewById(R.id.status_message);

        }
    }

}


