package com.example.contador;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    public int contador;
    TextView textoResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoResultado = (TextView) findViewById(R.id.contadorTexto);
        contador= 0;
    }

    public void incrementaContador(View vista){
        contador++;
        mostrarResultado();
    }

    public void decrementaContador(View vista){
        CheckBox negativos = (CheckBox) findViewById(R.id.checkBox);
        contador--;
        if(contador<0 && !negativos.isChecked()){
                contador = 0;
        }
        mostrarResultado();
    }

    public void reseteaContador(View vista){
        EditText numReset= (EditText) findViewById(R.id.reseteo);
        try{
            contador = Integer.parseInt(numReset.getText().toString());
        }catch (Exception e){
            contador = 0;
        }
        numReset.setText("");
        mostrarResultado();
    }

   public void mostrarResultado(){
        TextView textoResultado = (TextView) findViewById(R.id.contadorTexto);
        textoResultado.setText(""+contador);
    }
}