package com.example.recyclertype;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Holder_Item2 extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView txtCorto;
    ImageView imageView;
    onImagenClickListener listener;
    ImageView boton1;
    ImageView boton2;
    ImageView boton3;
    Datos datos;

    public Holder_Item2(@NonNull View itemView) {
        super(itemView);

        txtCorto = itemView.findViewById(R.id.txt_title);
        imageView = itemView.findViewById(R.id.imageView);
        boton1 = itemView.findViewById(R.id.imageView1);
        boton2 = itemView.findViewById(R.id.imageView2);
        boton3 = itemView.findViewById(R.id.imageView3);

        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);
        boton3.setOnClickListener(this);
    }

    public void bind(Datos datos)
    {
        txtCorto.setText(datos.getTextoCorto());
        imageView.setImageBitmap(datos.getFoto());
    }

    public void ClickImagen(onImagenClickListener listener)
    {
        if(listener != null) this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null) listener.onImagenClick(datos);
    }
}
