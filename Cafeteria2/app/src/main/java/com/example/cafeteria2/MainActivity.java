package com.example.cafeteria2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lista;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = findViewById(R.id.menu);
        //o this informa que a classe atual irá tratar os eventos da lista
        lista.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> a, View v, int position, long id) {

        if (position == 0) {
            //this = origem, CardapioActivity = destino
            Intent intent = new Intent(this, CardapioActivity.class);
            startActivity(intent);
        }
        if (position == 1) {
        }
    }
}
