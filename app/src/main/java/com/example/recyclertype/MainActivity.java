package com.example.recyclertype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.BitmapFactory;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Datos> datos;
    private static final int TYPE_ITEM_1 = 0;
    private static final int TYPE_ITEM_2 = 1;
    private static final int TYPE_ITEM_3 = 2;

    RecyclerView recycler;
    Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        añadirDatos();

        recycler = findViewById(R.id.lista);
        adaptador = new Adaptador(this);
        recycler.setAdapter(adaptador);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));

    }


    private void añadirDatos()
    {
        datos = new ArrayList<>();
        datos.add(new Datos("Cohete espacial","Soy un cohete espacial que viajo por el espacio interestela",
                BitmapFactory.decodeResource(this.getResources(), R.drawable.cohete_flat),TYPE_ITEM_1));
        datos.add(new Datos("Coordillera de noche","No hay nada como una noche plácida en la montaña, ¿verdad?"
                ,BitmapFactory.decodeResource(this.getResources(), R.drawable.material_flat),TYPE_ITEM_2));
        datos.add(new Datos("London city","No hay nada como pasear por la orilla del Támesis en una mañana con niebla",
                BitmapFactory.decodeResource(this.getResources(), R.drawable.london_flat),TYPE_ITEM_3));
        datos.add(new Datos("Discovery en la noche","Viajar al epacio, recorrer la vía láctea, y volver a casa con mi Discovery...",
                BitmapFactory.decodeResource(this.getResources(), R.drawable.moon_flat),TYPE_ITEM_3));
    }
}
