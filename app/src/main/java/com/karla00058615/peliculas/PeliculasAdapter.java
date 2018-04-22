package com.karla00058615.peliculas;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Karla on 21/4/2018.
 */

public class PeliculasAdapter extends RecyclerView.Adapter<PeliculasAdapter.PeliculasViewHolder>{
    Context context;
    List<Peliculas> peliculasList;
    int cont = 0;

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
        holder.fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("name"+cont,peliculasList.get(position).getTitle());
                bundle.putString("description"+cont,peliculasList.get(position).getDesc());
                bundle.putInt("id"+cont,peliculasList.get(position).getId());

                FavoritosFragment fragment = new FavoritosFragment();
                fragment.setArguments(bundle);
                cont++;
                Toast.makeText(context,"item: "+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return peliculasList.size();
    }

    protected class PeliculasViewHolder extends RecyclerView.ViewHolder{
        TextView titleTxtView, descrTxtView;
        Button fav;

        public PeliculasViewHolder(View itemView) {
            super(itemView);

            titleTxtView = itemView.findViewById(R.id.titleTxtView);
            descrTxtView = itemView.findViewById(R.id.descTxtView);
            fav = itemView.findViewById(R.id.button_fav);
        }
    }
}
