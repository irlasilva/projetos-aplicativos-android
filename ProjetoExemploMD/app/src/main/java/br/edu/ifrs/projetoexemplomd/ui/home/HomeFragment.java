package br.edu.ifrs.projetoexemplomd.ui.home;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import br.edu.ifrs.projetoexemplomd.R;
import br.edu.ifrs.projetoexemplomd.model.Telefone;
import br.edu.ifrs.projetoexemplomd.ui.activities.InfoActivity;
import br.edu.ifrs.projetoexemplomd.ui.list.CategoriaListFragment;

import static androidx.databinding.DataBindingUtil.inflate;

public class HomeFragment extends Fragment { //está dizendo eu sou um fragmento

    private HomeViewModel homeViewModel;
    private TextView mapaTextView;
    private TextView quizTextView;
    private TextView dicasTextView;
    private TextView telefonesEmergenciaTextView;

    //método que caracteriza o fragmento onCreateView
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflate(inflater, R.layout.fragment_home, container, false).getRoot();

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
        mapaTextView = view.findViewById(R.id.mapa_text_view);
        quizTextView = view.findViewById(R.id.quiz_text_view);
        dicasTextView = view.findViewById(R.id.dicas_text_view);
        telefonesEmergenciaTextView = view.findViewById(R.id.telefones_text_view);

    }

    private void setClick(){
        mapaTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ListActivity.class));
            }
        });

        quizTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chamar qualquer metodo que sera executado
                startActivity(new Intent(getActivity(), InfoActivity.class));
            }
        });

        dicasTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chamar qualquer metodo que sera executado
                startActivity(new Intent(getActivity(), InfoActivity.class));
            }
        });

        telefonesEmergenciaTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chamar qualquer metodo que sera executado
                startActivity(new Intent(getActivity(), Telefone.class));
            }
        });
    }


}