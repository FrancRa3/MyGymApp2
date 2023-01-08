package ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.ActivitySpiegazione;
import com.example.myapplication.R;

import java.util.List;

import ItemsClassi.Exsc;

public class RecyclerViewAdapterSpieg extends RecyclerView.Adapter<RecyclerViewAdapterSpieg.ViewHolder> {
    private Context context;
    private List<Exsc> itemList;
    private AlertDialog dialog;
    private AlertDialog.Builder builder;
    private LayoutInflater inflater;

    public RecyclerViewAdapterSpieg(Context context, List<Exsc> itemList) {

        this.context = context;
        this.itemList = itemList;


    }

    @NonNull
    @Override
    public RecyclerViewAdapterSpieg.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listesercizi, parent, false);
        return new ViewHolder(view, context);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterSpieg.ViewHolder holder, int position) {
        Exsc item = itemList.get(position);
        holder.itemTitolo.setText("ESERCIZIO: " + item.getTitle());
        holder.itemSpieg.setText("SPIEGAZIONE ESERCIZIO: \n " + item.getTesto());
        holder.image1.setImageResource(item.getImage());


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView itemTitolo;
        public TextView itemSpieg;
        public ImageView image1;
        public int id;
        public ImageButton spiegButton,videoButton;


        public ViewHolder(@NonNull View itemView, Context ctx) {
            super(itemView);
            context = ctx;
            itemTitolo = itemView.findViewById(R.id.item_names);
            itemSpieg = itemView.findViewById(R.id.es_spieg);
            image1=itemView.findViewById(R.id.image_es);
            spiegButton = itemView.findViewById(R.id.esercizi_spiegaz);
            videoButton=itemView.findViewById(R.id.esercizi_video);


            spiegButton.setOnClickListener(this);
            videoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    position = getAdapterPosition();
                    Exsc item = itemList.get(position);
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(item.getVideo().toString().trim()));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setPackage("com.google.android.youtube");
                    view.getContext().startActivity(intent);

                }
            });
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            position = getAdapterPosition();
            Exsc item = itemList.get(position);
            switch (view.getId()) {


                case R.id.esercizi_spiegaz:
                    Intent intent = new Intent(view.getContext(), ActivitySpiegazione.class);
                    intent.putExtra("Titolo", item.getTitle().toString().trim());
                    intent.putExtra("Testo", item.getTesto().toString().trim());
                    view.getContext().startActivity(intent);
            }
        }


    }
}











