package com.example.adaptadores2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void toEj01Activity(View view) {
        startActivity(new Intent(this, Ej01Activity.class));
    }

    public void toEj02Activity(View view) {
        startActivity(new Intent(this, Ej02Activity.class));
    }

    public void toEj03Activity(View view) {
        startActivity(new Intent(this, Ej03Activity.class));
    }

    public void toEj04Activity(View view) {
        startActivity(new Intent(this, Ej04Activity.class));
    }
}
