package com.example.bouzada_francisco_examen3t;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bouzada_francisco_examen3t.dummy.DummyContent.DummyItem;
import com.google.android.material.snackbar.Snackbar;


import java.util.List;


public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private Context context;

    private List<ListaAlbums> listadoAlbums;


    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Recuperamos el contexto y lo dejamos en una variable global para poder referenciarlo después.
        context = parent.getContext();

        View view = LayoutInflater.from(context)
                .inflate(R.layout.elemento6, parent, false);

        return new ViewHolder(view);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView textView;
        public final TextView textView1;
        public final ImageView imageView;
        public final ImageView info1;
        public final ImageView remove;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            textView = (TextView) view.findViewById(R.id.textView);
            textView1 = (TextView) view.findViewById(R.id.textView1);
            imageView = (ImageView) view.findViewById(R.id.imageView);
            remove = (ImageView) view.findViewById(R.id.remove);
            info1 = (ImageView) view.findViewById(R.id.info1);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    public MyItemRecyclerViewAdapter(List<ListaAlbums> dataSet) {
        listadoAlbums = dataSet;
    }


    @Override
    public void onBindViewHolder(MyItemRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.textView.setText(listadoAlbums.get(position).getTitulo());
        holder.textView1.setText(listadoAlbums.get(position).getGrupo());
        holder.imageView.setImageResource(listadoAlbums.get(position).getImagen());


        holder.info1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Información");
                String mensaje = (listadoAlbums.get(position).getTitulo() + "\n" + listadoAlbums.get(position).getDescripcion());
                builder.setMessage(mensaje);
                builder.setCancelable(false);

                builder.setPositiveButton("CERRAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                Snackbar.make(view, (listadoAlbums.get(position).getTitulo() + " - " + listadoAlbums.get(position).getGrupo()), Snackbar.LENGTH_LONG)
                        .setAction("INFORMACIÓN", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                builder.show(); // Mostramos el Diálogo
                            }
                        }).show();


            }
        });


        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listadoAlbums.remove(position);
                // notificamos la eliminación del elemento
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, listadoAlbums.size());
            }
        });

    }


    @Override
    public int getItemCount() {
        return listadoAlbums.size();
    }
}