package com.example.dm2.ejerciciosficheros;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    String fichIntern="ficheroInterno.txt";
    String fichExterno="ficheroSD.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void añadirFichInt(View v){
        EditText text= (EditText) findViewById(R.id.txtCampo);
        try {
            OutputStreamWriter osw= new OutputStreamWriter(openFileOutput(fichIntern, Context.MODE_PRIVATE));
            osw.write(text.getText().toString());
            osw.close();
            text.setText("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void añadirFichExt(View v){
        EditText text= (EditText) findViewById(R.id.txtCampo);
        String estado= Environment.getExternalStorageState();
        Log.i("Memoria",estado);
        Log.i("Memoria -2",Environment.MEDIA_MOUNTED);

        if (estado.equals(Environment.MEDIA_MOUNTED)){
            File rutaSD=Environment.getExternalStorageDirectory();
            File f= new File(rutaSD.getAbsolutePath(),fichExterno);

            try {
                OutputStreamWriter osw= new OutputStreamWriter(new FileOutputStream(f));
                osw.write(text.getText().toString());
                osw.close();
                text.setText("");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void leerFichInterno(View v){
        TextView txt= (TextView) findViewById(R.id.txtFichero);
        try {
            BufferedReader buf= new BufferedReader(new InputStreamReader(openFileInput(fichIntern)));
            txt.setText(buf.readLine());
            buf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leerFichExterno(View v){
        TextView txt= (TextView) findViewById(R.id.txtFichero);
        String estado= Environment.getExternalStorageState();
        Log.i("Memoria",estado);

        if (estado.equals(Environment.MEDIA_MOUNTED)){
            File rutaSD=Environment.getExternalStorageDirectory();
            File f= new File(rutaSD.getAbsolutePath(),fichExterno);

            try {
                BufferedReader buf= new BufferedReader(new InputStreamReader(new FileInputStream(f)));
                txt.setText(buf.readLine());
                buf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void leerRecurso(View v){
        TextView txt= (TextView) findViewById(R.id.txtFichero);
        InputStream is=getResources().openRawResource(R.raw.recurso);
        BufferedReader br= new BufferedReader(new InputStreamReader(is));
        try {
            String line=br.readLine();
            txt.setText(line);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void eliminarFichExterno(View v){
        File dir=Environment.getExternalStorageDirectory();
        File f= new File(dir,fichExterno);
            //Borramos el archivo
            if(f.delete())
                Toast.makeText(getApplicationContext(),"No se pudo borrar el archvio =(",LENGTH_SHORT).show();
            else
                Toast.makeText(getApplicationContext(),"Se ha borrado el archivo =)",LENGTH_SHORT).show();

    }

    public void eliminarFichInterno(View v){
        File dir = new File(fichIntern);
        //comprueba si es directorio.
        if (dir.isDirectory())
        {Log.i("Memoria","DIRECFTORIIO");
            //obtiene un listado de los archivos contenidos en el directorio.
            String[] hijos = dir.list();
            //Elimina los archivos contenidos.
            for (int i = 0; i < hijos.length; i++)
            {
                new File(dir, hijos[i]).delete();
            }
        }else{
            Log.i("Memoria","ARCHIVO!");
            //Borramos el archivo
           if(getBaseContext().deleteFile(fichIntern))
               Toast.makeText(getApplicationContext(),"No se pudo borrar el archvio =(",LENGTH_SHORT);
            else
               Toast.makeText(getApplicationContext(),"Se ha borrado el archivo =)",LENGTH_SHORT);
        }
    }

    public  void Ejercicio2(View v){
        Intent intento=new Intent(MainActivity.this, Ejercicio2.class);
        startActivity(intento);
    }

    public  void Ejercicio3(View v){
        Intent intento=new Intent(MainActivity.this, Ejercicio3.class);
        startActivity(intento);
    }
}
