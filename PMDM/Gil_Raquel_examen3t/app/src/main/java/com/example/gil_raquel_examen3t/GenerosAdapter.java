package com.example.gil_raquel_examen3t;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GenerosAdapter extends RecyclerView.Adapter<GenerosAdapter.ViewHolder> {

    private List<Album> listadoRock;
    Button informacion;
    Button eliminar;

    public GenerosAdapter(List<Album> listadoDatos) {
        this.listadoRock = listadoDatos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemrv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.logo.setImageResource(listadoRock.get(position).getIdImagen());
        holder.nombre.setText(listadoRock.get(position).getNombre());
        holder.autor.setText(listadoRock.get(position).getAutor());

        informacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(v.getContext());
                dialog.setTitle( listadoRock.get(position).getNombre() + " - " + listadoRock.get(position).getAutor());
                dialog.setMessage(listadoRock.get(position).getBio());
                dialog.setPositiveButton("CERRAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.create().show();

            }
        });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //eliminar elemento
                listadoRock.remove(listadoRock.get(position));

           }
        });

    }

    @Override
    public int getItemCount() {
        return listadoRock.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView logo;
        public final TextView nombre;
        public final TextView autor;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            logo = (ImageView) view.findViewById(R.id.imageView2);
            nombre = (TextView) view.findViewById(R.id.textView3);
            autor = (TextView) view.findViewById(R.id.textView4);
            informacion =(Button) view.findViewById(R.id.button);
            eliminar = (Button) view.findViewById(R.id.button2);
        }

        @Override
        public String toString() {
            return nombre.getText().toString();
        }
    }



}