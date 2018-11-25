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
    SharedPreferences pref;
//--------------------

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View view =inflater.inflate(R.layout.fragment_login, container, false);

     user_session = new User_Session(getContext());

      password =view.findViewById(R.id.Login_Pass);
      email =view.findViewById(R.id.Login_email);

      pref =getContext().getSharedPreferences(PREFER_NAME,0);

      entrar =view.findViewById(R.id.login);

      entrar.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {


              String user_email=email.getText().toString();
              String user_password =password.getText().toString();

              if((user_email.equals("") || user_password.equals("")))
              {
                  Toast.makeText(getActivity(), "Campos Vazios", Toast.LENGTH_SHORT).show();

              }
              else {
                  String uName = null;
                  String uPassword = null;

                  if (pref.contains("user_email") && pref.contains("user_password")) {
                      uName = pref.getString("user_email", "");
                      uPassword = pref.getString("user_password", "");

                  }

                  if (user_email.equals(uName) && user_password.equals(uPassword)) {

                      user_session.createUserLoginSession(uName,
                              uPassword);

                      Intent i = new Intent(getActivity(), Dashboard.class);
                      startActivity(i);
                      i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                      // Add new Flag to start new Activity
                      i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                      startActivity(i);

                  }
                  else
                  {
                      Toast.makeText(getActivity(), "Esta conta nao existe", Toast.LENGTH_SHORT).show();
                  }
              }

          }
      });

        return view;
    }


}
