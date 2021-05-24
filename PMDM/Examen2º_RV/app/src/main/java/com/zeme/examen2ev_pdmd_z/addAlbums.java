package com.zeme.examen2ev_pdmd_z;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.zeme.examen2ev_pdmd_z.MainActivity.ALBUM_MESSAGE;

public class addAlbums extends AppCompatActivity {

    EditText et,et2;
    RadioGroup rg;
    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_albums);

        et = findViewById(R.id.editText);
        et2 = findViewById(R.id.editText2);
        rg = findViewById(R.id.radioGroup);
        sp = findViewById(R.id.spinner2);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.rbMetal){
                    ArrayAdapter aa = ArrayAdapter.createFromResource(addAlbums.this,R.array.Metal,R.layout.support_simple_spinner_dropdown_item);
                    sp.setAdapter(aa);
                    sp.setVisibility(View.VISIBLE);
                }else{
                    ArrayAdapter aa = ArrayAdapter.createFromResource(addAlbums.this,R.array.Rock,R.layout.support_simple_spinner_dropdown_item);
                    sp.setAdapter(aa);
                    sp.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    public void buscar(View view) {
        String album = et.getText().toString();
        String artista = et2.getText().toString();

        if (album.matches("\\s") && artista.matches("\\s")){
            Toast.makeText(this,"Error al introducir",Toast.LENGTH_SHORT).show();
        }else{
            try{
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q="+album+"+"+artista)));
            }catch(ActivityNotFoundException a){
                Toast.makeText(this,"infor no encontrado",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void añadir(View view) {
        String album = et.getText().toString();
        String artista = et2.getText().toString();
        //RadioButton rb = (RadioButton)
        int i = rg.getCheckedRadioButtonId();

        if (album.matches("\\s*")){
            Toast.makeText(this,"Error al introducir el album",Toast.LENGTH_SHORT).show();
        } else if(artista.matches("\\s*")){
            Toast.makeText(this,"Error al introducir el artista",Toast.LENGTH_SHORT).show();
        }else if(i == -1){
            Toast.makeText(this,"Error, elige un género",Toast.LENGTH_SHORT).show();
        }else{
            setResult(RESULT_OK, new Intent().putExtra(ALBUM_MESSAGE,album+" - "+artista));
            finish();
        }

    }
}