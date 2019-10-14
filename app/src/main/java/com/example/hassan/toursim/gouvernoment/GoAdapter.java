package com.example.hassan.toursim.gouvernoment;

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

public class GoAdapter  extends RecyclerView.Adapter<GoAdapter.viewHolder> {

    List<Model> m;
    public  static String go_id;
    OnGovItemClick onGovItemClick;

    public void setOnGovItemClick(OnGovItemClick onGovItemClick) {
        this.onGovItemClick = onGovItemClick;
    }

    public GoAdapter(List<Model> m) {
        this.m = m;
    }

    public  static String token_go;
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gov,viewGroup,false);
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

         if (viewHolder!=null)
         {
          viewHolder.parent.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  onGovItemClick.OnItemclick(item,i);
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
        TextView tx1;
        View parent;

        public viewHolder(View view) {
            super(view);

            imageView = view.findViewById(R.id.go_image);
            tx1 = view.findViewById(R.id.go_title);
            parent=view;

        }
    }
    interface OnGovItemClick{
         public void OnItemclick(Model data,int postion);

    }

}
