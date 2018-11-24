package com.hackathon.healthy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Dashboard_Alerta extends AppCompatActivity {

    TextView heading;
    TextView description;
    private  RecyclerView.Adapter myAdapter;
    private RecyclerView recyclerView;
    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard__alerta);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();
        for (int i = 0; i <10; i++) {

            switch (i)
            {
                case 0: ListItem listItem0 = new ListItem("Vacina Pólio - Zero Dose ", "Faltam x dias");
                    listItems.add(listItem0);
                break;
                case 1: ListItem listItem1= new ListItem("Vacina Pólio - Dose Única", "Faltam x dias");
                    listItems.add(listItem1);
                break;
                case 2: ListItem listItem2 = new ListItem("Vacina Pólio - Dose a Nascença ", "Faltam x dias");
                    listItems.add(listItem2);
                break;
                case 3: ListItem listItem3 = new ListItem("Vacina Pólio - 1ª Dose  ", "Faltam x dias");
                    listItems.add(listItem3);
                case 4: ListItem listItem4= new ListItem("Vacina Pentavalente -  1ª Dose ", "Faltam x dias");
                    listItems.add(listItem4);
                case 5: ListItem listItem5 = new ListItem("Vacina Pneump - 1ª Dose ", "Faltam x dias");
                    listItems.add(listItem5);
                case 6: ListItem listItem6 = new ListItem("Vacina Rotavírus - 1º Única ", "Faltam x dias");
                    listItems.add(listItem6);
                case 7: ListItem listItem7 = new ListItem("Vacina Dose Única ", "Faltam x dias");
                    listItems.add(listItem7);
                case 8: ListItem listItem8 = new ListItem("Vacina Dose Única ", "Faltam x dias");
                    listItems.add(listItem8);
                case 9: ListItem listItem9 = new ListItem("Vacina Dose Única ", "Faltam x dias");
                    listItems.add(listItem9);
                    break;
            }

           // ListItem listItem = new ListItem("Heading" + i++, "Lorem inpsum text");
           // listItems.add(listItem);
        }
        myAdapter = new MyAdapter(listItems, this);
        recyclerView.setAdapter(myAdapter);
    }
}

