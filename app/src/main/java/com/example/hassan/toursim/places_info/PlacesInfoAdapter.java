package com.example.hassan.toursim.places_info;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hassan.toursim.Places.Model;
import com.example.hassan.toursim.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PlacesInfoAdapter extends RecyclerView.Adapter<PlacesInfoAdapter.viewHolder> {
    List<Model> m;

    public PlacesInfoAdapter(List<Model> m) {
        this.m = m;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_p_info,parent,false);
        return new viewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        Model item=m.get(position);
        holder.txt.setText(item.getTxt());
        String image=item.getImage();
        if (image.isEmpty())
        {
            Picasso.get().load(R.drawable.ic_launcher_foreground).into( holder.imageView);

        }
        else
        {
            Picasso.get().load(image).into( holder.imageView);
        }


    }

    @Override
    public int getItemCount() {
        return m.size();
    }

    class viewHolder extends RecyclerView.ViewHolder
    {
        TextView txt;
        ImageView imageView;
        public viewHolder(View view)
        {
            super(view);
            txt=view.findViewById(R.id.pinfo_title);
            imageView=view.findViewById(R.id.pinfo_image);
        }

    }

}
