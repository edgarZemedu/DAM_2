package com.zeme.examen2ev_pdmd_z;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    private final List<LenguajesProgramacion> miLista;

    public Adapter(List<LenguajesProgramacion> items) {
        this.miLista = items;
    }
//cargo cada uno de los fragments
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();

        View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.fragment_items,parent, false);
        return new ViewHolder(view);

    }
//vinculación
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        //holder.imagen.setImageResource(miLista.get(positixºon).);
        holder.nombre.setText(miLista.get(position).getNombre());
        Glide.with(context)
                // Busca en internet la ruta de una imagen
                .load(miLista.get(position).getImagen())
                // Indicamos una imagen local para usar mientras no se recupera la de Internet
                .placeholder(R.drawable.generica)
                // Indicamos la vista de destino
                .into(holder.imagen);


        if(position%2==0){
                holder.mView.setBackgroundColor(Color.GRAY);
            }

        holder.nombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), holder.toString(),Toast.LENGTH_SHORT).show();
;            }
        });
        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miLista.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,getItemCount());
                Toast.makeText(v.getContext(),"borrado...",Toast.LENGTH_LONG).show();
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
        public final ImageView imagen;
        public final TextView nombre;
        private ImageView remove;
        //public PlaceholderItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            imagen = (ImageView) view.findViewById(R.id.imageView);
            nombre = view.findViewById(R.id.nombre);
            remove = view.findViewById(R.id.imageRemove);

        }

        @Override
        public String toString() {
            return nombre.getText().toString();
        }
    }
}