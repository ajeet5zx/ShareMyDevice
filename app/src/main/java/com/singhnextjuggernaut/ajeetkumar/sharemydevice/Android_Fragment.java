package com.singhnextjuggernaut.ajeetkumar.sharemydevice;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.DeviceData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.database.CommonData;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Android_Fragment extends Fragment {

    List<DeviceData> devices;
    RecyclerView recyclerView;

    public Android_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview=inflater.inflate(R.layout.fragment_android_, container, false);
        //getting the recyclerview from xml
        recyclerView = (RecyclerView) rootview.findViewById(R.id.android_tab_recycler);
        //recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //initializing the productlist
        devices = CommonData.getAndroidList();

        //creating recyclerview adapter
        android_list_adapter adapter = new android_list_adapter(getActivity(),devices);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);


        return rootview;


    }

}
