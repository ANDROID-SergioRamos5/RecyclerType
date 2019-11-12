package com.example.recyclertype;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adaptador extends RecyclerView.Adapter {

    Context context;
    Holder holder;
    Datos datos;

    public Adaptador(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;

        switch (datos.tipo){
            case 0:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_1,parent,false);
                break;
            case 1:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_2  ,parent,false);
                break;
            case 2:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_3,parent,false);
        }

        holder = new Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((Holder)holder).bind(((MainActivity)context).datos.get(position));
    }

    @Override
    public int getItemCount() {
        return ((MainActivity)context).datos.size();
    }
}
