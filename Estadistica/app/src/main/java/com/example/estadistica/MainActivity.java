package com.example.estadistica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    TextView tv;
    List<Integer> a;
    int uNumero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.editTextNumberDecimal);
        tv = findViewById(R.id.tv);
         
        if (et1.getText() != null){

        }

        Toast.makeText(this,"  ******->  "+uNumero,Toast.LENGTH_LONG).show();

    }

    public void boton(View view) {


    }
}