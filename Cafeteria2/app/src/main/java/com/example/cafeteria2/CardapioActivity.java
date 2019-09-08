package com.example.cafeteria2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;

public class CardapioActivity extends ListActivity { //está dizendo que é uma lista

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView lista = getListView();

        //busca as Ufs que estão declaradas na variavel Ufs - arquivo String
        String itensMenu[] = getResources().getStringArray(R.array.itensMenu);

        setContentView(R.layout.activity_cardapio);
    }
}
