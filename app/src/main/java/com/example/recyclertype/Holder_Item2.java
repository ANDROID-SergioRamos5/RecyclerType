package com.example.recyclertype;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Holder_Item2 extends RecyclerView.ViewHolder {

    TextView txtCorto;
    ImageView imageView;

    public Holder_Item2(@NonNull View itemView) {
        super(itemView);

        txtCorto = itemView.findViewById(R.id.txt_title);
        imageView = itemView.findViewById(R.id.imageView);
    }

    public void bind(Datos datos)
    {
        txtCorto.setText(datos.getTextoCorto());
        imageView.setImageBitmap(datos.getFoto());
    }
}
