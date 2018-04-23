package com.karla00058615.peliculas;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button pelis,fav;
    ArrayList<Peliculas> peliculasList = new ArrayList<>();
    RecyclerView recyclerView;
    PeliculasAdapter adapter;
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //filling the peliculas list
        peliculasList = fillList();

        //setting the recyclerview.
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new PeliculasAdapter(this, peliculasList);

        //recyclerview
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void favoritos(View view){

        //setting the recyclerview.
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new PeliculasAdapter(this, fillFavList(peliculasList));

        //recyclerview
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

    }

    private ArrayList<Peliculas> fillFavList(List<Peliculas> l){
        ArrayList<Peliculas> nl = new ArrayList<>();
        for (Peliculas p: l) {
            if (p.getFav())
                nl.add(p);
        }

        return nl;
    }

    public void onClick(View view) {
        //setting the recyclerview.
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new PeliculasAdapter(this, peliculasList);

        //recyclerview
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<Peliculas> fillList(){
        String desc = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book";

        ArrayList<Peliculas> l = new ArrayList<>();
        l.add(new Peliculas(1, "Los Vengadores", desc,false/*getResources().getDrawable(R.drawable.avengers)*/));
        l.add(new Peliculas(2, "Minecraft the movie", desc,false/*getResources().getDrawable(R.drawable.avengers)*/));
        l.add(new Peliculas(3, "League of legends", desc,false/*getResources().getDrawable(R.drawable.avengers)*/));
        l.add(new Peliculas(4, "Fate", desc,false/*getResources().getDrawable(R.drawable.avengers)*/));
        l.add(new Peliculas(5, "HOLI", desc,false/*getResources().getDrawable(R.drawable.avengers)*/));
        l.add(new Peliculas(6, ":)", desc,false/*getResources().getDrawable(R.drawable.avengers)*/));
        l.add(new Peliculas(7, "!!!", desc,false/*getResources().getDrawable(R.drawable.avengers)*/));

        return l;
    }
}
