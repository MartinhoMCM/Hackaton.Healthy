package com.hackathon.healthy;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HomeFragment extends Fragment {

    public static FragmentManager fragmentManager;

    Button Bregister, Blogin;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


      View view= inflater.inflate(R.layout.fragment_home, container, false);

      Bregister = view.findViewById(R.id.ButtonRegistrar);

      Bregister.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new Father_Fragment(), null).commit();

          }
      });

      return  view;
    }


}
