package com.example.penhaapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.penhaapp.R;
import com.example.penhaapp.dao.OcorrenciaRepository;

public class CadastraOcorrenciaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_ocorrencia);
    }

    public void cadastraOcorrenciaOnclick(View v) {
        OcorrenciaRepository ocorrenciaRepository = new OcorrenciaRepository(getBaseContext());
        EditText ocorrencia = findViewById(R.id.editTextTipo);
        EditText descricao =  findViewById((R.id.editTextDescricao));
        EditText data =  findViewById(R.id.editTextData);
        String resultado = ocorrenciaRepository.insert(ocorrencia.getText().toString(), descricao.getText().toString(), data.getText().toString());
        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
        limparCampos();
        Intent intencao = new Intent(this, ListaOcorrenciasActivity.class);
        startActivity(intencao);
    }

    private void limparCampos(){
        EditText tipo = findViewById(R.id.editTextTipo);
        EditText descricao = findViewById((R.id.editTextDescricao));
        EditText data = findViewById(R.id.editTextData);
        tipo.setText("");
        descricao.setText("");
        data.setText("");
    }
}
