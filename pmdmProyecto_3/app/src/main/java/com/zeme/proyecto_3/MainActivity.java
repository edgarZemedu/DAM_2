package com.zeme.proyecto_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void OnClickFrutas(View view) {  //alternativa con switch
        startActivity(new Intent(this,Ej1Activity.class));
    }

    public void toActivity(View view) {
        switch (((Spinner) findViewById(R.id.spinnerMain)).getSelectedItemPosition()){
            case 0:
                startActivity(new Intent(this, Ej2Activity.class));
                break;
            case 1:
                startActivity(new Intent(this, Ej3Activity.class));
                break;
            case 2:
                startActivity(new Intent(this, Ej4Activity.class));
                break;
        }
    }
}