package provaembrionale;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.example.myapplication.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ItemsClassi.Exsc;

public class Adapteres extends RecyclerView.Adapter<ViewHolderSp> {
    Context context;

    public Adapteres(Context context, List<Exsc> exscList) {
        this.context = context;
        this.exscList = exscList;
    }

    List<Exsc> exscList;
    @NonNull
    @Override
    public ViewHolderSp onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderSp(LayoutInflater.from(context).inflate(R.layout.listesercizi,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSp holder, int position) {
        holder.titolo.setText(exscList.get(position).getTitle());
        holder.spiegazione.setText(exscList.get(position).getTesto());
        holder.imageView.setImageResource(exscList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return exscList.size();
    }
}
