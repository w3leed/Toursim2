package com.example.hassan.toursim.Places;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hassan.toursim.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.viewHolder>{

    List<Model>cop;
    public  static String id;
    public  static String token_use;
    OnItemPlaces onItemPlaces;

    public void setOnItemPlaces(OnItemPlaces onItemPlaces) {
        this.onItemPlaces = onItemPlaces;
    }

    public TripAdapter(List<Model> cop) {
        this.cop = cop;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.trip_layout,viewGroup,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, final int i) {

     final Model item=cop.get(i);
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
        if(viewHolder!=null)
        {
            viewHolder.parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemPlaces.OnClickplaces(item,i);
                }
            });
        }

    }
    public void setDate(List<Model> items){
        this.cop=items;
    }
    @Override
    public int getItemCount() {
        if (cop==null)return 0;
        return cop.size();
    }

    class viewHolder extends RecyclerView.ViewHolder
    {

        ImageView imageView;
        TextView tx1,tx2;
        View parent;
       public viewHolder(View view)
        {
           super(view);

           imageView=view.findViewById(R.id.tip_image);
           tx1=view.findViewById(R.id.tip_title);
           parent=view;
            //tx2=view.findViewById(R.id.tip_price);

        }



    }
     interface OnItemPlaces
     {
         void OnClickplaces(Model data,int postion);

     }

}
