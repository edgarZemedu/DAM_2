package com.example.whathsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Contactos> listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menumain,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        MainActivity activity;
        switch (item.getItemId()){
            case R.id.itemMenu1:
                //startActivity(new Intent(MainActivity.this, RV.class));
                break;
            case R.id.itemMenu3:
                /*
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment_content_main, new FirstFragment())
                        .commit();
                 */
                Toast.makeText(this, "Lo siento,no has diseñado nada!!!!", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "Ups!!!!", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    public void onClickContactos(View view) {
        getSupportFragmentManager().beginTransaction().add(R.id.mifragmentContainer,new ItemFragment(listaContactos)).commit();
    }


}