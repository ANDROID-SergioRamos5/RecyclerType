package com.example.recyclertype;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adaptador extends RecyclerView.Adapter implements View.OnClickListener, View.OnLongClickListener{

    Context context;
    Holder_Item1 holder;
    Holder_Item2 holder2;
    Holder_Item3 holder3;
    Datos datos;
    View.OnClickListener listener;
    View.OnLongClickListener longListener;

    public Adaptador(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;

        if (viewType == 0)
        {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_1,parent,false);
            v.setOnClickListener(this);
            v.setOnLongClickListener(this);
            return new Holder_Item1(v);
        }
        else if (viewType == 1)
        {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_2,parent,false);
            v.setOnClickListener(this);
            v.setOnLongClickListener(this);
            return new Holder_Item2(v);
        }
        else
        {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_3,parent,false);
            v.setOnClickListener(this);
            v.setOnLongClickListener(this);
            return new Holder_Item3(v);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (getItemViewType(position))
        {
            case 0:
                ((Holder_Item1)holder).bind(((MainActivity)context).datos.get(position));
                break;
            case 1:
                ((Holder_Item2)holder).bind(((MainActivity)context).datos.get(position));
                break;
            case 2:
                ((Holder_Item3)holder).bind(((MainActivity)context).datos.get(position));
                break;
            case 3:
                ((Holder_Item3)holder).bind(((MainActivity)context).datos.get(position));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return ((MainActivity)context).datos.size();
    }

    @Override
    public int getItemViewType(int position) {
        switch(position) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            default:
                return -1;
        }
    }


    public void setClickListener(View.OnClickListener listener)
    {
        if(listener != null)
            this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener != null) listener.onClick(v);
    }


    public void setLongListener(View.OnLongClickListener longListener)
    {
        if (longListener != null)
            this.longListener = longListener;
    }

    @Override
    public boolean onLongClick(View v) {
        if (longListener != null)
            longListener.onLongClick(v);
        return true;
    }
}
