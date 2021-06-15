package com.example.gil_raquel_examen3t;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.Inflater;

public class Activity2 extends AppCompatActivity {
    RecyclerView lv_rock;
    private List<Album> gen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.contenedor,   //ahí es donde queremos añadir el nuevo Fragment
                        ListaFragment.newInstance())
                .commit();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu3, menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.ver:
                //mostrar dialogo:
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle("Actualiza géneros");

                dialog.setPositiveButton("MOSTRAR SELECCIÓN", new DialogInterface.OnClickListener() {
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