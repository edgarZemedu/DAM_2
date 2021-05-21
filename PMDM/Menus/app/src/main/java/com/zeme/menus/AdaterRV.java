package com.zeme.menus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.List;

public class AdaterRV extends RecyclerView.Adapter<AdaterRV.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items,null,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //ASIGNAR DATOS
        holder.tvItems.setText(laLista.get(position));
    }
    @Override
    public int getItemCount() {
        return laLista.size();
    }

    /*********************************************************************************/
    private List<String> laLista;

    public AdaterRV(List<String> ciudades){
        this.laLista = ciudades;
    }

    //CLASE 2
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvItems;

        //CONSTRUCTOR 2
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItems = itemView.findViewById(R.id.tvItems);
        }

    }
}

