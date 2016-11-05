package com.example.a41.imcaplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView textViewResultado;
    int color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.btn_calcular);
       /* fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

         textViewResultado = (TextView) findViewById(R.id.textResultado);
    }



    public void calcularIMC(View view) {
        Log.d(TAG,"Entra a calcular IMC con el click");
        EditText editTextALtura = (EditText) findViewById(R.id.textEditAltura);
        EditText editTextPeso = (EditText) findViewById(R.id.textEditPeso);

        String altura = editTextALtura.getText().toString();
        String peso = editTextPeso.getText().toString();
        if(altura.isEmpty() && peso.isEmpty()){ return; }
        if(altura.matches("\\d+") && peso.matches("\\d+")){
            float cm = Integer.valueOf(altura);
            float kg = Integer.valueOf(peso);
            calcular(cm, kg);

        }
    }

    private void calcular( float cm, float kg) {
        cm = (cm/100);
        float bmi = kg /(cm * cm);
        String resultado;
        if(bmi < 16){
            resultado = "Tu BMI: " + bmi + "(Severamente bajo)";
            color = Color.RED;
        }else if(bmi < 18.5){
            resultado = "Tu BMI: " + bmi + "( Bajo)";
            color = Color.YELLOW;
        }else if(bmi < 25){
            resultado = "Tu BMI: " + bmi + "( Normal)";
            color = Color.GREEN;
        }else if(bmi < 30){
            resultado = "Tu BMI: " + bmi + "( Sobre peso)";
            color = Color.YELLOW;
        }else{
            resultado = "Tu BMI: " + bmi + "( Obeso)";
            color = Color.RED;
        }

        textViewResultado.setText(resultado);
        textViewResultado.setTextColor(color);
        Log.i(TAG,"resultado: "+resultado);


    }
}
