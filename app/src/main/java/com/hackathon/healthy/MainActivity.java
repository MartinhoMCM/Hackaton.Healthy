package com.hackathon.healthy;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity  implements HomeFragment.OnDbOpListener , Father_Fragment.OnItemSelectedListener, SonFragment.SendRegisteredData{

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
    public void onRssItemSelected(String father_name, String mother_name, String user_name, String morada, String email, String fatherpass) {

      SonFragment sonFragment = new SonFragment();
        Bundle bundle = new Bundle();
        bundle.putString("father_name", father_name);
        bundle.putString("mother_name", mother_name);
        bundle.putString("user_name", user_name);
        bundle.putString("morada", morada);
        bundle.putString("user_email", email);
        bundle.putString("user_password", fatherpass);
        sonFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, sonFragment, null).addToBackStack(null).commit();
    }


    @Override
    public void SendRegisteredData_to_Login() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LoginFragment()).addToBackStack(null).commit();

    }
}
