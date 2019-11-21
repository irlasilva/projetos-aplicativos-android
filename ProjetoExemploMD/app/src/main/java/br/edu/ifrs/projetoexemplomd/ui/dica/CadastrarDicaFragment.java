package br.edu.ifrs.projetoexemplomd.ui.dica;

import android.content.Context;
import android.os.Bundle;
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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import br.edu.ifrs.projetoexemplomd.R;
import br.edu.ifrs.projetoexemplomd.model.Dica;

public class CadastrarDicaFragment extends Fragment{

    private List<Dica> listDicas ;
    EditText assunto, descricao;

    public List<Dica> getListPessoas() {
        return listDicas;
    }

    public void setListDicas(List<Dica> listPessoas) {
        this.listDicas = listDicas;
    }

     public CadastrarDicaFragment(){}

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_cadastrar_dica, container, false);
        assunto = root.findViewById(R.id.txt_fragment_cadastro_assunto_dica);
        descricao = root.findViewById(R.id.txt_fragment_cadastro_descricao_dica);

        Button btnCad = root.findViewById(R.id.btnSalvar);
        btnCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listDicas.add(new Dica(assunto.getText().toString(), descricao.getText().toString()));
                Toast.makeText(getContext(), "no click!",
                        Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }

    public void insertDica(Dica dica) {
        //loaderVisibility.set(View.VISIBLE);
        FirebaseDatabase
                .getInstance()
                .getReference()
                .child("dicas")
                .push()
                .setValue(dica)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getActivity(), "Great Success", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "Erro ao cadastrar", Toast.LENGTH_SHORT).show();
            }
        });
    }
}