package com.zeme.menus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    ListView lv;
    List<String> lista;
    ArrayAdapter<String> adapter;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lv = findViewById(R.id.lv);
        tv = findViewById(R.id.textView);
        lista = new ArrayList<>(
                Arrays.asList(
                        getResources().getStringArray(R.array.ciudades)
                )
            );
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,lista);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                /*adapterView.getSelectedItem().toString()*/
                Toast.makeText(getApplicationContext(),"Has elegido "+ lv.getItemAtPosition(i) ,Toast.LENGTH_SHORT).show();
            }
        });
        registerForContextMenu(lv);
        registerForContextMenu(tv);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //basicamente te pone el título al menu
        if (v.getId() == R.id.textView){
            menu.setHeaderTitle(tv.getText().toString());
        }else{
            AdapterView.AdapterContextMenuInfo infoAdap = (AdapterView.AdapterContextMenuInfo) menuInfo;
            menu.setHeaderTitle(lv.getAdapter().getItem(infoAdap.position).toString());
        }
        getMenuInflater().inflate(R.menu.menu1,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        Toast.makeText(getApplicationContext(),"Has elegido "+ item.toString() ,Toast.LENGTH_SHORT).show();

        return super.onContextItemSelected(item);
    }
}