package com.hackathon.healthy;

import android.content.Context;
import android.content.Intent;
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

public class SonFragment extends Fragment {

    Button Bconcluir;
    TextView textView1;
    public  String father_name, father_email, father_password;

    public EditText babyname, babyidade, babysexo;

    public SonFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_son, container, false);
        textView1 =view.findViewById(R.id.father);
        final Bundle bundle =getArguments();
        father_name=bundle.getString("fathername");
        father_email=bundle.getString("fatheremail");
        father_password=bundle.getString("fatherpassword");
        textView1.setText("Olá "+father_name +" ,");

        babyname = view.findViewById(R.id.babyname);
        babyidade=view.findViewById(R.id.babyidade);
        babysexo =view.findViewById(R.id.babysexo);


        Bconcluir =view.findViewById(R.id.registrar);

        Bconcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String baby_name=babyname.getText().toString();
                String baby_idade=babyidade.getText().toString();
                String baby_sexo=babysexo.getText().toString();
                if(baby_idade.compareToIgnoreCase("")==0 || baby_name.compareToIgnoreCase("")==0 || baby_sexo.compareToIgnoreCase("")==0)
                {
                    Toast.makeText(getContext(), "Campos vazios, por favor preencha", Toast.LENGTH_SHORT).show();
                }

             else{
                    ContactManagerHelper contactManagerHelper = new ContactManagerHelper(getActivity());
                    SQLiteDatabase sqLiteDatabase = contactManagerHelper.getWritableDatabase();

           Boolean ins=contactManagerHelper.Insert(father_name, father_email, father_name, baby_name, baby_idade, baby_sexo, sqLiteDatabase);
            contactManagerHelper.close();
            babyname.setText("");
            babysexo.setText("");
            babyidade.setText("");
                    Toast.makeText(getContext(), "Registrado com sucesso", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return  view;
    }

}
