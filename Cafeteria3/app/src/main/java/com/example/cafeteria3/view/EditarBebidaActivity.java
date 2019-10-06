package com.example.cafeteria3.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cafeteria3.R;
import com.example.cafeteria3.dao.BebidaRepository;
import com.example.cafeteria3.model.Bebida;

public class EditarBebidaActivity extends AppCompatActivity {
    private int _id = 0; //não esquecer o underscore na declaração do id
    EditText editTextNome;
    EditText editTextDescricao;
    EditText editTextPreco; //no código da profe está como private porque??? lá refere-se ao campo data
    Button btnEditar;
    private DatePickerDialog datePickerDialogData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_bebida);
        editTextNome = this.findViewById(R.id.editTextNomeEditar);
        editTextDescricao =  this.findViewById(R.id.editTextDescricaoEditar);
        editTextPreco =  this.findViewById(R.id.editTextPrecoEditar);
        btnEditar =  this.findViewById(R.id.btnEditar);

        //cria evento para o botão
        btnEditar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                alterar();
            }
        });

        BebidaRepository bebidaRepository = new BebidaRepository(this);

        //Pega o id do objeto que foi passado como parâmetro
        Bundle extra =  this.getIntent().getExtras();
        _id = extra.getInt("_id");

        //Pega o bojeto usando o id
        Bebida bebida = bebidaRepository.getBebida(_id); //busca no banco a bebida que tem a chave primaria que tem como parametro _id

        editTextNome.setText(bebida.getNome());
        editTextDescricao.setText(bebida.getDescricao());
        editTextPreco.setText(bebida.getPreco());
    }
    private void alterar(){
        if(editTextNome.getText().toString().trim().equals("")){
            Toast.makeText(getApplicationContext(), "Nome é obrigatório!", Toast.LENGTH_LONG).show();
            editTextNome.requestFocus();
        }
        else if(editTextDescricao.getText().toString().trim().equals("")){
            Toast.makeText(getApplicationContext(), "Descrição é obrigatório!", Toast.LENGTH_LONG).show();
            editTextDescricao.requestFocus();
        }
        else if(editTextPreco.getText().toString().trim().equals("")){
            Toast.makeText(getApplicationContext(), "Preço é obrigatório!", Toast.LENGTH_LONG).show();
            editTextPreco.requestFocus();
        }
        else {
            Bebida bebida = new Bebida();
            bebida.set_id(_id);
            bebida.setNome(editTextNome.getText().toString().trim());
            bebida.setDescricao(editTextDescricao.getText().toString().trim());
            bebida.setPreco(editTextPreco.getText().toString().trim());
            int linhasAfetadas = new BebidaRepository(this).update(bebida);
            String msg = "Registro alterado com sucesso! ";
            if(linhasAfetadas == 0 ) msg = "Registro não foi alterado! ";
            //mostrando caixa de diálogo de sucesso
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setTitle(R.string.app_name);
            alertDialog.setMessage(msg);
            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    // Forçando que o código retorne para a tela de consulta
                    Intent intent = new Intent(getApplicationContext(), ListarBebidasActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
            alertDialog.show();
        }
    }

}
