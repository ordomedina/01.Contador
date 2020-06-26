package com.example.contador;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    public int contador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contador= 0;
        mostrarResultado();

        EventoTeclado teclado = new EventoTeclado();

        EditText reseteo = (EditText) findViewById(R.id.reseteo);

        reseteo.setOnEditorActionListener(teclado);
    }

    class EventoTeclado implements TextView.OnEditorActionListener{
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if(actionId == EditorInfo.IME_ACTION_DONE){
                reseteaContador(null);
            }
            return false;
        }
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
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        Integer aux;
        try{
            aux = Integer.parseInt(numReset.getText().toString());
            if(aux >=0 && !checkBox.isChecked()){
                contador = aux;
            }else if(checkBox.isChecked()){
                contador = Integer.parseInt(numReset.getText().toString());
            }
        }catch (Exception e){
            contador = 0;
        }
        numReset.setText("");
        mostrarResultado();


        InputMethodManager miTeclado = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        miTeclado.hideSoftInputFromWindow(numReset.getWindowToken(),0);


    }

   public void mostrarResultado(){
        TextView textoResultado = (TextView) findViewById(R.id.contadorTexto);
        textoResultado.setText(""+contador);
    }


}