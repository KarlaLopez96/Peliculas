package com.karla00058615.peliculas;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,PeliculasFragment.OnFragmentInteractionListener,
FavoritosFragment.OnFragmentInteractionListener{

    Button pelis,fav;
    ArrayList<Peliculas> peliculas = new ArrayList<>();
    int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pelis = (Button)findViewById(R.id.button_peliculas);
        fav = (Button) findViewById(R.id.button_favoritos);

        peliculas = fillList();

        pelis.setOnClickListener(this);

        //Maneja los fragmentos.
        android.app.FragmentManager fragmentManager = getFragmentManager();

        //Crea una nueva trasacción.
        android.app.FragmentTransaction transaction = fragmentManager.beginTransaction();

        //Crea un fragmento y lo añade.
        PeliculasFragment fragment = new PeliculasFragment();

        //se crea el bundle y se mandan todas las peliculas
        Bundle bundle = new Bundle();
        for (int i = 0;i<peliculas.size();i++){
            bundle.putString("name"+cont,peliculas.get(i).getTitle());
            bundle.putString("description"+cont,peliculas.get(i).getDesc());
            bundle.putInt("id"+cont,peliculas.get(i).getId());
            cont++;
        }
        cont = 0;
        //se manda el bundle al fragment
        fragment.setArguments(bundle);

        transaction.add(R.id.fragmentC, fragment);

        //Realizando cambios.
        transaction.commit();
    }

    public void favoritos(View view){

        //Maneja los fragmentos.
        android.app.FragmentManager fragmentManager = getFragmentManager();

        //Crea una nueva trasacción.
        android.app.FragmentTransaction transaction = fragmentManager.beginTransaction();

        //Crea un fragmento y lo añade.
        FavoritosFragment fragment = new FavoritosFragment();

        transaction.replace(R.id.fragmentC, fragment);

        //Realizando cambios.
        transaction.commit();
    }

    @Override
    public void onClick(View view) {

        //Maneja los fragmentos.
        android.app.FragmentManager fragmentManager = getFragmentManager();

        //Crea una nueva trasacción.
        android.app.FragmentTransaction transaction = fragmentManager.beginTransaction();

        //Crea un fragmento y lo añade.
        PeliculasFragment fragment = new PeliculasFragment();
        transaction.replace(R.id.fragmentC, fragment);

        //Realizando cambios.
        transaction.commit();
    }

    private ArrayList<Peliculas> fillList(){
        String desc = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book";

        ArrayList<Peliculas> l = new ArrayList<>();
        l.add(new Peliculas(1, "Los Vengadores", desc));
        l.add(new Peliculas(2, "Minecraft the movie", desc));
        l.add(new Peliculas(3, "League of legends", desc));
        l.add(new Peliculas(4, "Fate", desc));

        return l;
    }


//pasar aqui mi lista porque maneja mis dos fragmentos.

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
