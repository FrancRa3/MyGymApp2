package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import ItemsClassi.ItemScar;
import data.DataBaseScarico;
import ui.RecyclerViewAdapterScarico;

public class ActivityScarico extends AppCompatActivity {
    //per drawer






    protected LinearLayoutManager mLayoutManager;
    private static final String TAG = "ListActivity";
    private RecyclerView recyclerView;
    private RecyclerViewAdapterScarico recyclerViewAdapter;
    private List<ItemScar> itemList;
    private DataBaseScarico dataBaseScarico;
    private FloatingActionButton fab2;
    private AlertDialog.Builder builderS;
    private AlertDialog dialogS;
    private EditText editBat,editSon,editInten,editData;
    private Button saveButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scarico);

        recyclerView=findViewById(R.id.recyclerviews);

        fab2=findViewById(R.id.fab2);
        fab2.setImageResource(R.drawable.ic_baseline_assessment_24);

        dataBaseScarico=new DataBaseScarico(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mLayoutManager = new LinearLayoutManager(this);// inserire oggetti con ultimo sotto e non sopra
        mLayoutManager.setStackFromEnd(true);
        mLayoutManager.setReverseLayout(true);
        recyclerView.setLayoutManager(mLayoutManager);

        itemList=new ArrayList<>();
        itemList=dataBaseScarico.getAllItems();

        recyclerViewAdapter=new RecyclerViewAdapterScarico(this,itemList);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.notifyDataSetChanged();

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPopDialogScar();
            }
        });
    }

    private void createPopDialogScar() {   // Creo finestra popup per inserimento e calcolo settimana scarico
        builderS=new AlertDialog.Builder(this);
        View view=getLayoutInflater().inflate(R.layout.poupscarico,null);
        editBat=view.findViewById(R.id.Battiti);
        editSon=view.findViewById(R.id.Sonno);
        editInten=view.findViewById(R.id.Intensita);
        editData=view.findViewById(R.id.Datasc);
        saveButton2=view.findViewById(R.id.saveButton2);
        saveButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!editBat.getText().toString().isEmpty()
                        && !editSon.getText().toString().isEmpty()
                        && !editInten.getText().toString().isEmpty()
                && !editData.getText().toString().isEmpty()){
                    saveItemScar(view);
                }else {
                    Snackbar.make(view,"Campi vuoti non ammessi",Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        builderS.setView(view);
        dialogS=builderS.create();
        dialogS.show();
    }

    private void saveItemScar(View view) {
        ItemScar itemScar=new ItemScar();
        String newBat=editBat.getText().toString().trim();
        String newSon=editSon.getText().toString().trim();
        String newInte=editInten.getText().toString().trim();
        String newData=editData.getText().toString().trim();
        itemScar.setIntensita(newInte);
        itemScar.setSonno(newSon);
        itemScar.setBattito(newBat);
        itemScar.setData(newData);
        dataBaseScarico.addItem(itemScar);
        Snackbar.make(view,"Salvato",Snackbar.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialogS.dismiss();
                startActivity(new Intent(ActivityScarico.this,ActivityScarico.class));
                finish();
            }
        },1200);
    }
}