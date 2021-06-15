package com.example.freiria_zamedu_examen3t;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private static final int REQUEST_CODE = 1;
    Context context;
    private final List<Album> miLista;


    public MyAdapter(List<Album> listaGenero) {
        this.miLista = listaGenero;
    }

    //cargo cada uno de los fragments
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);

        return new ViewHolder(view);

    }
    //vinculación
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        //holder.imagen.setImageResource(miLista.get(positixºon).);
        holder.nombre.setText(miLista.get(position).getNombre());
        holder.grupo.setText(miLista.get(position).getGrupo());
        holder.imagen.setImageResource(miLista.get(position).getImagen());

        /*holder.nombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), holder.toString(),Toast.LENGTH_SHORT).show();
            }
        });*/
        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miLista.remove(position);
                // notificamos la eliminación del elemento
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, miLista.size());
            }
        });
        holder.imagenInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //info SnackBarr
                AlertDialog.Builder dialog = new AlertDialog.Builder(v.getContext());
                dialog.setTitle( miLista.get(position).getImagen());
                dialog.setMessage(miLista.get(position).getDescripcion());
                dialog.setPositiveButton("CERRAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.create().show();

            }
        });

    }
    //tamaño
    @Override
    public int getItemCount() {
        return miLista.size();
    }

    //es una clase por si sola del fragment_item
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView ;
        public final TextView nombre;
        public final TextView grupo;
        public final ImageView imagen;
        public final ImageView remove;
        private final ImageView imagenInfo;
        //public PlaceholderItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            imagenInfo = (ImageView) view.findViewById(R.id.imageInfo);
            remove = (ImageView) view.findViewById(R.id.imageRemove);
            grupo = view.findViewById(R.id.grupo);
            imagen = (ImageView) view.findViewById(R.id.imageView);
            nombre = view.findViewById(R.id.nombre);

        }

        @Override
        public String toString() {
            return nombre.getText().toString();
        }
    }
}