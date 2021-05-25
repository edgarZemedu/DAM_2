package com.zeme.examen2ev_pdmd_z;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    static final String ALBUM_MESSAGE = "ooo";
    static List <String> listaAlbum;
    Spinner sp;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = findViewById(R.id.spinner);
        boton = findViewById(R.id.button);

        listaAlbum = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.albums_base)));
        ArrayAdapter<String> a = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listaAlbum);
        sp.setAdapter(a);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==0){
                    boton.setEnabled(true);
                }else{
                    boton.setEnabled(false);
                    Toast.makeText(MainActivity.this,
                            "Has seleccionado "+adapterView.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void añadirAlbum(View view) {
        startActivityForResult(new Intent(this,addAlbums.class), 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 1){
            listaAlbum.add(data.getStringExtra(ALBUM_MESSAGE));
            Toast.makeText(this,data.getStringExtra(ALBUM_MESSAGE),Toast.LENGTH_SHORT).show();
        }
    }
    /****************************/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        MainActivity activity;
        switch (item.getItemId()){
            case R.id.itemRV:
                startActivity(new Intent(MainActivity.this, RV.class));
                break;
            case R.id.itemFrag:
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
}