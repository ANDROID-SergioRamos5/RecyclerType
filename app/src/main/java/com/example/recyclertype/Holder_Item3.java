package com.example.recyclertype;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Holder_Item3 extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView txtCorto;
    ImageView imageView;
    TextView textoLargo;
    Button boton1;
    Button boton2;
    onClickBotonListener listenerBoton;
    Datos datos;

    public Holder_Item3(@NonNull View itemView) {
        super(itemView);

        txtCorto = itemView.findViewById(R.id.txt_title);
        imageView = itemView.findViewById(R.id.imageView);
        textoLargo = itemView.findViewById(R.id.textViewL);
        boton1 = itemView.findViewById(R.id.bShare);
        boton2 = itemView.findViewById(R.id.bExplore);

        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);
    }

    public void bind(Datos datos)
    {
        txtCorto.setText(datos.getTextoCorto());
        imageView.setImageBitmap(datos.getFoto());
        textoLargo.setText(datos.getTextoLargo());
    }


    public void ClickBoton(onClickBotonListener listener)
    {
        if(listener != null)
            this.listenerBoton = listener;
    }


    @Override
    public void onClick(View view) {
        if (listenerBoton != null) listenerBoton.onClickBoton(datos);
    }
}
