package com.example.gil_raquel_examen3t;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListaFragment extends Fragment {
    private List<Album> listadoRock;
    private List<Album> listadoBlues;
    private List<Album> listadoJazz;
    Button informacion;
    Button eliminar;


    public ListaFragment() {
    }

    public static ListaFragment newInstance() {
        return new ListaFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        listadoRock = new ArrayList<>();

        listadoRock.add(new Album("Abbey Road" , "The Beatles", R.drawable.abbeyroad,
                getResources().getString(R.string.abbeyroad)));
        listadoRock.add(new Album("Exile on Main Street" , "The Rolling Stones", R.drawable.exileonmainst,
                getResources().getString(R.string.exilesonmainstreet)));
        listadoRock.add(new Album("The Velvet Underground" , "The Velvet Underground and Nico", R.drawable.velvetunderground,
                getResources().getString(R.string.velvetunderground)));
        listadoRock.add(new Album("Are You Experienced" , "Jimi Hendrix", R.drawable.areyouexperienced,
                getResources().getString(R.string.areyouexperienced)));

        listadoRock.add(new Album("Back in Black" , "AC/DC", R.drawable.backinblack,
                getResources().getString(R.string.backinblack)));
        listadoRock.add(new Album("Appetite for Destruction" , "Guns N’ Roses", R.drawable.appetitefordestruction,
                getResources().getString(R.string.appetitefordestruction)));
        listadoRock.add(new Album("Led Zeppelin IV" ,"Led Zeppelin", R.drawable.ledzeppeliniv,
                getResources().getString(R.string.ledzeppeliniv)));

        listadoBlues = new ArrayList<>();
        listadoBlues.add(new Album("Lady Soul",  "Aretha Franklin",R.drawable.ladysoul ,
                getResources().getString(R.string.ladysoul)));
        listadoBlues.add(new Album("I Never Loved a Man the Way I Love You","Aretha Franklin", R.drawable.neverloved,
                getResources().getString(R.string.ineverloveda)));
        listadoBlues.add(new Album("What's Going On", "Marvin Gaye", R.drawable.whatsgoingon,
                getResources().getString(R.string.whatsgoingon)));

        listadoJazz = new ArrayList<>();
        listadoJazz.add(new Album("Kind of Blue", "Miles Davis",R.drawable.kindofblue,
                getResources().getString(R.string.kindofblue)));
        listadoJazz.add(new Album("Bitches Brew", "Miles Davis",R.drawable.bitchesbrew,
                getResources().getString(R.string.bitchesbrew)));
        listadoJazz.add(new Album("A Love Supreme", "John Coltrane", R.drawable.alovesupreme,
                getResources().getString(R.string.alovesupreme)));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        RecyclerView recyclerView =(RecyclerView) inflater.inflate(R.layout.fragment_lista, container, false);

        Context context = recyclerView.getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new GenerosAdapter(listadoRock));

        return recyclerView;
    }


}