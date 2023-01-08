package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView register,resetpass;
    private EditText editemail,editpassword;
    private Button accedi;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;
    private ImageView google;

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        
     //   if (user != null) {
            // User is signed in
     //       Intent i = new Intent(LoginActivity.this, ActivitySchede.class);
      //      i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        //    startActivity(i);
       // } else {
            // User is signed out

       // }

        gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        gsc= GoogleSignIn.getClient(this,gso);

        register = findViewById(R.id.goToRegisterActivity);
        register.setOnClickListener(this);
        accedi=findViewById(R.id.accedilg);
        accedi.setOnClickListener(this);
        editpassword=findViewById(R.id.passwordlg);
        editemail=findViewById(R.id.emaillg);
        progressBar=findViewById(R.id.progressBar);
        mAuth=FirebaseAuth.getInstance();
        resetpass=findViewById(R.id.goToresetpass);
        resetpass.setOnClickListener(this);
        google=findViewById(R.id.googleImage);
        google.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {  //Pulsanti di accesso vari
        switch (view.getId()){
            case R.id.goToRegisterActivity:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.accedilg:
                userLogin();
                break;
            case R.id.goToresetpass:
                startActivity(new Intent(this,forgotPass.class));
                break;
            case R.id.googleImage:
                SignIn();
                break;

        }


    }

    private void SignIn() {
        Intent intent=gsc.getSignInIntent();
         startActivityForResult(intent,100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {  //Login con Google
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100){
            Task<GoogleSignInAccount> task=GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account=task.getResult(ApiException.class);
                AuthCredential credential= GoogleAuthProvider.getCredential(account.getIdToken(),null);
                FirebaseAuth.getInstance().signInWithCredential(credential)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Intent intent=new Intent(getApplicationContext(),ActivitySchede.class);
                                    startActivity(intent);


                                }else{
                                    Toast.makeText(LoginActivity.this,"Errore",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            } catch (ApiException e) {
                Toast.makeText(this,"Errore",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void HomeActivity() {
        finish();
        Intent intent=new Intent(getApplicationContext(),ActivitySchede.class);
        startActivity(intent);

    }

    private void userLogin() {
        String email=editemail.getText().toString().trim();
        String password=editpassword.getText().toString().trim();

        if(email.isEmpty()){                             //Errori con Campi vuoti
            editemail.setError("Email Richiesta!");
            editemail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editemail.setError("Inserire Email Valida!");
            editemail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            editpassword.setError("Password Richiesta");
            editpassword.requestFocus();
            return;
        }

        if(password.length()<6){
            editpassword.setError("La password deve essere lunga almeno 6 caratteri!");
            editpassword.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {  //Login con Firebase più eventuali messaggi di errore
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
                    if(user.isEmailVerified()) {
                        startActivity(new Intent(LoginActivity.this, ActivitySchede.class));
                    }else{
                        user.sendEmailVerification();
                        Toast.makeText(LoginActivity.this,"Controlla la mail per verificare il tuo account!",Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.GONE);
                    }

                }else{
                    Toast.makeText(LoginActivity.this,"Accesso Fallito! Controlla le credenziali inserite o la connessione ad internet!",Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    protected void onStart() {  //Logga direttamente se non si è fatto il logout
        super.onStart();
        FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
        if(user!=null){
            Intent intent=new Intent(this,ActivitySchede.class);
            startActivity(intent);

        }
    }
}