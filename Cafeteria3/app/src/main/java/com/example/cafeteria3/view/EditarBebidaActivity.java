package com.example.cafeteria3.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.cafeteria3.R;

public class EditarBebidaActivity extends AppCompatActivity {
    private int id = 0;
    EditText editTextNome;
    EditText editTextDescricao;
    EditText editTextPreco; //no código da profe está como private porque??? lá refere-se ao campo data
    Button btnEditar;
    private DatePickerDialog datePickerDialogData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_bebida);
        editTextNome = this.findViewById(R.id.editTextNomeEdit);
        editTextDescricao =  this.findViewById(R.id.editTextDescricaoEdit);
        editTextPreco =  this.findViewById(R.id.editTextPrecoEdit);
        btnEditar =  this.findViewById(R.id.btnEditar);
    }
}
