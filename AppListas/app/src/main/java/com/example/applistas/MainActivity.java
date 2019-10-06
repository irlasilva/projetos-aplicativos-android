package com.example.applistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = findViewById(R.id.listaPrincipal);
        //o this informa que a classe atual irá tratar os eventos da lista
        lista.setOnItemClickListener(this);
    }

    //Este método recuperar a posição do elemento selecionado na lista, ou seja, seu índice
    public void onItemClick(AdapterView<?> a, View v, int position, long id) {

        if (position == 0) {
            // Se clicar no item “Ufs” abre uma intenção explícita
            //this corresponde a janela atual - origem
            //ListaIfsActivity.class corresponde ao destino - para onde vai
            Intent intent = new Intent(this, ListaIfsActivity.class);
            startActivity(intent);
        }

        else {
            //Se clicar no item “IFRS Campus POA” abre uma intenção implícita com a localização do campus no mapa
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0? q=-30.0264276,-51.2233058(IFRS POA)?z=15"));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
            if (position == 2) {
                // se clicar no item "Sobre" mostra uma mensagem com dados do app
                Toast.makeText(getApplicationContext(), "Sobre meu app. Hello toast!", Toast.LENGTH_LONG).show();
            }

    }
}
