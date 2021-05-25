package com.zeme.examen2ev_pdmd_z;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class RV extends AppCompatActivity {

    RV rv;
    private List<LenguajesProgramacion> listaLenguajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);


        listaLenguajes = new ArrayList<>();
        listaLenguajes.add(LenguajesProgramacion.newInstance("Java", "https://ubiqum.com/assets/uploads/2019/10/screenshot-2021-02-11-at-115416.png"));
        listaLenguajes.add(LenguajesProgramacion.newInstance("Kotlin", "https://kotlinlang.org/assets/images/open-graph/kotlin_250x250.png"));
        listaLenguajes.add(LenguajesProgramacion.newInstance("JavaScript", "https://i.pinimg.com/originals/12/49/49/1249492264f909cc540ddc8e87419e42.png"));
        listaLenguajes.add(LenguajesProgramacion.newInstance("Swift", "https://upload.wikimedia.org/wikipedia/commons/7/78/Swift_logo.png"));
        listaLenguajes.add(LenguajesProgramacion.newInstance("Python", "http://assets.stickpng.com/images/5848152fcef1014c0b5e4967.png"));
        listaLenguajes.add(LenguajesProgramacion.newInstance("PHP", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/27/PHP-logo.svg/1280px-PHP-logo.svg.png"));
        listaLenguajes.add(LenguajesProgramacion.newInstance("C#", "https://seeklogo.com/images/C/c-sharp-c-logo-02F17714BA-seeklogo.com.png"));
        listaLenguajes.add(LenguajesProgramacion.newInstance("Go", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/Go_Logo_Blue.svg/1200px-Go_Logo_Blue.svg.png"));
        listaLenguajes.add(LenguajesProgramacion.newInstance("Rust", "Esto va a fallar al convertir a URL"));

    }

    public void cargarLista(View view) {
        getSupportFragmentManager().beginTransaction().
                add(R.id.fragment,new ItemsFragment(listaLenguajes))
                .commit();
    }

}