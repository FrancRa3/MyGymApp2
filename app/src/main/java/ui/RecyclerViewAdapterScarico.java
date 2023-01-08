package ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import ItemsClassi.ItemScar;
import data.DataBaseScarico;

public class RecyclerViewAdapterScarico extends RecyclerView.Adapter<RecyclerViewAdapterScarico.ViewHolder> {
    private Context context;
    private List<ItemScar> itemList;
    private AlertDialog dialog;
    private AlertDialog.Builder builder;
    private LayoutInflater inflater;
    public RecyclerViewAdapterScarico(Context context, List<ItemScar> itemList) {

        this.context=context;
        this.itemList=itemList;


    }

    @NonNull
    @Override
    public RecyclerViewAdapterScarico.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listscarico,parent,false);
        return new ViewHolder(view,context);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterScarico.ViewHolder holder, int position) {
        ItemScar item=itemList.get(position);
        holder.itemData.setText("DATA: " + item.getData());
        holder.itemBat.setText("BATTITI: " + item.getBattito());
        holder.itemInte.setText( "INTENSITA' " + item.getIntensita());
        holder.itemSon.setText("ORE DI SONNO: " + item.getSonno());


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {
        public TextView itemBat;
        public TextView itemSon;
        public TextView itemInte;
        public TextView itemData;

        public int id;
        public Button editButton, deleteButton;



        public ViewHolder(@NonNull View itemView, Context ctx) {
            super(itemView);
            context=ctx;
            itemBat=itemView.findViewById(R.id.item_battiti);
            itemSon=itemView.findViewById(R.id.item_sonno);
            itemInte=itemView.findViewById(R.id.item_intensità);
            itemData=itemView.findViewById(R.id.item_data);

            editButton=itemView.findViewById(R.id.editButtonSC);
            deleteButton=itemView.findViewById(R.id.deleteButtonSC);


            editButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position=getAdapterPosition();
                    position=getAdapterPosition();
                    ItemScar itemScar=itemList.get(position);
                    editItem(itemScar);
                }
            });
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position=getAdapterPosition();
                    position=getAdapterPosition();
                    ItemScar itemScar=itemList.get(position);
                    deleteItem(itemScar.getId());
                }
            });

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
                    DataBaseScarico databaseHandler =new DataBaseScarico(context);
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
        private void editItem(ItemScar newItem) {

            builder=new AlertDialog.Builder(context);
            inflater=LayoutInflater.from(context);
            final View view=inflater.inflate(R.layout.poupscarico,null);

            final EditText batt,sonn,inte,data;
            final Button saveButton;
            TextView title;

            batt=view.findViewById(R.id.Battiti);
            sonn=view.findViewById(R.id.Sonno);
            inte=view.findViewById(R.id.Intensita);
            data=view.findViewById(R.id.Datasc);

            saveButton=view.findViewById(R.id.saveButton2);
            title=view.findViewById(R.id.titolosc);

            title.setText("MODIFICA ESERCIZIO");
            saveButton.setText("MODIFICA");

            batt.setText(newItem.getBattito());
            sonn.setText(newItem.getSonno());
            inte.setText(newItem.getIntensita());
            data.setText(newItem.getData());


            builder.setView(view);
            dialog=builder.create();
            dialog.show();

            saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    DataBaseScarico databaseHandler = new DataBaseScarico(context);
                    newItem.setBattito(batt.getText().toString());
                    newItem.setIntensita(inte.getText().toString());
                    newItem.setSonno(sonn.getText().toString());
                    newItem.setData(data.getText().toString());



                    if(!batt.getText().toString().isEmpty()
                            && !sonn.getText().toString().isEmpty()
                            && !inte.getText().toString().isEmpty()
                            && !data.getText().toString().isEmpty()){


                        databaseHandler.updateItem(newItem);
                        notifyItemChanged(getAdapterPosition(),newItem); // IMPORTANTE PER AGGIORNARE SENZA RIAVVIARE APP



                    }else {
                        Snackbar.make(view,"CI SONO CAMPI VUOTI!",Snackbar.LENGTH_SHORT).show();
                    }

                    dialog.dismiss();


                }


            });

        }
    }




}

