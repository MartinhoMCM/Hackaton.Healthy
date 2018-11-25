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

public class SonFragment extends Fragment implements  View.OnClickListener{

    Button Bconcluir;
    TextView textView1;
    public  String father_name, mother_name, morada, user_name, user_email, user_password;

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    public EditText baby_name, baby_age, baby_sex, baby_birth;

    public SendRegisteredData send;
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

        // Criando o ficheiro SharedPreference  para informacao ser armazenada

        baby_name = view.findViewById(R.id.baby_name);
        baby_age=view.findViewById(R.id.baby_age);
        baby_sex =view.findViewById(R.id.baby_sex);
        baby_birth =view.findViewById(R.id.baby_birth);

        pref =getContext().getSharedPreferences("Registration", 0);
        editor =pref.edit();
        Bconcluir =view.findViewById(R.id.registrar);
        Bconcluir.setOnClickListener(this);
        return  view;
    }

    @Override
    public void onClick(View view) {

        // Criando o ficheiro SharedPreference  para informacao ser armazenada

        pref =getActivity().getSharedPreferences("Registration", 0);
        editor =pref.edit();

                String Baby_name = baby_name.getText().toString();
                String Baby_age = baby_age.getText().toString();
                String Baby_sex = baby_sex.getText().toString();
                String Baby_birth=baby_birth.getText().toString();

                if (Baby_age.length() <= 0) {
                    Toast.makeText(getActivity(), "Introduza o campo idade", Toast.LENGTH_SHORT).show();
                } else if (Baby_name.length() <= 0) {
                    Toast.makeText(getActivity(), "Introduza o campo nome", Toast.LENGTH_SHORT).show();

                } else if (Baby_sex.length() <= 0) {
                    Toast.makeText(getActivity(), "Introduza o campo sexo", Toast.LENGTH_SHORT).show();
                }
                else if(Baby_birth.length()<=0)
                {
                    Toast.makeText(getActivity(), "Introduza o campo nascimento", Toast.LENGTH_SHORT).show();
                }
                    else {
                    editor.putString("father_name", father_name);
                    editor.putString("mother_name", mother_name);
                    editor.putString("user_name", user_name);
                    editor.putString("morada", morada);
                    editor.putString("user_email", user_email);
                    editor.putString("user_password", user_password);
                    editor.putString("baby_name", Baby_name);
                    editor.putString("baby_age", Baby_age);
                    editor.putString("baby_sex", Baby_sex);
                    editor.putString("baby_birth", Baby_birth);
                    editor.commit();


                    send.SendRegisteredData_to_Login();
                    Toast.makeText(getActivity(), "Registrado com sucesso", Toast.LENGTH_SHORT).show();


                }

            }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof SendRegisteredData)
        {
            send =(SendRegisteredData) context;

        }
        else
        {
            throw new ClassCastException(context.toString());
        }
    }
}

