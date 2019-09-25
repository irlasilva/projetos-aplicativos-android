package com.example.cafeteria3.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.cafeteria3.R;
import com.example.cafeteria3.adapter.LinhaAdapter;
import com.example.cafeteria3.dao.BebidaRepository;
import com.example.cafeteria3.model.Bebida;

import java.util.List;

public class ListarBebidasActivity extends AppCompatActivity { //eu sou uma atividade

    private ListView listBebidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_bebidas);
        listBebidas = this.findViewById(R.id.listViewBebidas);
        this.getAll();
    }

    protected  void getAll(){
        BebidaRepository bebidaRepository = new BebidaRepository(this);
        List<Bebida> bebidas = bebidaRepository.getAll();
        listBebidas.setAdapter(new LinhaAdapter(this, bebidas)); //linha consulta Adapter!
    }
}
