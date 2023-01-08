package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import ItemsClassi.User;
import ui.MainAdapter;

public class ActivitySchede extends AppCompatActivity {
    public static final int TIME_INTERVAL=2000;
    private long backPressed;
    DrawerLayout drawerLayout;
    ImageView btMenu;
    RecyclerView recyclerView;
    static ArrayList<String> arrayList=new ArrayList<>();
    MainAdapter adapter;
    private AlertDialog.Builder builder;
    private AlertDialog dialog;
    private EditText nameScheda;
    private Button saveScheda;
    SharedPreferences sharedPreferences;
    public static final String MYPREFE="MyPrefs";
    public static final String Name1="NameKey1";
    public static final String Name2="NameKey2";
    public static final String Name3="NameKey3";
    public static final String Name4="NameKey4";
    public static final String Name5="NameKey5";
    public static final String Name6="NameKey6";
    public static final String Name7="NameKey7";
    String name1,name2,name3,name4,name5,name6,name7;
    private TextView textActionbar;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userId,userEmail;
    private Button buttonLu,buttonMa,buttonMe,buttonGio,buttonVe,buttonSa,buttonDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schede);
        sharedPreferences=getSharedPreferences(MYPREFE, Context.MODE_PRIVATE);

        textActionbar=findViewById(R.id.textActionBar);
        textActionbar.setText("Le mie Schede");

        user= FirebaseAuth.getInstance().getCurrentUser();
        reference= FirebaseDatabase.getInstance().getReference("Users");
        userId=user.getEmail();

        drawerLayout=findViewById(R.id.drawer_layout);  //Drawe Layout creato a mano
        btMenu=findViewById(R.id.bt_menu);
        recyclerView=findViewById(R.id.recyclerview2);

        //pulire arraylist

        arrayList.clear();

        //aggiungo menu
        arrayList.add("CALCOLO SCARICO");
        arrayList.add("ESERCIZI");
        arrayList.add("SCHEDE");
        arrayList.add("ESCI");
        arrayList.add("Connesso come " + userId);

        adapter=new MainAdapter(this, arrayList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);

        btMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        buttonLu=findViewById(R.id.button_lunedi);                   //Un bottone per ogni scheda/giorno settimana + modifica nome scheda
        name1=sharedPreferences.getString("Name1","LUNEDI'");
        buttonLu.setText(name1);
        buttonLu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivitySchede.this, ListActivity.class));
            }
        });
        buttonLu.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                createPopScheda();
                return false;
            }

            private void createPopScheda() {
                builder= new AlertDialog.Builder(ActivitySchede.this);
                 View view=getLayoutInflater().inflate(R.layout.popupmodificascheda,null);
                nameScheda=view.findViewById(R.id.nomeScheda);
                saveScheda=view.findViewById(R.id.saveButtonScheda);
                saveScheda.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("Name1",nameScheda.getText().toString());
                        editor.commit();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dialog.dismiss();
                                startActivity(new Intent(ActivitySchede.this,ActivitySchede.class));
                                finish();
                            }
                        },1200);
                    }
                });
                builder.setView(view);
                dialog=builder.create();
                dialog.show();
            }


        });
        buttonMa=findViewById(R.id.button_martedi);
        name2=sharedPreferences.getString("Name2","MARTEDI'");
        buttonMa.setText(name2);
        buttonMa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivitySchede.this, ListActivity2.class));
            }
        });
        buttonMa.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                createPopScheda();
                return false;
            }
            private void createPopScheda() {
                builder= new AlertDialog.Builder(ActivitySchede.this);
                View view=getLayoutInflater().inflate(R.layout.popupmodificascheda,null);
                nameScheda=view.findViewById(R.id.nomeScheda);
                saveScheda=view.findViewById(R.id.saveButtonScheda);
                saveScheda.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("Name2",nameScheda.getText().toString());
                        editor.commit();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dialog.dismiss();
                                startActivity(new Intent(ActivitySchede.this,ActivitySchede.class));
                                finish();
                            }
                        },1200);
                    }
                });
                builder.setView(view);
                dialog=builder.create();
                dialog.show();

            }
        });
        buttonMe=findViewById(R.id.button_mercoledi);
        name3=sharedPreferences.getString("Name3","MERCOLEDI'");
        buttonMe.setText(name3);
        buttonMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivitySchede.this, ListActivity3.class));
            }
        });
        buttonMe.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                createPopScheda();
                return false;
            }
            private void createPopScheda() {
                builder= new AlertDialog.Builder(ActivitySchede.this);
                View view=getLayoutInflater().inflate(R.layout.popupmodificascheda,null);
                nameScheda=view.findViewById(R.id.nomeScheda);
                saveScheda=view.findViewById(R.id.saveButtonScheda);
                saveScheda.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("Name3",nameScheda.getText().toString());
                        editor.commit();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dialog.dismiss();
                                startActivity(new Intent(ActivitySchede.this,ActivitySchede.class));
                                finish();
                            }
                        },1200);
                    }
                });
                builder.setView(view);
                dialog=builder.create();
                dialog.show();
            }
        });

        buttonGio=findViewById(R.id.button_giovedi);
        name4=sharedPreferences.getString("Name4","GIOVEDI'");
        buttonGio.setText(name4);
        buttonGio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivitySchede.this, ListActivity4.class));
            }
        });
        buttonGio.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                createPopScheda();
                return false;
            }
            private void createPopScheda() {
                builder= new AlertDialog.Builder(ActivitySchede.this);

                View view=getLayoutInflater().inflate(R.layout.popupmodificascheda,null);
                nameScheda=view.findViewById(R.id.nomeScheda);
                saveScheda=view.findViewById(R.id.saveButtonScheda);
                saveScheda.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("Name4",nameScheda.getText().toString());
                        editor.commit();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dialog.dismiss();
                                startActivity(new Intent(ActivitySchede.this,ActivitySchede.class));
                                finish();
                            }
                        },1200);
                    }
                });
                builder.setView(view);
                dialog=builder.create();
                dialog.show();


            }
        });
        buttonVe=findViewById(R.id.button_verdi);
        name5=sharedPreferences.getString("Name5","VENERDI'");
        buttonVe.setText(name5);
        buttonVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivitySchede.this, ListActivity5.class));
            }
        });
        buttonVe.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                createPopScheda();
                return false;
            }
            private void createPopScheda() {
                builder= new AlertDialog.Builder(ActivitySchede.this);
                View view=getLayoutInflater().inflate(R.layout.popupmodificascheda,null);
                nameScheda=view.findViewById(R.id.nomeScheda);
                saveScheda=view.findViewById(R.id.saveButtonScheda);
                saveScheda.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("Name5",nameScheda.getText().toString());
                        editor.commit();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dialog.dismiss();
                                startActivity(new Intent(ActivitySchede.this,ActivitySchede.class));
                                finish();
                            }
                        },1200);
                    }
                });
                builder.setView(view);
                dialog=builder.create();
                dialog.show();
            }
        });
        buttonSa=findViewById(R.id.button_sabato);
        name6=sharedPreferences.getString("Name6","SABATO");
        buttonSa.setText(name6);
        buttonSa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivitySchede.this, ListActivity6.class));
            }
        });
        buttonSa.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                createPopScheda();
                return false;
            }
            private void createPopScheda() {
                builder= new AlertDialog.Builder(ActivitySchede.this);

                View view=getLayoutInflater().inflate(R.layout.popupmodificascheda,null);
                nameScheda=view.findViewById(R.id.nomeScheda);
                saveScheda=view.findViewById(R.id.saveButtonScheda);
                saveScheda.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("Name6",nameScheda.getText().toString());
                        editor.commit();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dialog.dismiss();
                                startActivity(new Intent(ActivitySchede.this,ActivitySchede.class));
                                finish();
                            }
                        },1200);
                    }
                });
                builder.setView(view);
                dialog=builder.create();
                dialog.show();
            }
        });
        buttonDo=findViewById(R.id.button_domenica);
        name7=sharedPreferences.getString("Name7","DOMENICA");
        buttonDo.setText(name7);
        buttonDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivitySchede.this, ListActivity7.class));
            }
        });
        buttonDo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                createPopScheda();
                return false;
            }
            private void createPopScheda() {
                builder= new AlertDialog.Builder(ActivitySchede.this);

                View view=getLayoutInflater().inflate(R.layout.popupmodificascheda,null);
                nameScheda=view.findViewById(R.id.nomeScheda);
                saveScheda=view.findViewById(R.id.saveButtonScheda);
                saveScheda.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("Name7",nameScheda.getText().toString());
                        editor.commit();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dialog.dismiss();
                                startActivity(new Intent(ActivitySchede.this,ActivitySchede.class));
                                finish();
                            }
                        },1200);
                    }
                });
                builder.setView(view);
                dialog=builder.create();
                dialog.show();
            }
        });
    }

    @Override
    public void onBackPressed(){
        if(backPressed+TIME_INTERVAL>System.currentTimeMillis()){
            super.onBackPressed();
            finishAffinity();
        }else{
            Toast.makeText(getBaseContext(),"PREMI DI NUOVO INDIETRO PER USCIRE",Toast.LENGTH_SHORT).show();
        }
        backPressed=System.currentTimeMillis();
    }



    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.closeDrawer(drawerLayout);
    }
}