package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import ItemsClassi.User;
import ui.MainAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView accedi;
    private FirebaseAuth mAuth;
    private Button registerb;

    private EditText editName, editNumber, editEmail, editPassword;
    private ProgressBar progressBar;



    private static final String MESSAGE_ID ="MESSAGES_PREFS" ;




    public static void closeDrawer(DrawerLayout drawerLayout) {
        // check cond

        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        accedi=findViewById(R.id.goToLoginActivity);
        accedi.setOnClickListener(this);
        mAuth=FirebaseAuth.getInstance();

        registerb=findViewById(R.id.signupsg);
        registerb.setOnClickListener(this);

        editName=findViewById(R.id.Nomesg);
        editEmail=findViewById(R.id.emailsg);
        editNumber=findViewById(R.id.numerosg);
        editPassword=findViewById(R.id.passwordsg);
        progressBar=findViewById(R.id.progressBarReg);


    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.goToLoginActivity:
                    startActivity(new Intent(MainActivity.this,LoginActivity.class));
            break;

            case R.id.signupsg:
                registerUser();
                break;
        }

    }

    private void registerUser() {
        String email=editEmail.getText().toString().trim();
        String password=editPassword.getText().toString().trim();
        String name=editName.getText().toString().trim();
        String number=editNumber.getText().toString().trim();

        if(name.isEmpty()){
            editName.setError("Nome Richiesto!");
            editName.requestFocus();
            return;

        }

        if(number.isEmpty()){
            editNumber.setError("Numero Richiesto!");;
            editNumber.requestFocus();
            return;
        }

        if(password.isEmpty()){
            editPassword.setError("Password Richiesta");
            editPassword.requestFocus();
            return;
        }

        if(email.isEmpty()){
            editEmail.setError("Email Richiesta!");
            editEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editEmail.setError("Inserisci Email Valida!");
            editEmail.requestFocus();
            return;
        }

        if(password.length()<6){
            editPassword.setError("La password deve essere lunga almeno 6 caratteri!");
            editPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    User user=new User(name,email,number);
                    FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(MainActivity.this,"Registrazione avvenuta con successo!",Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                            }else{
                                Toast.makeText(MainActivity.this,"Registrazione fallita prova di nuovo!",Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);

                            }
                        }
                    });
                }else{
                    Toast.makeText(MainActivity.this,"Registrazione fallita prova di nuovo!",Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);

                }
            }
        });


    }
}