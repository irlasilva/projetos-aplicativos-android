package br.edu.ifrs.projetoexemplomd.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

import br.edu.ifrs.projetoexemplomd.R;
import br.edu.ifrs.projetoexemplomd.dao.SettingsFirebase;
import br.edu.ifrs.projetoexemplomd.model.Dica;

public class CadastroDicaFragment extends Fragment implements Button.OnClickListener{

    Button button;
    EditText assuntoDica;
    TextInputEditText descricaoDica;
    View root;
    DatabaseReference dicasReference;
    String idDica ="";
    ArrayList<Dica> dicasList = new ArrayList();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_cadastro_dica, container, false);
        button = root.findViewById(R.id.btn_cadastro_dica);
        button.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View view) {
        assuntoDica = root.findViewById(R.id.txt_fragment_cadastro_assunto_dica);
        descricaoDica = root.findViewById(R.id.txt_fragment_cadastro_descricao_dica);
        Dica dica = new Dica(assuntoDica.getText().toString(), descricaoDica.getText().toString());
        cadastrar(dica);
    }

    private void cadastrar(Dica dica) {
        DatabaseReference reference = SettingsFirebase.getNoRaiz();
        DatabaseReference produtos = reference.child("dicas");
        //gera um identificador único para cada produto
        //salva o produto na base de dados
        produtos.push().setValue(dica).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d("cadastro dica", "deu certo");
                Toast.makeText(getContext(), "Sucesso ao cadastrar dica!", Toast.LENGTH_SHORT).show();
                limparCampos();
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("cad", "deu errado");
                        Toast.makeText(getContext(), "Erro ao cadastrar dica!", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    private void limparCampos(){
        ((TextInputEditText)root.findViewById(R.id.txt_fragment_cadastro_assunto_dica)).setText("");
        ((EditText)root.findViewById(R.id.txt_fragment_cadastro_descricao_dica)).setText("");
    }
}
