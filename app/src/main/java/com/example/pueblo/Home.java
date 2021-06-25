package com.example.pueblo;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Home extends AppCompatActivity {
    ArrayList<ActividadTuristica> Tarjetas = new ArrayList<>();
    RecyclerView grafico;

    FirebaseFirestore baseDatos=FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        grafico = findViewById(R.id.listado);
        grafico.setHasFixedSize(true);
        grafico.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        listado();



    }




    //Encargada de cambiar la configuracion de idioma del telefono
    public void cambiarIdioma(String lenguaje){

        Locale idioma=new Locale(lenguaje);// tipo de datos que recibe el lenguaje a configurar en el telefono
        Locale.setDefault(idioma);//se establece el lenguaje del telefono

        Configuration configurationtelefono=getResources().getConfiguration();
        configurationtelefono.locale=idioma;
        getBaseContext().getResources().updateConfiguration(configurationtelefono,getBaseContext().getResources().getDisplayMetrics());
    }



    //metodo de enacargado de pintar el menu de opciones
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }
    //metodo para controlar la accion (lo que quiero hacer) de cada elemento del menu

    public boolean onOptionsItemSelected(MenuItem item){

        int id=item.getItemId();

        switch (id){
            case(R.id.opcion1):

                Intent intent1=new Intent(Home.this,Acercade.class);
                startActivity(intent1);
                break;

            case(R.id.opcion2):

                cambiarIdioma("en");
                Intent intent2=new Intent(Home.this,Home.class);
                startActivity(intent2);

                break;

            case(R.id.opcion3):

                cambiarIdioma("es");
                Intent intent3=new Intent(Home.this,Home.class);
                startActivity(intent3);

                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void crearlista2(){
        Tarjetas.add(new ActividadTuristica("prueba", "prueba","prueba"));
    }



    private void listado() {
        baseDatos.collection("sahagun")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Home.this, "entre", Toast.LENGTH_SHORT).show();

                            for (QueryDocumentSnapshot document : task.getResult()) {
                                String actividad=document.get("actividad").toString();
                                String informacion=document.get("informacion").toString();
                                String fotosahagun=document.get("foto").toString();

                               Tarjetas.add(new ActividadTuristica(actividad,informacion,fotosahagun));
                            }
                            ListaAdaptador adaptador = new ListaAdaptador(Tarjetas);
                            grafico.setAdapter(adaptador);


                        } else {
                            Toast.makeText(Home.this, "Error en la consulta", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }


}
