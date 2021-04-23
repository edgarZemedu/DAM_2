package com.example.estadistica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    TextView tv;
    ArrayList<Integer> a;
    int uNumero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.editTextNumberDecimal);
        tv = findViewById(R.id.tv);
        a = new ArrayList<Integer>();
        uNumero = Integer.parseInt(String.valueOf(et1.getText()));
        //while(uNumero == 37){
            if (et1.getText() != null){
                Toast.makeText(this," ** bien ->  "+uNumero,Toast.LENGTH_SHORT).show();
            }
            a.add(uNumero);
            Toast.makeText(this,"  ******->  "+uNumero,Toast.LENGTH_SHORT).show();
        //}
    }

    public void boton(View view) {
        if (!a.isEmpty()){
            for (int i = 0; i < a.size(); i++){
                tv.setText(a.get(i));
                Toast.makeText(this,"deberia mostrarse",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this,"Arraylist vacio",Toast.LENGTH_SHORT).show();
        }

    }
}