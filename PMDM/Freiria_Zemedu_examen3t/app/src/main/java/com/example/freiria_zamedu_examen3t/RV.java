package com.example.freiria_zamedu_examen3t;

import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class RV extends AppCompatActivity {

    public static List<Album> listaAlbum;
    private List<Album> listadoRock;
    private List<Album> listadoBlues;
    private List<Album> listadoJazz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_v);

        listadoRock = new ArrayList<>();
        listadoRock.add(new Album("Abbey Road", "The Beatles", R.drawable.abbeyroad,
                getResources().getString(R.string.abbeyroad)));
        listadoRock.add(new Album("Exile on Main Street", "The Rolling Stones", R.drawable.exileonmainst,
                getResources().getString(R.string.exilesonmainstreet)));
        listadoRock.add(new Album("The Velvet Underground", "The Velvet Underground and Nico", R.drawable.velvetunderground,
                getResources().getString(R.string.velvetunderground)));
        listadoRock.add(new Album("Are You Experienced", "Jimi Hendrix", R.drawable.areyouexperienced,
                getResources().getString(R.string.areyouexperienced)));
        listadoRock.add(new Album("Back in Black", "AC/DC", R.drawable.backinblack,
                getResources().getString(R.string.backinblack)));
        listadoRock.add(new Album("Appetite for Destruction", "Guns N’ Roses", R.drawable.appetitefordestruction,
                getResources().getString(R.string.appetitefordestruction)));
        listadoRock.add(new Album("Led Zeppelin IV", "Led Zeppelin", R.drawable.ledzeppeliniv,
                getResources().getString(R.string.ledzeppeliniv)));


        listadoBlues = new ArrayList<>();
        listadoBlues.add(new Album("Lady Soul", "Aretha Franklin", R.drawable.ladysoul,
                getResources().getString(R.string.ladysoul)));
        listadoBlues.add(new Album("I Never Loved a Man the Way I Love You", "Aretha Franklin", R.drawable.neverloved,
                getResources().getString(R.string.ineverloveda)));
        listadoBlues.add(new Album("What's Going On", "Marvin Gaye", R.drawable.whatsgoingon,
                getResources().getString(R.string.whatsgoingon)));


        listadoJazz = new ArrayList<>();
        listadoJazz.add(new Album("Kind of Blue", "Miles Davis", R.drawable.kindofblue,
                getResources().getString(R.string.kindofblue)));
        listadoJazz.add(new Album("Bitches Brew", "Miles Davis", R.drawable.bitchesbrew,
                getResources().getString(R.string.bitchesbrew)));
        listadoJazz.add(new Album("A Love Supreme", "John Coltrane", R.drawable.alovesupreme,
                getResources().getString(R.string.alovesupreme)));

        listaAlbum = new ArrayList<>();
        /*listaAlbum.addAll(listadoRock);
        listaAlbum.addAll(listadoBlues);
        listaAlbum.addAll(listadoJazz);*/

        Bundle datos = getIntent().getExtras();
        //boolean[] check = datos.getBooleanArray("clave");
        int check = datos.getInt("clave");
        if (check == 1){
            listaAlbum.addAll(listadoRock);
        }
        if (check == 0){
            listaAlbum.addAll(listadoBlues);
        }
        if (check == 2){
            listaAlbum.addAll(listadoJazz);
        }
        if (listaAlbum.isEmpty()) Toast.makeText(this, "Lista album está vacio",Toast.LENGTH_SHORT).show();


        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment, ItemFragment.newInstance())
                .commit();

        //Toast.makeText(this,"tamaño: --->"+ listaAlbum.toString(),Toast.LENGTH_SHORT).show();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {



        return super.onOptionsItemSelected(item);
    }

}