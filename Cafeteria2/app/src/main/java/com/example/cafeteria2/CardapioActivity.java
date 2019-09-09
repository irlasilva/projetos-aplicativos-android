package com.example.cafeteria2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CardapioActivity extends ListActivity { //está dizendo que é uma lista

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_cardapio);
        ListView lista = getListView();

        ArrayAdapter<Cardapio> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,Cardapio.bebidas);
        lista.setAdapter(listAdapter);
    }

    //definir métodos que irá tratar os eventos dessa lista
    public void onListItemClick(ListView lista, View view, int position, long id) {
        //converte para string o item selecionado
        String itemLista = lista.getItemAtPosition(position).toString();
        Toast.makeText(getApplicationContext(), itemLista, Toast.LENGTH_LONG).show();
    }
}
