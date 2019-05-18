///UNIVERSIDAD CENTRAL DEL ECUADOR
//FACULTAD DE INGENIERÍA, CIENCIAS FÍSICAS Y MATEMÁTICA
//INGENIERÍA INFORMÁTICA
//Nombre: Ximena Campaña

package com.example.suma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText numero1,numero2;
    private Button sumar;
    //private Integer valor1,valor2, resul;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero1 = (EditText)findViewById(R.id.txt1);
        numero2 = (EditText)findViewById(R.id.txt2);
        sumar = (Button)findViewById(R.id.btnSuma);


        sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int valor1 = Integer.parseInt(numero1.getText().toString());
                int valor2 = Integer.parseInt(numero2.getText().toString());
                int resulsuma = valor1 + valor2;
                System.out.println(resulsuma);
                Intent i = new Intent(MainActivity.this, Respuesta.class);
                i.putExtra("Resultado",resulsuma);
                startActivity(i);
            }
        });
    }
}
