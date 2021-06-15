package com.example.gil_raquel_examen3t;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    private static ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);

        arrayList = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.generos)));
        arrayList.add("Varios");


        ArrayAdapter arrayAdapter= new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayList);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 1){
                    Intent intent = new Intent(MainActivity.this, Activity2.class);
                    startActivity(intent);
                }
                if(position == 2){
                    Intent intent = new Intent(MainActivity.this, Activity2.class);
                    startActivity(intent);
                }
                if(position == 3){
                    Intent intent = new Intent(MainActivity.this, Activity2.class);
                    startActivity(intent);
                }
                if(position == 4){
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("Elige géneros");
             //      dialog.setMultiChoiceItems(R.array.generos, 2, new DialogInterface.OnMultiChoiceClickListener() {
             //           @Override
             //           public void onClick(DialogInterface dialog, int which, boolean isChecked) {

             //           }
             //       });

                    dialog.setPositiveButton("MOSTRAR SELECCIÓN", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(MainActivity.this, Activity2.class);
                            startActivity(intent);
                        }
                    });

                    dialog.show();


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.info:
                //mostrar dialogo:
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle("Información");
                dialog.setMessage("Proyecto de examen del 3er trimestre");

                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                dialog.show();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }
}