package com.example.whathsapp;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.whathsapp.placeholder.PlaceholderContent.PlaceholderItem;
import com.example.whathsapp.databinding.FragmentItemBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {
    Context context;
    private final List<Contactos> listaContactos;

    public MyItemRecyclerViewAdapter(List<Contactos> items) {
        listaContactos = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item,parent, false);
        return new ViewHolder(view);
    }
    //vinculación
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        //holder.imagen.setImageResource(miLista.get(positixºon).);
        holder.nombre.setText(listaContactos.get(position).getNombre());

        if(position%2==0){
            holder.mView.setBackgroundColor(Color.GRAY);
            holder.nombre.setBackgroundColor(Color.CYAN);
            holder.edad.setBackgroundColor(Color.CYAN);
        }

        holder.nombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), holder.toString(),Toast.LENGTH_SHORT).show();
                ;            }
        });/*
        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaContactos.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,getItemCount());
                Toast.makeText(v.getContext(),"borrado...",Toast.LENGTH_LONG).show();
            }
        });*/

    }
    //tamaño
    @Override
    public int getItemCount() {
        return listaContactos.size();
    }

    //es una clase por si sola del fragment_item
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView ;
        public final TextView nombre;
        private TextView edad;
        //public PlaceholderItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            nombre = view.findViewById(R.id.nombre);
            edad = view.findViewById(R.id.edad);

        }

        @Override
        public String toString() {
            return nombre.getText().toString();
        }
    }



}