package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import package1.ActivityAddome;
import package1.ActivityBicipiti;
import package1.ActivityFemorali;
import package1.ActivityPetto;
import package1.ActivityPolpacci;
import package1.ActivityQuadricipiti;
import package1.ActivitySchiena;
import package1.ActivitySpalle;
import package1.ActivityTricipiti;
import ui.MainAdapter;

public class Esercizi extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView btMenu;
    ImageView imageCorpo;
    RecyclerView recyclerView;
    static ArrayList<String> arrayList=new ArrayList<>();
    MainAdapter adapter;
    TextView textActionbar;




    private Button buttonSpalle,buttonPetto,buttoBicipiti,buttonTricipiti,buttonSchiena,
    buttonAddome,buttonFemorali,buttonQuadricipiti,buttonPolpacci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esercizi);


        drawerLayout=findViewById(R.id.drawer_layout);
        btMenu=findViewById(R.id.bt_menu);
        recyclerView=findViewById(R.id.recyclerview2);

        textActionbar=findViewById(R.id.textActionBar);
        textActionbar.setText("Cerca Esercizi");

        //pulire arraylist

        arrayList.clear();

        //aggiungo menu
        arrayList.add("CALCOLO SCARICO");
        arrayList.add("ESERCIZI");
        arrayList.add("SCHEDE");
        arrayList.add("ESCI");


        adapter=new MainAdapter(this, arrayList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);

        btMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });










        buttonSpalle=findViewById(R.id.button_spalle);
        buttonSpalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(Esercizi.this, ActivitySpalle.class));
            }
        });
        buttonPetto=findViewById(R.id.button_chest);
        buttonPetto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Esercizi.this, ActivityPetto.class));

            }
        });
        buttoBicipiti=findViewById(R.id.button_bicipiti);
        buttoBicipiti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Esercizi.this, ActivityBicipiti.class));

            }
        });

        buttonTricipiti=findViewById(R.id.button_tricipiti);
        buttonTricipiti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Esercizi.this, ActivityTricipiti.class));

            }
        });
        buttonSchiena=findViewById(R.id.button_back);
        buttonSchiena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                startActivity(new Intent(Esercizi.this, ActivitySchiena.class));

            }
        });
        buttonAddome=findViewById(R.id.button_addome);
        buttonAddome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Esercizi.this, ActivityAddome.class));

            }
        });
        buttonFemorali=findViewById(R.id.button_fem);
        buttonFemorali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Esercizi.this, ActivityFemorali.class));

            }
        });
        buttonQuadricipiti=findViewById(R.id.button_quads);

        buttonQuadricipiti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                        startActivity(new Intent(Esercizi.this, ActivityQuadricipiti.class));



            }
        });
        buttonPolpacci=findViewById(R.id.button_calf);
        buttonPolpacci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Esercizi.this, ActivityPolpacci.class));

            }
        });

        //metto lay manag


        btMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);


            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        MainActivity.closeDrawer(drawerLayout);
    }
    @Override
    public void onBackPressed(){
        startActivity(new Intent(Esercizi.this,ActivitySchede.class));
    }


}