package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgotPass extends AppCompatActivity {
    private EditText editemail;
    private Button buttonreset;
    private ProgressBar progressBar;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);

        editemail=findViewById(R.id.emailcambio);
        buttonreset=findViewById(R.id.cambiaemailb);
        progressBar=findViewById(R.id.progressBarPass);

        mAuth=FirebaseAuth.getInstance();

        buttonreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPassword();
            }

            private void resetPassword() {

                String email=editemail.getText().toString().trim();
                if(email.isEmpty()){
                    editemail.setError("Email Richiesta!");
                    editemail.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    editemail.setError("Inserire Email Valida!");
                    editemail.requestFocus();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(forgotPass.this,"Controlla l'email per cambiare la password",Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }else{
                            Toast.makeText(forgotPass.this,"Errore! Prova di buovo",Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });
    }
}