package br.edu.ifrs.projetoexemplomd.ui.home;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import br.edu.ifrs.projetoexemplomd.R;
import br.edu.ifrs.projetoexemplomd.model.Telefone;
import br.edu.ifrs.projetoexemplomd.ui.info.InfoFragment;
import br.edu.ifrs.projetoexemplomd.ui.telefone.TelefoneFragment;

import static androidx.databinding.DataBindingUtil.inflate;

public class HomeFragment extends Fragment { //implements View.OnClickListener{ //está dizendo eu sou um fragmento

    private HomeViewModel homeViewModel;
    private TextView card_mapa_text_view;
    private TextView card_quiz_text_view;
    private TextView card_dicas_text_view;
    private TextView card_telefones_text_view;

    //método que caracteriza o fragmento onCreateView
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflate(inflater, R.layout.fragment_home, container, false).getRoot();
        //Button btnVoltar = root.findViewById(R.id.button_fragment_voltar);


        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bind(view);
        setClick();
    }

    private void bind(View view) {
        card_mapa_text_view = view.findViewById(R.id.mapa_text_view);
        card_quiz_text_view = view.findViewById(R.id.quiz_text_view);
        card_dicas_text_view = view.findViewById(R.id.dicas_text_view);
        card_telefones_text_view = view.findViewById(R.id.telefones_text_view);

    }

    private void setClick(){
        card_mapa_text_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //abrir o mapa com locais específicos
            }
        });

        card_quiz_text_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chamar o InfoFragment
            }
        });

        card_dicas_text_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chamar o Fragment

            }
        });

        card_telefones_text_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chamar o Fragment

            }
        });
    }
}