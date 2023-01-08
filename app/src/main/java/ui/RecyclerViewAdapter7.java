package ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.ActivityTimer;
import com.example.myapplication.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import ItemsClassi.Item;
import data.DatabaseHandler;
import data.SettimoDat;

public class RecyclerViewAdapter7 extends RecyclerView.Adapter<RecyclerViewAdapter7.ViewHolder> {
    private Context context;
    private List<Item> itemList;
    private AlertDialog dialog;
    private AlertDialog.Builder builder;
    private LayoutInflater inflater;
    public RecyclerViewAdapter7(Context context, List<Item> itemList) {

        this.context=context;
        this.itemList=itemList;


    }

    @NonNull
    @Override
    public RecyclerViewAdapter7.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listrow,parent,false);
        return new ViewHolder(view,context);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter7.ViewHolder holder, int position) {
        Item item=itemList.get(position);
        holder.itemName.setText("ESERCIZIO: " + item.getItemName());
        holder.itemRep.setText( "SERIE E RIPETIZIONI: " + item.getItemRep());
        holder.itemPeso.setText("PESO: " + item.getItemPeso());
        holder.itemRest.setText("PAUSA: " + item.getItemRest());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView itemName;
        public TextView itemRep;
        public TextView itemPeso;
        public TextView itemRest;
        public int id;
        public Button editButton, deleteButton,timeButton;



        public ViewHolder(@NonNull View itemView, Context ctx) {
            super(itemView);
            context=ctx;
            itemName=itemView.findViewById(R.id.item_namer);
            itemRep=itemView.findViewById(R.id.item_repr);
            itemPeso=itemView.findViewById(R.id.item_pesor);
            itemRest=itemView.findViewById(R.id.item_restr);
            editButton=itemView.findViewById(R.id.editButton);
            deleteButton=itemView.findViewById(R.id.deleteButton);
            timeButton=itemView.findViewById(R.id.timerButton);

            editButton.setOnClickListener(this);
            deleteButton.setOnClickListener( this);
            timeButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position=getAdapterPosition();
            position=getAdapterPosition();
            Item item=itemList.get(position);
            switch (view.getId()){
                case R.id.editButton:

                    editItem(item);
                    break;

                case R.id.deleteButton:

                    deleteItem(item.getId());
                    break;

                case R.id.timerButton:
                    if (!item.getItemRest().toString().isEmpty()) {
                        Intent intent = new Intent(view.getContext(), ActivityTimer.class);
                        intent.putExtra("Time", item.getItemRest().toString().trim());
                        view.getContext().startActivity(intent);
                    } else{
                        Snackbar.make(view,"NON HAI INSERITO I SECONDI DI PAUSA",Snackbar.LENGTH_SHORT).show();
                    }
            }
        }
        private void deleteItem(int id) {
            builder=new AlertDialog.Builder(context);
            inflater=LayoutInflater.from(context);
            View view=inflater.inflate(R.layout.confirmation_pop,null);

            Button noButton=view.findViewById(R.id.no_button);
            Button yesButton=view.findViewById(R.id.yes_button);
            builder.setView(view);
            dialog=builder.create();
            dialog.show();


            yesButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SettimoDat databaseHandler =new SettimoDat(context);
                    databaseHandler.deleteItem(id);
                    itemList.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());

                    dialog.dismiss();

                }
            });

            noButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();

                }
            });





        }
        private void editItem(Item newItem) {

            builder=new AlertDialog.Builder(context);
            inflater=LayoutInflater.from(context);
            final View view=inflater.inflate(R.layout.popup,null);

            final EditText exerciseName,reps,weight,rest;
            final Button saveButton;
            TextView title;

            exerciseName=view.findViewById(R.id.Exercise);
            reps=view.findViewById(R.id.Reps);
            rest=view.findViewById(R.id.Rest);
            weight=view.findViewById(R.id.Weight);
            saveButton=view.findViewById(R.id.saveButton);
            title=view.findViewById(R.id.titolo);

            title.setText("MODIFICA ESERCIZIO");
            saveButton.setText("MODIFICA");

            exerciseName.setText(newItem.getItemName());
            reps.setText(newItem.getItemRep());
            weight.setText(newItem.getItemPeso());
            rest.setText(newItem.getItemRest());

            builder.setView(view);
            dialog=builder.create();
            dialog.show();

            saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    SettimoDat databaseHandler = new SettimoDat(context);
                    newItem.setItemName(exerciseName.getText().toString());
                    newItem.setItemPeso(weight.getText().toString());
                    newItem.setItemRep(reps.getText().toString());
                    newItem.setItemRest(rest.getText().toString());


                    if(!exerciseName.getText().toString().isEmpty()){


                        databaseHandler.updateItem(newItem);
                        notifyItemChanged(getAdapterPosition(),newItem); // IMPORTANTE PER AGGIORNARE SENZA RIAVVIARE APP



                    }else {
                        Snackbar.make(view,"IL NOME E' OBBLIGATORIO!",Snackbar.LENGTH_SHORT).show();
                    }

                    dialog.dismiss();


                }


            });

        }
    }




}

