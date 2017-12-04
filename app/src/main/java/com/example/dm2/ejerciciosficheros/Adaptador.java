package com.example.dm2.ejerciciosficheros;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dm2 on 23/10/2017.
 */

public class Adaptador extends ArrayAdapter<Web> {

    ArrayList<Web> websArr=null;

    public Adaptador(@NonNull Context context, @NonNull ArrayList<Web> webs) {
        super(context, R.layout.vistaweb, webs);
        websArr=webs;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater= LayoutInflater.from(getContext());
        View item=inflater.inflate(R.layout.vistaweb,null);

        //CAMBIAMOS LA IMAGEN
        ImageView img= (ImageView)item.findViewById(R.id.imagenWeb);
        String imagenRuta = websArr.get(position).getImagen();
        if (imagenRuta.equalsIgnoreCase("google"))
            img.setImageResource(R.drawable.google);


        //CAMBIANOS EL TEXTO
        TextView txt=(TextView) item.findViewById(R.id.nombre);
        txt.setText(websArr.get(position).getNombre());

        //El id
        TextView txtId=(TextView) item.findViewById(R.id.idWeb);
        txtId.setText( Integer.toString(websArr.get(position).getId()));

//        //El link a la web
//        Button btnLink=(Button)item.findViewById(R.id.btnLink);
//        btnLink.setText("Link a "+websArr.get(position).getNombre());

        return (item);
    }
}