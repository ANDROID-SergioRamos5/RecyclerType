package com.example.recyclertype;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adaptador extends RecyclerView.Adapter implements View.OnClickListener, View.OnLongClickListener{

    Context context;
    Datos datos;
    View.OnClickListener listener;
    View.OnLongClickListener longListener;
    onImagenClickListener listenerImg;
    onClickBotonListener listenerbtn;
    int TYPE_ITEM_1 = 0;
    int TYPE_ITEM_2 = 1;
    int TYPE_ITEM_3 = 2;

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

            Holder_Item2 holder2 = new Holder_Item2(v);
            holder2.ClickImagen(new onImagenClickListener() {
                @Override
                public void onImagenClick(Datos datos) {
                    listenerImg.onImagenClick(datos);
                }
            });
            return holder2;
        }
        else
        {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_3,parent,false);
            v.setOnClickListener(this);
            v.setOnLongClickListener(this);

            Holder_Item3 holder3 = new Holder_Item3(v);
            holder3.ClickBoton(new onClickBotonListener() {
                @Override
                public void onClickBoton(Datos datos) {
                    listenerbtn.onClickBoton(datos);
                }
            });
            return holder3;
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
        return position;
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

    public void ClickImagen(onImagenClickListener listener)
    {
        if (listener != null) listenerImg = listener;
    }

    public void ClickBoton(onClickBotonListener listener)
    {
        if (listener != null) listenerbtn = listener;
    }
}
