package com.example.dm2.ejerciciosficheros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ejercicio2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);

        Spinner sp= (Spinner)findViewById(R.id.spin);
        ArrayList<String> arr= new ArrayList<String>();
        //LEEMOS LOS RECURSOS
        InputStream is=getResources().openRawResource(R.raw.recurso);
        BufferedReader br= new BufferedReader(new InputStreamReader(is));
        try {
            String line=br.readLine();

            while(line!=null){
                arr.add(line);
                line=br.readLine();
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,arr);
        sp.setAdapter(adapter);

    }
}
