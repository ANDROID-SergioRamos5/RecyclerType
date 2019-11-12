package com.example.recyclertype;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Holder extends RecyclerView.ViewHolder {

    TextView txtCorto;

    public Holder(@NonNull View itemView) {
        super(itemView);

        txtCorto = itemView.findViewById(R.id.txt_title);

    }

    public void bind(Datos datos)
    {
        txtCorto.setText(datos.getTextoCorto());


    }
}
