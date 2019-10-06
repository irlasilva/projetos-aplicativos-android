package com.example.cafeteria2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DescricaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao);

        Intent intent = getIntent();
        int posicao = intent.getIntExtra("posicao", 0);

       // int posicao = intent.getExtras().get(Cardapio.bebidas);
        Cardapio cafes = Cardapio.bebidas[posicao];

        String tipo = cafes.getTipo();
        TextView tipoBebida = findViewById(R.id.textDescricao);
        tipoBebida.setText(tipo);

        //preenche o nome da bebida
        String nome = cafes.getNome();
        TextView nomeBebida = findViewById(R.id.textNomeBebida);
        tipoBebida.setText(nome);

        //preenche a imagem do produto
        int idImagem = cafes.getIdImagem();
        ImageView img = findViewById(R.id.imgBebida);
        img.setImageResource(cafes.getIdImagem());
        img.setContentDescription(cafes.getNome()); //caso não consiga mostrar a imagem mostrará um texto
    }
}


