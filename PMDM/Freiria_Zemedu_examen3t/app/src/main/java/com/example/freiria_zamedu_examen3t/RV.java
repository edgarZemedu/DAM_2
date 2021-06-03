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

import static com.example.freiria_zamedu_examen3t.MainActivity.CLAVE_MENSAJE;

public class RV extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;

    private List<Album> listaAlbum;
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
        listaAlbum.addAll(listadoRock);
        listaAlbum.addAll(listadoBlues);
        listaAlbum.addAll(listadoJazz);



    }
    // Método de callback para recibir resultados
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        /* Comprobamos resultCode(si hay una respuesta correcta) y
        requestCode (qué resultado de los solicitados se está recuperando)
         */
        if ( (resultCode == RESULT_OK) && (requestCode==REQUEST_CODE)){
            getSupportFragmentManager().beginTransaction().
                    add(R.id.fragment,new ItemFragment(listaAlbum))
                    .commit();

        } else {
            Toast.makeText(this, "Operación incorrecta", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Album al = new Album();
        /*for (Album i : listaAlbum){

            if (){

            }
        }*/
        return super.onOptionsItemSelected(item);
    }

}