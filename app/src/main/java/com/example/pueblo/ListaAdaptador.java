package com.example.pueblo;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class ListaAdaptador extends RecyclerView.Adapter<ListaAdaptador.viewHolder> {

    ArrayList<ActividadTuristica> listadeDatos;

    public ListaAdaptador(ArrayList<ActividadTuristica> listadeDatos) {
        this.listadeDatos = listadeDatos;
    }

    @NonNull
    @Override
    public ListaAdaptador.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vistaDelItemLista= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista,parent,false);

        return new viewHolder(vistaDelItemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaAdaptador.viewHolder holder, int position) {
        holder.actualizarDatos(listadeDatos.get(position));

    }

    @Override
    public int getItemCount() {
        return listadeDatos.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView nombrecomida1;
        TextView informacion;
        ImageView sahagun1;


        public viewHolder(@NonNull View itemView) {
            super(itemView);
            nombrecomida1=itemView.findViewById(R.id.nombre1);
            sahagun1=itemView.findViewById(R.id.sahagun1);
            informacion=itemView.findViewById(R.id.informacion);

        }

        public void actualizarDatos(ActividadTuristica actividadTuristica) {
            nombrecomida1.setText(actividadTuristica.getActividad());
            informacion.setText(actividadTuristica.getInformacion());
            Picasso.with(itemView.getContext())
                    .load(actividadTuristica.getFotosahagun())
                    .into(sahagun1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(itemView.getContext(),MainActivity.class);
                    intent.putExtra("datos",actividadTuristica);
                    itemView.getContext().startActivity(intent);




                }
            });

        }
    }


}

