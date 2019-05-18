package com.example.suma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Respuesta extends AppCompatActivity {

    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respuesta);

        Bundle extras =getIntent().getExtras();
        int r = extras.getInt("Resultado");
        String re = Integer.toString(r);
        //System.out.println("activity2"+r);
        resultado = (TextView)findViewById(R.id.txtResp);

        resultado.setText(re);

    }
}
