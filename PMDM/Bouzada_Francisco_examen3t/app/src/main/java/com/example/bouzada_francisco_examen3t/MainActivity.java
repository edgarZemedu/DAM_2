package com.example.bouzada_francisco_examen3t;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "MESSAGE";
    private static final int REQUEST_CODE = 1;

    public static List<String> lista;
    public static List<String> lista1;
    public static List<String> lista2;
    public static List<String> lista3;

    private Spinner spinnerAlbumes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = new ArrayList<String>();
        lista1 = new ArrayList<>();
        lista1.add("Géneros:");
        lista.addAll(lista1);


        lista2 = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.generos)));
        lista.addAll(lista2);

        lista3 = new ArrayList<>();
        lista3.add("Varios");
        lista.addAll(lista3);


        spinnerAlbumes = findViewById(R.id.spinner_albumes);

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerAlbumes.setAdapter(adaptador);

        spinnerAlbumes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {
                    Toast.makeText(MainActivity.this, "Género seleccionado: " + ((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();

                    // Creamos un intent, su contexto es el objeto de tipo MainActivity que encierra este escuchador
                    // y su acción s la inicialización de la clase SecondActivity
                    Intent intent = new Intent(MainActivity.this, Main3Activity.class);

                    //String message = ((TextView)view).getText().toString(); // Leemos el string que esté escrito dentro
                    intent.putExtra("numero", position); // Añadimos un valor de tipo int

                    startActivity(intent);

                }

                if (position == 2) {
                    Toast.makeText(MainActivity.this, "Género seleccionado: " + ((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();

                    // Creamos un intent, su contexto es el objeto de tipo MainActivity que encierra este escuchador
                    // y su acción s la inicialización de la clase SecondActivity
                    Intent intent = new Intent(MainActivity.this, Main3Activity.class);

                    //String message = ((TextView)view).getText().toString(); // Leemos el string que esté escrito dentro
                    intent.putExtra("numero", 2); // Añadimos un valor de tipo int


                    startActivity(intent);


                }
                if (position == 3) {
                    Toast.makeText(MainActivity.this, "Género seleccionado: " + ((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();

                    // Creamos un intent, su contexto es el objeto de tipo MainActivity que encierra este escuchador
                    // y su acción s la inicialización de la clase SecondActivity
                    Intent intent = new Intent(MainActivity.this, Main3Activity.class);

                    //String message = ((TextView)view).getText().toString(); // Leemos el string que esté escrito dentro
                    intent.putExtra("numero", 3); // Añadimos un valor de tipo int


                    startActivity(intent);


                }

                if (position == 4) {
                    Toast.makeText(MainActivity.this, "Seleccionado: " + ((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();


                    multipleSelectionDialog();


//                    // Creamos un intent, su contexto es el objeto de tipo MainActivity que encierra este escuchador
//                    // y su acción s la inicialización de la clase SecondActivity
//                    Intent intent = new Intent(MainActivity.this, Main3Activity.class);
//
//                    //String message = ((TextView)view).getText().toString(); // Leemos el string que esté escrito dentro
//                    intent.putExtra("numero", 4); // Añadimos un valor de tipo int
//
//
//
//                    startActivity(intent);


                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });

    }

    // Método que se lanza cuando se crea el menú de la activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.info:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Información");
                builder.setMessage("Proyecto de examen del 3er trimestre");
                builder.setCancelable(false);

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.show(); // Mostramos el Diálogo

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

//    // Método asociado al 2º Botón:
//    public void toSecondActivityWithText(View view) {
//        Intent intent = new Intent(this, Main3Activity.class);
//
//
//        String message = ((TextView)view).getText().toString(); // Leemos el string que esté escrito dentro
//
//
//        intent.putExtra(EXTRA_MESSAGE, message); // Añadimos un String usando una constante como clave
//
//        startActivity(intent);
//    }


    public void multipleSelectionDialog() {
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
                        Intent intent = new Intent(MainActivity.this, Main3Activity.class);

                        //String message = ((TextView)view).getText().toString(); // Leemos el string que esté escrito dentro
                        intent.putExtra("numero", opcion); // Añadimos un valor de tipo int


                        startActivity(intent);
                    }
                });
        builder.show();
    }


}



