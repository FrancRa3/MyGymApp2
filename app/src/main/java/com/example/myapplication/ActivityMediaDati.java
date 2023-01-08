package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import ItemsClassi.ItemScar;
import data.DataBaseScarico;
import ui.MainAdapter;

public class ActivityMediaDati extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ImageView btMenu;
    RecyclerView recyclerView;
    static ArrayList<String> arrayList=new ArrayList<>();
    MainAdapter adapter;
    private AlertDialog.Builder builder;
    private AlertDialog dialog;
    private TextView mediaBat, mediaSon,mediaInte,mediaPunteggio;
    private List<ItemScar> itemList;
    private DataBaseScarico dataBaseScarico;
    private double pointS=0,pointI=0;
    private int pointB;
    private TextView textActionbar;
    private Button buttonAdd,buttonMedia,buttonCalcola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_dati);
        dataBaseScarico=new DataBaseScarico(this);

        textActionbar=findViewById(R.id.textActionBar);
        textActionbar.setText("Calcola Scarico");

        itemList=new ArrayList<>();

        itemList=dataBaseScarico.getAllItems();

        drawerLayout=findViewById(R.id.drawer_layout);
        btMenu=findViewById(R.id.bt_menu);
        recyclerView=findViewById(R.id.recyclerview2);

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

        buttonAdd=findViewById(R.id.button_aggiungidati);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivityMediaDati.this, ActivityScarico.class));
            }
        });

        buttonMedia=findViewById(R.id.button_media);
        buttonMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               
                   
                        createPopDialog();
                    
                
            }


        });
        
        
        
        







    }

    private void createPopDialog() {
        builder=new AlertDialog.Builder(this);
        View view=getLayoutInflater().inflate(R.layout.popupmedia,null);
        mediaBat=view.findViewById(R.id.Battititxt);
        mediaSon=view.findViewById(R.id.Sonnotxt);
        mediaInte=view.findViewById(R.id.Intensitatxt);
        mediaPunteggio=view.findViewById(R.id.punteggiotx);
        
        buttonCalcola=view.findViewById(R.id.buttonCalcola);
        buttonCalcola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               
                    CalcolaMedia(view);
              

            }
        });



        builder.setView(view);
        dialog=builder.create();
        dialog.show();
        
    }

    private void CalcolaMedia(View view) {
        itemList=dataBaseScarico.getAllItems();


        if(!itemList.isEmpty()) {

            for (int i = 0; i < itemList.size(); i++) {
                pointB += Double.valueOf(itemList.get(i).getBattito());
                pointI += Double.valueOf(itemList.get(i).getIntensita());
                pointS += Double.valueOf(itemList.get(i).getSonno());
            }
            pointB = pointB / Integer.valueOf(itemList.size());
            pointI = pointI / Double.valueOf(itemList.size());
            pointS = pointS / Double.valueOf(itemList.size());

            int punteggio = 0;
            if (pointS >= 9) {
                punteggio += 1;
            } else if (pointS >= 8 && pointS < 9) {
                punteggio = +2;

            } else if (pointS >= 7.5 && pointS < 8) {
                punteggio = +3;

            } else if (pointS >= 7 && pointS < 7.5) {
                punteggio = +4;

            } else if (pointS >= 6.5 && pointS < 7) {
                punteggio = +5;

            } else if (pointS >= 6 && pointS < 6.5) {
                punteggio = +6;

            } else if (pointS >= 5.5 && pointS < 6) {
                punteggio = +7;

            } else if (pointS >= 5 && pointS < 5.5) {
                punteggio = +8;

            } else if (pointS >= 4.5 && pointS < 5) {
                punteggio = +9;

            } else if (pointS < 4.5) {
                punteggio = +10;

            }

            if (pointB <= 50) {
                punteggio += 1;
            } else if (pointB > 80) {
                punteggio = +10;

            } else if (pointB > 50 && pointB <= 53) {
                punteggio = +2;

            } else if (pointB > 53 && pointB <= 57) {
                punteggio = +3;

            } else if (pointB > 57 && pointB <= 60) {
                punteggio = +4;

            } else if (pointB > 60 && pointB <= 63) {
                punteggio = +5;

            } else if (pointB > 63 && pointB <= 67) {
                punteggio = +6;

            } else if (pointB > 67 && pointB <= 70) {
                punteggio = +7;

            } else if (pointB > 70 && pointB <= 75) {
                punteggio = +8;

            } else if (pointB > 75 && pointB <= 80) {
                punteggio = +9;

            }

            if (pointI <= 6) {
                punteggio += 1;
            } else if (pointI > 6 && pointI <= 6.5) {
                punteggio = +2;

            } else if (pointI > 6.5 && pointI <= 7) {
                punteggio = +3;

            } else if (pointI > 7 && pointI <= 7.5) {
                punteggio = +4;

            } else if (pointI > 7.5 && pointI <= 8) {
                punteggio = +5;

            } else if (pointI > 8 && pointI <= 8.5) {
                punteggio = +6;

            } else if (pointI > 8.5 && pointI <= 9) {
                punteggio = +7;

            } else if (pointI > 9 && pointI <= 9.5) {
                punteggio = +8;

            } else if (pointI > 9.5 && pointI < 10) {
                punteggio = +9;

            }


            mediaSon.setText("Sonno:" + pointS);
            mediaInte.setText("Intensità: " + pointI);
            mediaBat.setText("Battiti: " + pointB);
            mediaPunteggio.setText("Punteggio Finale: " + punteggio);

            pointB = 0;
            pointI = 0;
            pointS = 0;


        }else{
            Snackbar.make(view,"NON HAI INSERITO ABBASTANZA DATI!",Snackbar.LENGTH_SHORT).show();
        }





    }

    @Override
    protected void onPause() {
        super.onPause();

        MainActivity.closeDrawer(drawerLayout);
    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(ActivityMediaDati.this,ActivitySchede.class));
    }
}