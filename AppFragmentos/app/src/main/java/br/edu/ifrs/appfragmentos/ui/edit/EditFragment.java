package br.edu.ifrs.appfragmentos.ui.edit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;
import java.util.Objects;

import br.edu.ifrs.appfragmentos.R;
import br.edu.ifrs.appfragmentos.model.Pessoa;

public class EditFragment extends Fragment implements View.OnClickListener {
       private  List<Pessoa> lista;

    public List<Pessoa> getLista() {
        return lista;
    }

    public void setLista(List<Pessoa> lista) {
        this.lista = lista;
    }

    public EditFragment() {
        }

        public static interface FragmentListener {
            void itemClicked(int idOrigem, int posicao);
        }

        private FragmentListener listener;

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_edit, container, false);
        }

        @Override
        public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {

            final EditText nome = view.findViewById(R.id.editNome);
            final EditText endereco = view.findViewById(R.id.editEndereco);
            final int posicao = getArguments().getInt("posicao");

            nome.setText(lista.get(posicao).getNome());
            endereco.setText(lista.get(posicao).getEndereco());
            //final RespostaUser respostaUser = new RespostaUser();
            Button button = view.findViewById(R.id.buttonEdit);
            button.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceType")
                @Override
                public void onClick(View v) {
                    lista.set(posicao, new Pessoa(nome.getText().toString(), endereco.getText().toString()));
                    listener.itemClicked(1, -1);
                }
            });
        }

        public static EditFragment newInstance() {
            return new EditFragment();
        }

        @Override
        public void onClick(View v) {  }

        @Override
        public void onAttach(Context context) {
            super.onAttach(context);
            this.listener = (EditFragment.FragmentListener) context;
        }
    }


