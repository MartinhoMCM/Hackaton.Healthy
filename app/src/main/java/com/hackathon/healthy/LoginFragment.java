package com.hackathon.healthy;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginFragment extends Fragment {


    EditText password, email;
    Button entrar;
    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View view =inflater.inflate(R.layout.fragment_login, container, false);

       email=view.findViewById(R.id.email);
       password=view.findViewById(R.id.password);
       entrar=view.findViewById(R.id.login);
       entrar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getActivity(), Dashboard.class);
               ((MainActivity) getActivity()).startActivity(intent);
           }
       });

       return view;
    }


}
