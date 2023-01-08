package provaembrionale;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.myapplication.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ViewHolderSp extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView titolo,spiegazione;
    public ViewHolderSp(@NonNull View itemView) {
        super(itemView);
        imageView=itemView.findViewById(R.id.image_es);
        titolo=itemView.findViewById(R.id.item_names);
        spiegazione=itemView.findViewById(R.id.es_spieg);

    }
}
