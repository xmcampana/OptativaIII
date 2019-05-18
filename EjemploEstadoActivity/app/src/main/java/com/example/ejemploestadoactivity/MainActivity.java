package com.example.ejemploestadoactivity;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView aleatorio;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aleatorio=(TextView)findViewById(R.id.textAleatorio);
        if(savedInstanceState != null){
            num=savedInstanceState.getInt("aleatorio");
            aleatorio.setText(String.valueOf(num));
        }
        else
        {
            num=generarAleatorio(50);
            aleatorio.setText(String.valueOf(num));
        }

    }

    private int generarAleatorio(int numero){
        return ((int)(Math.random()*numero));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("aleatorio",num);
        super.onSaveInstanceState(outState);
    }
}
