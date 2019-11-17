package br.edu.ifrs.projetoexemplomd.ui.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

import br.edu.ifrs.projetoexemplomd.R;
import br.edu.ifrs.projetoexemplomd.dao.SettingsFirebase;
import br.edu.ifrs.projetoexemplomd.model.Dica;

public class CadastroDicaActivity extends AppCompatActivity {
    DatabaseReference reference = SettingsFirebase.getNoRaiz();
    ProgressBar loader;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_dica);
        loader = findViewById(R.id.cadastrar_dica_loader);
    }

    private void cadastrarDica(View view) {
        String assunto = ((EditText)findViewById(R.id.txt_activity_cadastro_assunto_dica)).getText().toString();
        String descricao = ((EditText)findViewById(R.id.txt_activity_cadastro_descricao_dica)).getText().toString();
        Dica dica = new Dica(assunto, descricao);
        DatabaseReference dicas = reference.child("dicas");
        //gera um identificador único para cada dica
        //salva na base de dados
        dicas.push().setValue(dica).addOnSuccessListener(new OnSuccessListener<Void>() {
            //conde colocar o loader
            //loader.setVisibility(View.VISIBLE);
            @Override
            public void onSuccess(Void aVoid) {
                Log.d("cadastro dica", "great success");
                Toast.makeText(CadastroDicaActivity.this, "Great success", Toast.LENGTH_SHORT).show();
                limparCampos();
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("cadastro dica", "deu errado");
                        Toast.makeText(CadastroDicaActivity.this, "Erro ao cadastrar dica!", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void limparCampos(){
        ((EditText)findViewById(R.id.txt_activity_cadastro_assunto_dica)).setText("");
        ((EditText)findViewById(R.id.txt_activity_cadastro_descricao_dica)).setText("");
    }
}
