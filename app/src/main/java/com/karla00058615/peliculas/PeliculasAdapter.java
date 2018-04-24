package com.karla00058615.peliculas;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Karla on 21/4/2018.
 */

public class PeliculasAdapter extends RecyclerView.Adapter<PeliculasAdapter.PeliculasViewHolder>{
    Context context;
    List<Peliculas> peliculasList;


    public PeliculasAdapter(Context context, List<Peliculas> peliculasList) {
        this.context = context;
        this.peliculasList = peliculasList;
    }

    @Override
    public PeliculasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.layout_list, parent, false);

        return new PeliculasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final PeliculasViewHolder holder, final int position) {
        holder.titleTxtView.setText(peliculasList.get(position).getTitle());
        holder.descrTxtView.setText(peliculasList.get(position).getDesc());
        //holder.img.setImageDrawable(peliculasList.get(position).getImg());
        holder.fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                peliculasList.get(position).setFav(!peliculasList.get(position).getFav());
                holder.fav.setImageDrawable(context.getResources().getDrawable(R.drawable.estrellas));
            }
        });
        if(peliculasList.get(position).getFav()){
            holder.fav.setImageDrawable(context.getResources().getDrawable(R.drawable.estrellas));
        }
    }


    @Override
    public int getItemCount() {
        return peliculasList.size();
    }

    protected class PeliculasViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        ImageButton fav;
        TextView titleTxtView, descrTxtView;

        public PeliculasViewHolder(View itemView) {
            super(itemView);

            //img = itemView.findViewById(R.id.peliculaImg);
            titleTxtView = itemView.findViewById(R.id.titleTxtView);
            descrTxtView = itemView.findViewById(R.id.descTxtView);
            fav = (ImageButton)itemView.findViewById(R.id.button_fav);
        }
    }
}
