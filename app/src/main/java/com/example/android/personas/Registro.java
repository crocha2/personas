package com.example.android.personas;

import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class Registro extends AppCompatActivity {

    private EditText nomb, apell, edad;
    private CheckBox leer, bailar, programar;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        res = this.getResources();
        nomb = (EditText)findViewById(R.id.txtNombre);
        apell = (EditText)findViewById(R.id.txtApellido);
        edad = (EditText)findViewById(R.id.txtEdad);
        leer=(CheckBox)findViewById(R.id.chkleer);
        bailar=(CheckBox)findViewById(R.id.chkbailar);
        programar= (CheckBox)findViewById(R.id.chkProgramar);

    }

    public void registrar(View v){
        String foto;

        String aux="", nombre, apellido, ed;
        nombre= nomb.getText().toString().trim();
        apellido=apell.getText().toString().trim();
        ed = edad.getText().toString().trim();

        if(leer.isChecked()) aux = res.getString(R.string.leer);
        if(bailar.isChecked()) aux = aux+", "+getString(R.string.bailar);
        if(programar.isChecked()) aux = aux+", "+getString(R.string.programar);

        foto = String.valueOf(fotoAleatoria());
        Persona p = new Persona(foto, nombre, apellido, ed, aux);
        p.guardar();

        new AlertDialog.Builder(this).setMessage(res.getString(R.string.mensaje)).show();

        limpiar();
    }

    public void borrar(View v){
        limpiar();
    }

    public void limpiar(){
        nomb.setText("");
        apell.setText("");
        edad.setText("");
        leer.setChecked(true);
        bailar.setChecked(false);
        programar.setChecked(false);
        nomb.requestFocus();
    }

    public int fotoAleatoria(){
        int  fotos[]={R.drawable.imagen1, R.drawable.imagen2, R.drawable.imagen3};
        int numero = (int) (Math.random() *3);
        return fotos[numero];
    }

}
