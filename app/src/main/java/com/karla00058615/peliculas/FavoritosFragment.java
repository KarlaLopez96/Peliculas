package com.karla00058615.peliculas;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FavoritosFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class FavoritosFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public FavoritosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favoritos, container, false);

        List<Peliculas> peliculasList;
        RecyclerView recyclerView;
        PeliculasAdapter adapter;

        //filling the planet list
        peliculasList = fillList();

        //setting the recyclerview
        recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        adapter = new PeliculasAdapter(getContext(), peliculasList);

        //recyclerview
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private ArrayList<Peliculas> fillList(){

        int cont = 0;
        int holder;
        Bundle bundle = getArguments();
        ArrayList<Peliculas> l = new ArrayList<>();

        for (int i = 0;i < (bundle.size())/4;i++){
            holder = bundle.getInt("fav"+cont);
            if(holder == 1){
                l.add(new Peliculas(bundle.getInt("name"+cont),bundle.getString("name"+cont),
                        bundle.getString("description"+cont),bundle.getInt("fav"+cont)));
            }
            cont++;
        }

        return l;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
