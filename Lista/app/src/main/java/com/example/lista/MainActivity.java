package com.example.lista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> list = new ArrayList<>();
    private EditText texto;
    private Button delete, add, search;
    private TextView aviso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = (EditText)findViewById(R.id.editText);
        add = (Button)findViewById(R.id.btnSave);
        delete = (Button)findViewById(R.id.btnDelete);
        search = (Button)findViewById(R.id.btnSearch);
        aviso = (TextView)findViewById(R.id.txtInf);

        //list.add("China");

        if(list.isEmpty()){
            aviso.setText("No hay registros");
        }
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        final MyAdapter myAdapter = new MyAdapter(list);
        recyclerView.setAdapter(myAdapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add(texto.getText().toString());
                RecyclerView recyclerView = findViewById(R.id.recyclerView);
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(myAdapter);
                texto.setText("");
                aviso.setText("");
            }
        });

        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                if(!list.isEmpty()){
                    myAdapter.remove(list.size()-1);
                }else{
                    aviso.setText("No hay registros");
                }
            }
        });

        search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!list.isEmpty()){
                    if(!texto.getText().toString().equals("")){
                        List<String> pivote = new ArrayList<>();
                        for (int i = 0; i <= list.size()-1; i++) {
                            if(list.get(i).contains(texto.getText().toString())){
                                pivote.add(list.get(i));
                            }
                        }
                        if(!pivote.isEmpty()){
                            RecyclerView recyclerView = findViewById(R.id.recyclerView);
                            recyclerView.setHasFixedSize(true);
                            final MyAdapter myAdapter = new MyAdapter(pivote);
                            recyclerView.setAdapter(myAdapter);
                            texto.setText("");
                        }else{
                            //mensaje mostrado en Toast
                            Toast.makeText(MainActivity.this, "No hay ese registro",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        //mensaje mostrado en Toast
                        Toast.makeText(MainActivity.this, "Ingrese el texto a buscar",
                                Toast.LENGTH_SHORT).show();
                    }
                }else{
                    aviso.setText("No hay registros");
                }
            }
        });

    }

}
