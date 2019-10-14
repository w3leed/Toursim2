package com.example.hassan.toursim.Trip;

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

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.viewHolder> {

     List<Model>m;
    public  static String places_id;
    public  static String token_places;
    OnTripclickItem onTripclickItem;

    public void setOnTripclickItem(OnTripclickItem onTripclickItem) {
        this.onTripclickItem = onTripclickItem;
    }

    public PlacesAdapter(List<Model> m) {
        this.m = m;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.placest,viewGroup,false);
        return new viewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, final int i) {
        final Model item=m.get(i);
        viewHolder.tx1.setText(item.getTxt());
        // viewHolder.tx2.setText(item.getPrice());

        String image=item.getImage();
        if (image.isEmpty())
        {
            Picasso.get().load(R.drawable.ic_launcher_foreground).into( viewHolder.imageView);
        }
        else
        {
            Picasso.get().load(image).into( viewHolder.imageView);
        }
        viewHolder.tx2.setText(String.valueOf(item.getPrice()+"LE"));
        if (viewHolder!=null)
        {
            viewHolder.parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onTripclickItem.OnitemTrip(item,i);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return m.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tx1, tx2;
        View parent;

        public viewHolder(View view) {
            super(view);

            imageView = view.findViewById(R.id.places_image);
            tx1 = view.findViewById(R.id.places_title);
            tx2 = view.findViewById(R.id.places_price);
            parent=view;

        }
    }
    interface OnTripclickItem
    {
        void OnitemTrip(Model data,int postion);

    }
}
