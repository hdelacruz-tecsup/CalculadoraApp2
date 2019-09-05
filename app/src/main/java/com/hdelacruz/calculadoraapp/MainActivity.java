package com.hdelacruz.calculadoraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText te1,te2,lab1,lab2,lab3,lab4;
    private Spinner tipo_spiner;
    String[] promedios = {"20% T + 80% L","40% T + 60% L","30% T + 70% L"};
    String SpinnerValue;
    Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        te1 = (EditText)findViewById(R.id.prom1);
        te2 = (EditText)findViewById(R.id.prom2);
        lab1 = (EditText)findViewById(R.id.prom1_lab);
        lab2 = (EditText)findViewById(R.id.prom2_lab);
        lab3 = (EditText)findViewById(R.id.prom3_lab);
        lab4 = (EditText)findViewById(R.id.prom4_lab);
        tipo_spiner = (Spinner) findViewById(R.id.tipo_spiner);
        Button calcular =(Button)findViewById(R.id.calcular);

        calcular.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                final TextView tvResultado = (TextView) findViewById(R.id.prom1);
                int aux1 = Integer.valueOf(te1.getText().toString());
                int aux2 = Integer.valueOf(te2.getText().toString());
                double resultado = (aux1 + aux2)/2;
                tvResultado.setText(""+resultado);
//Determina el promedio de laboratorio
                final TextView tvResultado1 = (TextView) findViewById(R.id.prom2);
                int aux3 = Integer.valueOf(lab1.getText().toString());
                int aux4 = Integer.valueOf(lab2.getText().toString());
                int aux5 = Integer.valueOf(lab3.getText().toString());
                int aux6 = Integer.valueOf(lab4.getText().toString());
                double resultado1= (aux3 + aux4+ aux5 + aux6)/4;
                tvResultado1.setText(""+resultado1);

                final TextView Resultadofinal = (TextView) findViewById(R.id.Promedio_txt);
                final TextView mensaje = (TextView) findViewById(R.id.result);
                switch (SpinnerValue) {
                    case "20% T + 80% L":
                        double resultadofinal=Math.abs(resultado*0.2+resultado1*0.8);
                        Resultadofinal.setText(""+Math.abs(resultadofinal));
                        if (resultadofinal <= 13){
                            mensaje.setText("DESAPROBADO");
                        }else {
                            mensaje.setText("APROBADO");
                        }
                        break;
                    case "40% T + 60% L":
                        double resultadofinal1=Math.abs(resultado*0.4+resultado1*0.6);
                        Resultadofinal.setText(""+resultadofinal1);
                        if (resultadofinal1 <= 13){
                            mensaje.setText("DESAPROBADO");
                        }else {
                            mensaje.setText("APROBADO");
                        }
                        break;
                    case "30% T + 70% L":
                        double resultadofinal2=Math.abs(resultado*0.3+resultado1*0.7);
                        Resultadofinal.setText(""+resultadofinal2);
                        if (resultadofinal2 <= 13){
                            mensaje.setText("DESAPROBADO");
                        }else {
                            mensaje.setText("APROBADO");
                        }
                        break;
                }
            }
        });

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1, promedios);
        tipo_spiner.setAdapter(adapter);
        tipo_spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SpinnerValue=(String)tipo_spiner.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
