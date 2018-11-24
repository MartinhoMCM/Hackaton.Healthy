package com.hackathon.healthy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SonFragment extends Fragment implements View.OnClickListener {

    Button Bconcluir;
    TextView textView1;
    public  String father_name, mother_name, morada, user_name, user_email, user_password;

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    public EditText babyname, babyage, babysex;

    private  SendRegisteredData send;

    public interface SendRegisteredData
    {
       void SendRegisteredData_to_Login();

    }

    public SonFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view= inflater.inflate(R.layout.fragment_son, container, false);
        textView1 =view.findViewById(R.id.text_son);
        final Bundle bundle =getArguments();
        father_name=bundle.getString("father_name");
        mother_name=bundle.getString("mother_name");
        user_name=bundle.getString("user_name");
        morada =bundle.getString("morada");
        user_email=bundle.getString("user_email");
        user_password=bundle.getString("user_password");


        textView1.setText(getString(R.string.ola) + " " + user_name + " " +getString(R.string.comma)+ " "+getString(R.string.preencha));
        babyname = view.findViewById(R.id.babyname);
        babyage=view.findViewById(R.id.babyage);
        babysex =view.findViewById(R.id.babysex);

        // Criando o ficheiro SharedPreference  para informacao ser armazenada

        pref =getActivity().getSharedPreferences("Registration", 0);
        editor =pref.edit();

        Bconcluir =view.findViewById(R.id.registrar);
        Bconcluir.setOnClickListener(this);
        return  view;
    }

    @Override
    public void onClick(View v) {

        String baby_name=babyname.getText().toString();
        String baby_age=babyage.getText().toString();
        String baby_sex=babysex.getText().toString();

        if(baby_age.compareToIgnoreCase("")==0 || baby_name.compareToIgnoreCase("")==0 || baby_sex.compareToIgnoreCase("")==0)
        {
            Toast.makeText(getContext(), "Campos vazios, por favor preencha", Toast.LENGTH_SHORT).show();
        }
        else{
            editor.putString("father_name", father_name);
            editor.putString("mother_name", mother_name);
            editor.putString("user_name", user_name);
            editor.putString("morada", morada);
            editor.putString("user_email", user_email);
            editor.putString("user_password", user_password);
            editor.putString("baby_name", baby_name);
            editor.putString("baby_sex", baby_sex);
            editor.putString("baby_age", baby_age);
            editor.commit();
            babyname.setText("");
            babysex.setText("");
            babyage.setText("");

            send.SendRegisteredData_to_Login();
            Toast.makeText(getContext(), "Registrado com sucesso", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SendRegisteredData) {
            send = (SendRegisteredData) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement MyListFragment.OnItemSelectedListener");
        }
    }


}
