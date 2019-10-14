package com.example.hassan.toursim.tripinfo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hassan.toursim.Places.Model;
import com.example.hassan.toursim.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TripInfoAdapter extends RecyclerView.Adapter<TripInfoAdapter.viewHolder>{

    List<Model>m;

    public TripInfoAdapter(List<Model> m) {
        this.m = m;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.tpinf,parent,false);
        return new viewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Model item=m.get(position);
        holder.txt1.setText(item.getTxt());
        holder.txt2.setText(String.valueOf(item.getPrice()+"LE"));
        holder.txt3.setText(item.getAbout());

    }

    @Override
    public int getItemCount() {
        return m.size();
    }

    class viewHolder extends RecyclerView.ViewHolder
    {
        TextView txt1,txt2,txt3;

        public viewHolder(View view)
        {
            super(view);
            txt1=view.findViewById(R.id.tpinfo_titl);
            txt2=view.findViewById(R.id.tpdescinfo_titl);
            txt3=view.findViewById(R.id.priceinfo_titl);

        }

    }

}
