package com.example.cafeteria3.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.cafeteria3.R;
import com.example.cafeteria3.dao.BebidaRepository;
import com.example.cafeteria3.model.Bebida;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView opcoesMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //adicionar o Layout que irá usar - arquivo activity_main
        opcoesMenu = this.findViewById(R.id.menu);
        opcoesMenu.setOnItemClickListener(this);

//        para verificar os dados no banco
//        BebidaRepository bebidaRepository = new BebidaRepository(this);
//        List<Bebida> bebidas = bebidaRepository.getAll();
//        Log.d("meubanco","tamanh0=" + bebidas.size());
//        for (Bebida b : bebidas){
//            Log.d("meubanco",b.getNome());
//        }
    }

    //Este método recuperar a posição do elemento selecionado na lista, ou seja, seu índice
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
