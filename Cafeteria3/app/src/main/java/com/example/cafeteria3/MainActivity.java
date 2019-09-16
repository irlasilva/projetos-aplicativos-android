package com.example.cafeteria3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.cafeteria3.view.CadastrarBebidaActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //adicionar o Layout que irá usar - arquivo activity_main
        ListView listaOpcoes = this.findViewById(R.id.lista);
       // String[] itens = listaOpcoes.get
        //ArrayAdapter<String> arrayItens = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,itens);
        //listaOpcoes.setAdapter(arrayItens);
        listaOpcoes.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        if (position == 0 ) {
            Intent intent = new Intent(this, CadastrarBebidaActivity.class);
            startActivity(intent);
        }

        else{
            Intent intent = new Intent(this, ListarBebidasActivity.class);
            startActivity(intent);
        }
    }
}
