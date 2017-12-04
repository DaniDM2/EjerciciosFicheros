package com.example.dm2.ejerciciosficheros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ejercicio3 extends AppCompatActivity {
    private ListView lista;
    private ArrayList<Web>webs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3);

        webs= new ArrayList<Web>();

        //leemos los recursos
        InputStream is=getResources().openRawResource(R.raw.recurso);
        BufferedReader br= new BufferedReader(new InputStreamReader(is));
        try {
            String line=br.readLine();
            while(line!=null){
                //A partir de lo que tenemos en cada liena nos crea una lista que despues el adapdtador mostrara
                String[] datos=line.split(";");
                webs.add(new Web(datos[0],datos[1],datos[2],Integer.parseInt(datos[3])));
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Las imagenes no es posible ponerlas ya que se accedee a ella mendiante un int
        Adaptador ad=new Adaptador(this,webs);
        lista=(ListView)findViewById(R.id.lista);
        lista.setAdapter(ad);
    }
}
