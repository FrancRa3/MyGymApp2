package ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.ActivityMediaDati;
import com.example.myapplication.ActivitySchede;
import com.example.myapplication.Esercizi;
import com.example.myapplication.LoginActivity;
import com.example.myapplication.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{

    Activity activity;
    ArrayList<String> arrayList;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;


    public MainAdapter(Activity activity, ArrayList<String> arrayList){
        this.activity=activity;
        this.arrayList=arrayList;

    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drawer_main,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
        //metto text su textview
        holder.textView.setText(arrayList.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //pos oggetto cliccato
                int position=holder.getAdapterPosition();
                switch (position){
                    case 0: // rimando alla home
                        activity.startActivity(new Intent(activity, ActivityMediaDati.class).setFlags((Intent.FLAG_ACTIVITY_NEW_TASK)));
                        break;
                    case 1:
                        //uguale ad 1 mando agli esercizi
                        activity.startActivity(new Intent(activity, Esercizi.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;
                    case 2:
                        //alla scheda
                        activity.startActivity(new Intent(activity, ActivitySchede.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;
                    case 3:
                        //esco
                        AlertDialog.Builder builder=new AlertDialog.Builder(activity);
                        builder.setTitle("Logout");
                        builder.setMessage("Sicuro di voler uscire?");
                        //yes butt
                        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //termino
                                
                                activity.startActivity(new Intent(activity, LoginActivity.class));
                                FirebaseAuth.getInstance().signOut();
                                GoogleSignInOptions gso = new GoogleSignInOptions.
                                        Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).
                                        build();

                                GoogleSignInClient googleSignInClient=GoogleSignIn.getClient(activity,gso);
                                googleSignInClient.signOut();



                            }
                        });
                        //no but
                        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });

                        builder.show();
                        break;

                }

            }
        });

    }



    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //initialize var
        TextView textView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.text_view2);
        }
    }

}
