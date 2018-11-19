package com.hackathon.healthy;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HomeFragment extends Fragment implements View.OnClickListener{

     private Button Bregister, Blogin;
     OnDbOpListener dbOpListener;

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.ButtonRegistrar:
                dbOpListener.dbOperationPerfomed(0);
                break;
            case R.id.ButtonLogin:
            dbOpListener.dbOperationPerfomed(1);
            break;


        }
    }

    public interface  OnDbOpListener
    {
        public void dbOperationPerfomed(int method);
    }


    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


      View view= inflater.inflate(R.layout.fragment_home, container, false);
      Bregister = view.findViewById(R.id.ButtonRegistrar);
      Bregister.setOnClickListener(this);
      Blogin =view.findViewById(R.id.ButtonLogin);
      Blogin.setOnClickListener(this);
      return  view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context;

        try
        {
            dbOpListener =(OnDbOpListener) activity;

        } catch (ClassCastException  e)
        {
            throw  new ClassCastException(activity.toString()+ "must implements the interface method");
        };
    }
}
