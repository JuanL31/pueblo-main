package com.example.pueblo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView nombrecomida1;
    TextView informacion;
    ImageView sahagun1;
    ActividadTuristica actividadTuristica;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombrecomida1=findViewById(R.id.nombre1);
        sahagun1=findViewById(R.id.sahagun1);
        informacion=findViewById(R.id.informacion);

        actividadTuristica =(ActividadTuristica)getIntent().getSerializableExtra("datos");

        nombrecomida1.setText(actividadTuristica.getActividad());
        informacion.setText(actividadTuristica.getInformacion());
    }
}