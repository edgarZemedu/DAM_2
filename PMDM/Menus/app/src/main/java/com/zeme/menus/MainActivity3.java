package com.zeme.menus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    RecyclerView rv;
    List<String> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        rv = findViewById(R.id.rv);
        lista = new ArrayList<>(
                Arrays.asList(
                        getResources().getStringArray(R.array.ciudades)
                )
        );
        rv.setAdapter(new AdaterRV(lista));
        rv.setLayoutManager(new LinearLayoutManager(this));
        //rv.setLayoutManager(new GridLayoutManager(this,2));
    }

}