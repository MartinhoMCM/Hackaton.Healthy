package com.hackathon.healthy;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Dashboard extends AppCompatActivity{

    FloatingActionButton floatingActionButton;

    @Override
    protected void onPause() {
        super.onPause();
    }


    private ImageButton imageButton1, imageButton2;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        drawerLayout =(DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ShowLog("Oncreate finish");

    }

    @Override
    protected void onStart() {
        super.onStart();
        ShowLog("OnStart finish...");

    }

    @Override
    protected void onResume() {
        super.onResume();
        ShowLog("OnResume finish");
    }

    @Override
    protected void onStop() {
        super.onStop();
        ShowLog("onStop finish");
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

      if(actionBarDrawerToggle.onOptionsItemSelected(item))
          return true;
        return super.onOptionsItemSelected(item);
    }


    public void Entrar(View view)
    {
        Intent intent = new Intent(Dashboard.this, Dashboard_Alerta.class);
        startActivity(intent);
        finish();
    }


    public  void BotaoCalendar(View   view)
    {
        startActivity(new Intent(this, Dashboard_Calendar.class));
        finish();
    }
    public void ShowLog(String mensage)
    {
        Log.d("Lifecycle", mensage);
    }

    public void Nova_Cardeneta(View view) {
    }
}
