package com.example.intencoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        Intent intencao = getIntent();
        String parametro = ((Intent) intencao).getStringExtra(MainActivity.NOME);

        TextView txtNome = findViewById(R.id.textNomeMostrar);
        txtNome.setText(parametro);
    }
}
