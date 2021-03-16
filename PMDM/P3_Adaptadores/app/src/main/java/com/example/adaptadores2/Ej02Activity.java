package com.example.adaptadores2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class Ej02Activity extends AppCompatActivity {

    static final String MENSAJE_FRUTAS = "frutas";

    private ArrayList<String> frutas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej02);
        frutas = new ArrayList<>();
    }

    public void anadir(View view) {
        String fruta = ((EditText)findViewById(R.id.et01)).getText().toString();
        if (!fruta.isEmpty()) {
            frutas.add(fruta);
        }
        ((EditText)findViewById(R.id.et01)).getText().clear();
    }

    public void acabar(View view) {
        Intent intent = new Intent(this, Ej02OtraActivity.class);
        intent.putExtra(MENSAJE_FRUTAS, frutas);
        startActivity(intent);
    }

}
