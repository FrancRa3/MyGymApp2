package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import ItemsClassi.Item;
import ItemsClassi.ItemScar;
import data.DataBaseScarico;
import data.QuintoDatab;
import ui.RecyclerViewAdapter;
import ui.RecyclerViewAdapter5;

public class ListActivity5 extends AppCompatActivity {
    //per drawer






    protected LinearLayoutManager mLayoutManager;
    private static final String TAG = "ListActivity";
    private RecyclerView recyclerView;
    private RecyclerViewAdapter5 recyclerViewAdapter;
    private List<Item> itemList;
    private QuintoDatab databaseHandler;
    private DataBaseScarico dataBaseScarico;
    private FloatingActionButton fab,fab2;
    private AlertDialog.Builder builder;
    private AlertDialog dialog;
    private AlertDialog.Builder builderS;
    private AlertDialog dialogS;
    private EditText exerciseName,reps,weight,rest;
    private EditText editBat,editSon,editInten,editDat;
    private Button saveButton,saveButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView=findViewById(R.id.recyclerview);
        fab=findViewById(R.id.fab);

        fab.setImageResource(R.drawable.ic_baseline_assignment_24);


        databaseHandler=new QuintoDatab(this);
        dataBaseScarico=new DataBaseScarico(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mLayoutManager = new LinearLayoutManager(this);// inserire oggetti con ultimo sotto e non sopra
        mLayoutManager.setStackFromEnd(true);
        mLayoutManager.setReverseLayout(true);
        recyclerView.setLayoutManager(mLayoutManager);

        itemList=new ArrayList<>();

        itemList=databaseHandler.getAllItems();

        for(Item item: itemList){
            Log.d(TAG, "onCreate " + item.getItemName());
        }

        recyclerViewAdapter=new RecyclerViewAdapter5(this,itemList);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.notifyDataSetChanged();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPopDialog();
            }
        });







    }



    private void createPopDialog() {
        builder=new AlertDialog.Builder(this);
        View view=getLayoutInflater().inflate(R.layout.popup,null);
        exerciseName=view.findViewById(R.id.Exercise);
        reps=view.findViewById(R.id.Reps);
        weight=view.findViewById(R.id.Weight);
        rest=view.findViewById(R.id.Rest);
        saveButton=view.findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!exerciseName.getText().toString().isEmpty()
                )
                {
                    saveItem(view);
                }else{
                    Snackbar.make(view,"IL NOME E' OBBLIGATORIO!",Snackbar.LENGTH_SHORT).show();
                }

            }
        });



        builder.setView(view);
        dialog=builder.create();
        dialog.show();

    }
    private void saveItem(View view) {

        Item item=new Item();
        String newExe=exerciseName.getText().toString().trim();
        String newReps=reps.getText().toString().trim();
        String newPeso=weight.getText().toString().trim();
        String newRest;
        if(!rest.getText().toString().isEmpty() ) {
            newRest = rest.getText().toString().trim();
        }else{
            newRest="";
        }

        item.setItemName(newExe);
        item.setItemRep(newReps);
        item.setItemPeso(newPeso);
        item.setItemRest(newRest);

        databaseHandler.addItem(item);

        Snackbar.make(view,"Salvato",Snackbar.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
                startActivity(new Intent(ListActivity5.this,ListActivity5.class));
                finish();
            }
        },1200);




    }

}