package com.karla00058615.peliculas;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button pelis,fav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pelis = (Button)findViewById(R.id.button_peliculas);
        fav = (Button) findViewById(R.id.button_favoritos);

        pelis.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        //Maneja los fragmentos.
        android.app.FragmentManager fragmentManager = getFragmentManager();

        //Crea una nueva trasacción.
        android.app.FragmentTransaction transaction = fragmentManager.beginTransaction();

        //Crea un fragmento y lo añade.
        PeliculasFragment fragment = new PeliculasFragment();
        transaction.add(R.id.principal_layout, fragment);

        //Realizando cambios.
        transaction.commit();

    }
}
