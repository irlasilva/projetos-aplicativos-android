package com.example.cafeteria2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //o android vai usar esse layout para executar os componentes

        //quando clicar vai fazer o que está abaixo - somente quando clicar
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(MainActivity.this, CardapioActivity.class);
                    startActivity(intent);
                }
            }
        };

        // um listener para cada lista - criar o laço if nesse caso
        //quando é botão fazer um listener para cada botão
        ListView listView = findViewById(R.id.menu);
        listView.setOnItemClickListener(itemClickListener);
    }

}
