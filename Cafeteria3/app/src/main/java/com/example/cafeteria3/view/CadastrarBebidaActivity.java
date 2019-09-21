package com.example.cafeteria3.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cafeteria3.R;
import com.example.cafeteria3.dao.BebidaRepository;

public class CadastrarBebidaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_bebida);
        Button btn = findViewById(R.id.btnCadastrar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BebidaRepository bebidaRepository = new BebidaRepository(getBaseContext());
                EditText nome = findViewById(R.id.editTextNome);
                EditText descricao = findViewById((R.id.editTextDescricao));
                EditText preco = findViewById(R.id.editTextPreco);
                String resultado = bebidaRepository.insert(nome.getText().toString(), descricao.getText().toString(), preco.getText().toString());
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                cleanFields();
            }
        });
    }

        private void cleanFields(){
            EditText nome = findViewById(R.id.editTextNome);
            EditText descricao = findViewById((R.id.editTextDescricao));
            EditText preco = findViewById(R.id.editTextPreco);
            nome.setText("");
            descricao.setText("");
            preco.setText("");
        }


    }
