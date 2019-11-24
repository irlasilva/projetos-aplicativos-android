package br.edu.ifrs.appexemplo2.ui.cad;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;

import br.edu.ifrs.appexemplo2.R;
import br.edu.ifrs.appexemplo2.dao.ConfiguraFirebase;
import br.edu.ifrs.appexemplo2.model.Produto;


public class CadFragment extends Fragment implements Button.OnClickListener{

    Button button;
    TextInputEditText nome;
    TextInputEditText descricao;
    TextInputEditText valorUnitario;
    View root;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_cad, container, false);
        button = root.findViewById(R.id.btnCadProd);
        button.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View view) {
        nome = root.findViewById(R.id.txtNome);
        descricao = root.findViewById(R.id.txtDesc);
        valorUnitario = root.findViewById(R.id.txtValorUnitario);
        Produto produto = new Produto(nome.getText().toString(), descricao.getText().toString(), Double.parseDouble(valorUnitario.getText().toString()));
        cadastrar(produto);
    }

    private void cadastrar(Produto produto) {
        DatabaseReference reference = ConfiguraFirebase.getNoRaiz();
        DatabaseReference produtos = reference.child("produtos");
        //gera um identificador único para cada produto
        //salva o produto na base de dados
        produtos.push().setValue(produto).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d("cad", "deu certo");
                Toast.makeText(getContext(), "Sucesso ao cadastrar produto!", Toast.LENGTH_SHORT).show();
                limparCampos();
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("cad", "deu errado");
                        Toast.makeText(getContext(), "Erro ao cadastrar produto!", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    private void limparCampos(){
        ((TextInputEditText)root.findViewById(R.id.txtNome)).setText("");
        ((TextInputEditText)root.findViewById(R.id.txtDesc)).setText("");
        ((TextInputEditText)root.findViewById(R.id.txtValorUnitario)).setText("");
    }
}
