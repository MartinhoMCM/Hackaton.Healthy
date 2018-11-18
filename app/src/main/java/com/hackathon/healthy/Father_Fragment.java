package com.hackathon.healthy;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Father_Fragment extends Fragment {

    Button BSave;
    public Father_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this f ragment
       View view= inflater.inflate(R.layout.fragment_father_, container, false);


      BSave.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new SonFragment(), null).commit();
          }
      });

       return  view;


    }


}
