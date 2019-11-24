package br.edu.ifrs.appfragmentos.ui.add;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrs.appfragmentos.R;
import br.edu.ifrs.appfragmentos.model.Pessoa;

public class AddFragment extends Fragment implements View.OnClickListener{

    private List<Pessoa> listPessoas ;
    EditText nome, endereco;

    public List<Pessoa> getListPessoas() {
        return listPessoas;
    }

    public void setListPessoas(List<Pessoa> listPessoas) {
        this.listPessoas = listPessoas;
    }

     public AddFragment(){}

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_add, container, false);
        nome = root.findViewById(R.id.editTextNome);
        endereco = root.findViewById(R.id.editTextEndereco);

        Button btnCad = root.findViewById(R.id.buttonAdd);
        btnCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listPessoas.add(new Pessoa(nome.getText().toString(), endereco.getText().toString()));
                Toast.makeText(getContext(), "no click!",
                        Toast.LENGTH_SHORT).show();
                listener.itemClicked(1, -1);
            }
        });
        return root;
    }

    @Override
    public void onClick(View v) {  }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (FragmentListener) context;
    }
    public static interface FragmentListener {
        void itemClicked(int idOrigem, int posicao);
    }

    private FragmentListener listener;


}