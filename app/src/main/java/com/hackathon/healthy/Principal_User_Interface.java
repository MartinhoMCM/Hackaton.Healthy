package com.hackathon.healthy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Principal_User_Interface extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal__user__interface);


    }


    public void Entrar(View view)
    {
        Intent intent = new Intent(Principal_User_Interface.this, MainActivity.class);
        startActivity(intent);
    }


}
