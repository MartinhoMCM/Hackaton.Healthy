package com.hackathon.healthy;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity  implements HomeFragment.OnDbOpListener , Father_Fragment.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(findViewById(R.id.fragment_container)!=null)
        {
            if(savedInstanceState!=null)
            {
                return;
            }
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new HomeFragment()).commit();
        }
    }

    @Override
    public void dbOperationPerfomed(int method) {

        if(method==0)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Father_Fragment()).addToBackStack(null).commit();

        }
        else if(method==1)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LoginFragment()).addToBackStack(null).commit();
        }

    }

    @Override
    public void onRssItemSelected(int methodo) {


        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SonFragment()).addToBackStack(null).commit();

    }
}
