package com.hackathon.healthy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginFragment extends Fragment{

    EditText password, email;
    Button entrar;

    // ------SharedPreference variables

    public static final String PREFER_NAME="Registration";
    User_Session user_session;
    SharedPreferences sharedPreferences;
//--------------------

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View view =inflater.inflate(R.layout.fragment_login, container, false);

       password =view.findViewById(R.id.Login_Pass);
       email =view.findViewById(R.id.Login_email);

       entrar =view.findViewById(R.id.login);

       //Toast.makeText(getActivity(), "Estado de login: "+user_session.isUserLoggedIn(), Toast.LENGTH_SHORT).show();

        sharedPreferences = getActivity().getSharedPreferences(PREFER_NAME, Context.MODE_PRIVATE);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(password.getText().toString().trim().length()>0 && email.getText().toString().trim().length()>0) {
                    String U_email = null;
                    String U_password = null;

                    if (sharedPreferences.contains("user_email")) {
                        U_email = sharedPreferences.getString("user_email", "");
                    }
                    if (sharedPreferences.contains("user_password")) {
                        U_password = sharedPreferences.getString("user_password", "");
                    }

                    if (password.getText().toString().equals(U_password) && email.getText().toString().equals(U_email)) {
                        user_session.createUserLoginSession(U_email, U_password);
                        Intent i = new Intent(getActivity(), Dashboard.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(i);


                    } else {

                        // username / password doesn't match&
                        Toast.makeText(getContext(),
                                "Email ou Palavra Passe errada",
                                Toast.LENGTH_LONG).show();
                    }
                }
                    else{

                    // user didn't entered username or password
                    Toast.makeText(getContext(),
                            "Campos vazios",
                            Toast.LENGTH_LONG).show();

                }
                }

        });

        return view;
    }


}
