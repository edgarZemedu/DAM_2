package com.example.bouzada_francisco_examen3t;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

//    public RecyclerView recyclerView1;
//    public RecyclerView recyclerView2;
//    public RecyclerView recyclerView3;
//    public RecyclerView recyclerView4;
//    private MyItemRecyclerViewAdapter adaptador;

    public static List<ListaAlbums> listaAlbums;
    public static List<ListaAlbums> listadoRock;
    public static List<ListaAlbums> listadoBlues;
    public static List<ListaAlbums> listadoJazz;

    private void cargarArray(){
        listadoRock = new ArrayList<>();

        listadoRock.add(ListaAlbums.newInstance("Abbey Road", "The Beatles", R.drawable.abbeyroad,
                getResources().getString(R.string.abbeyroad)));
        listadoRock.add(ListaAlbums.newInstance("Exile on Main Street", "The Rolling Stones", R.drawable.exileonmainst,
                getResources().getString(R.string.exilesonmainstreet)));
        listadoRock.add(ListaAlbums.newInstance("The Velvet Underground", "The Velvet Underground and Nico", R.drawable.velvetunderground,
                getResources().getString(R.string.velvetunderground)));
        listadoRock.add(ListaAlbums.newInstance("Are You Experienced", "Jimi Hendrix", R.drawable.areyouexperienced,
                getResources().getString(R.string.areyouexperienced)));
        listadoRock.add(ListaAlbums.newInstance("Back in Black", "AC/DC", R.drawable.backinblack,
                getResources().getString(R.string.backinblack)));
        listadoRock.add(ListaAlbums.newInstance("Appetite for Destruction", "Guns N’ Roses", R.drawable.appetitefordestruction,
                getResources().getString(R.string.appetitefordestruction)));
        listadoRock.add(ListaAlbums.newInstance("Led Zeppelin IV", "Led Zeppelin", R.drawable.ledzeppeliniv,
                getResources().getString(R.string.ledzeppeliniv)));


        listadoBlues = new ArrayList<>();
        listadoBlues.add(ListaAlbums.newInstance("Lady Soul", "Aretha Franklin", R.drawable.ladysoul,
                getResources().getString(R.string.ladysoul)));
        listadoBlues.add(ListaAlbums.newInstance("I Never Loved a Man the Way I Love You", "Aretha Franklin", R.drawable.neverloved,
                getResources().getString(R.string.ineverloveda)));
        listadoBlues.add(ListaAlbums.newInstance("What's Going On", "Marvin Gaye", R.drawable.whatsgoingon,
                getResources().getString(R.string.whatsgoingon)));


        listadoJazz = new ArrayList<>();
        listadoJazz.add(ListaAlbums.newInstance("Kind of Blue", "Miles Davis", R.drawable.kindofblue,
                getResources().getString(R.string.kindofblue)));
        listadoJazz.add(ListaAlbums.newInstance("Bitches Brew", "Miles Davis", R.drawable.bitchesbrew,
                getResources().getString(R.string.bitchesbrew)));
        listadoJazz.add(ListaAlbums.newInstance("A Love Supreme", "John Coltrane", R.drawable.alovesupreme,
                getResources().getString(R.string.alovesupreme)));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // Lectura de los datos incluidos en el intent desde el que se creó la actividad
        Bundle datosDelIntent = getIntent().getExtras();

        int numero = datosDelIntent.getInt("numero"); // Leemos el int pasado

        /* Comprobación de que el Intent contenga algún extra; es decir, que el Bundle que
        devuelve "getExtras()" no sea null. Ya que cuando cambiamos de actividad con el botón
        que no pasa extras, eso generaría una nullPointerExcepcion al intentar leer de ese Bundle */
        if (numero == 1) {
            cargarArray();

            // Leemos el String pasado
            //String mensaje = datosDelIntent.getString(MainActivity.EXTRA_MESSAGE);
            //String mensaje = getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE);

            listaAlbums = new ArrayList<>();
            listaAlbums.addAll(listadoRock);

            getSupportFragmentManager().beginTransaction().add(R.id.contenedor5,
                    ItemFragment.newInstance()
            ).commit();

//            recyclerView1 = findViewById(R.id.recyclerView1);
//
//            recyclerView1.setAdapter(new MyItemRecyclerViewAdapter(listaAlbums));
//
//            recyclerView1.setLayoutManager(new LinearLayoutManager(this));

        }

        else if (numero == 2) {
            cargarArray();

            // Leemos el String pasado
            //String mensaje = datosDelIntent.getString(MainActivity.EXTRA_MESSAGE);
            //String mensaje = getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE);

            listaAlbums = new ArrayList<>();
            listaAlbums.addAll(listadoBlues);


            getSupportFragmentManager().beginTransaction().add(R.id.contenedor5,
                    ItemFragment.newInstance()
            ).commit();

//            recyclerView2 = findViewById(R.id.recyclerView1);
//
//            recyclerView2.setAdapter(new MyItemRecyclerViewAdapter(listaAlbums));
//
//            recyclerView2.setLayoutManager(new LinearLayoutManager(this));

        }

        else if (numero == 3) {
            cargarArray();

            // Leemos el String pasado
            //String mensaje = datosDelIntent.getString(MainActivity.EXTRA_MESSAGE);
            //String mensaje = getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE);

            listaAlbums = new ArrayList<>();
            listaAlbums.addAll(listadoJazz);


            getSupportFragmentManager().beginTransaction().add(R.id.contenedor5,
                    ItemFragment.newInstance()
            ).commit();


//            recyclerView3 = findViewById(R.id.recyclerView1);
//
//            recyclerView3.setAdapter(new MyItemRecyclerViewAdapter(listaAlbums));
//
//
//            recyclerView3.setLayoutManager(new LinearLayoutManager(this));


        }

        else if (numero == 4) {
            cargarArray();

            listaAlbums = new ArrayList<>();
            listaAlbums.addAll(listadoRock);
            listaAlbums.addAll(listadoBlues);

            getSupportFragmentManager().beginTransaction().add(R.id.contenedor5,
                    ItemFragment.newInstance()
            ).commit();

//            recyclerView4 = findViewById(R.id.recyclerView1);
//
//            recyclerView4.setAdapter(new MyItemRecyclerViewAdapter(listaAlbums));
//
//            recyclerView4.setLayoutManager(new LinearLayoutManager(this));


        }

        else if (numero == 5) {
            cargarArray();



            listaAlbums = new ArrayList<>();
            listaAlbums.addAll(listadoRock);
            listaAlbums.addAll(listadoJazz);


            getSupportFragmentManager().beginTransaction().add(R.id.contenedor5,
                    ItemFragment.newInstance()
            ).commit();


//            recyclerView4 = findViewById(R.id.recyclerView1);
//
//            recyclerView4.setAdapter(new MyItemRecyclerViewAdapter(listaAlbums));
//
//
//            recyclerView4.setLayoutManager(new LinearLayoutManager(this));


        }

        else if (numero == 6) {
            cargarArray();



            listaAlbums = new ArrayList<>();
            listaAlbums.addAll(listadoBlues);
            listaAlbums.addAll(listadoJazz);


            getSupportFragmentManager().beginTransaction().add(R.id.contenedor5,
                    ItemFragment.newInstance()
            ).commit();


//            recyclerView4 = findViewById(R.id.recyclerView1);
//
//            recyclerView4.setAdapter(new MyItemRecyclerViewAdapter(listaAlbums));
//
//
//            recyclerView4.setLayoutManager(new LinearLayoutManager(this));


        }

        else if (numero == 7) {
            cargarArray();



            listaAlbums = new ArrayList<>();
            listaAlbums.addAll(listadoRock);
            listaAlbums.addAll(listadoBlues);
            listaAlbums.addAll(listadoJazz);


            getSupportFragmentManager().beginTransaction().add(R.id.contenedor5,
                    ItemFragment.newInstance()
            ).commit();


//            recyclerView4 = findViewById(R.id.recyclerView1);
//
//            recyclerView4.setAdapter(new MyItemRecyclerViewAdapter(listaAlbums));
//
//
//            recyclerView4.setLayoutManager(new LinearLayoutManager(this));


        }


    }

    public void mostrarListado(View view) {
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor5,
                ItemFragment.newInstance()
        ).commit();
    }

    public void addElemento(View view) {
    }

    // Método que se lanza cuando se crea el menú de la activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.infoMenu3:
                String[] stringArray = getResources().getStringArray(R.array.generos);
                boolean[] isCheckedList = {false, false, false};

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Elige géneros")
                        .setMultiChoiceItems(stringArray, isCheckedList,
                                new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which,
                                                        boolean isChecked) {
                                        isCheckedList[which] = isChecked;
                                    }
                                })
                        .setPositiveButton("MOSTRAR SELECCIÓN", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                int opcion = 0;
                                String mensaje = "";
                                for (int i = 0; i < stringArray.length; i++) {
                                    if (isCheckedList[i]) {
                                        mensaje += " " + getResources().getStringArray(R.array.generos)[i];


                                    }
                                }
                                if (mensaje.equals(" Rock")) {
                                    opcion = 1;
                                } else if (mensaje.equals(" Blues")) {
                                    opcion = 2;
                                } else if (mensaje.equals(" Jazz")) {
                                    opcion = 3;
                                } else if (mensaje.equals(" Rock Blues")) {
                                    opcion = 4;
                                } else if (mensaje.equals(" Rock Jazz")) {
                                    opcion = 5;
                                } else if (mensaje.equals(" Blues Jazz")) {
                                    opcion = 6;
                                } else if (mensaje.equals(" Rock Blues Jazz")) {
                                    opcion = 7;
                                }



                                // Creamos un intent, su contexto es el objeto de tipo MainActivity que encierra este escuchador
                                // y su acción s la inicialización de la clase SecondActivity
                                Intent intent = new Intent(Main3Activity.this, Main3Activity.class);

                                //String message = ((TextView)view).getText().toString(); // Leemos el string que esté escrito dentro
                                intent.putExtra("numero", opcion); // Añadimos un valor de tipo int


                                startActivity(intent);
                            }
                        });
                builder.show();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}