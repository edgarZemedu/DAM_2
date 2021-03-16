package com.example.a7_p2_eventos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.a7_p2_eventos.Ej04Activity.NOMBRE;
import static com.example.a7_p2_eventos.Ej04Activity.TRATAMIENTO;

public class Ej042ResultSecondActivity extends AppCompatActivity {

    static final String DESPEDIDA = "despedida";

    RadioGroup rgDespedida;
    TextView tvSaludo04;
    CheckBox cbDespedida;

    String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej04_second);

        cbDespedida = findViewById(R.id.cbDespedida04);
        tvSaludo04 = findViewById(R.id.tvSaludo04);
        rgDespedida = findViewById(R.id.rgDespedida04);


        Bundle bundle = getIntent().getExtras();

        nombre = bundle.getString(NOMBRE);
        String tratamiento = bundle.getString(TRATAMIENTO);

        tvSaludo04.setText(tratamiento + " " + nombre);



        cbDespedida.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {  // Si se ha marcado, se muestra el RadioGroup
                    rgDespedida.setVisibility(View.VISIBLE);
                } else {  // Y si se se ha desmarcado, se quita
                    rgDespedida.setVisibility(View.GONE);
                }

            }
        });


        findViewById(R.id.btnVolver04).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();

                int checkedDespedida = rgDespedida.getCheckedRadioButtonId();


                if (!cbDespedida.isChecked()) {
                    setResult(Activity.RESULT_CANCELED);
                    finish();
                } else {
                    if (checkedDespedida == -1) {
                        Toast.makeText(Ej042ResultSecondActivity.this, "Debe introducir una despedida", Toast.LENGTH_SHORT).show();

                    } else {

                        String despedida =
                                ((RadioButton) findViewById(checkedDespedida)).getText().toString()
                                + ", " + nombre + ".";


                        setResult(Activity.RESULT_OK, intent.putExtra(DESPEDIDA, despedida));
                        finish();
                    }

                }

            }
        });



    }


}