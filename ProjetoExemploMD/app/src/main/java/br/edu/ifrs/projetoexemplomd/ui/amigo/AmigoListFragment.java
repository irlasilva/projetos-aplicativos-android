package br.edu.ifrs.projetoexemplomd.ui.amigo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrs.projetoexemplomd.R;
import br.edu.ifrs.projetoexemplomd.adapter.AdapterAmigos;
import br.edu.ifrs.projetoexemplomd.dao.SettingsFirebase;
import br.edu.ifrs.projetoexemplomd.listener.RecyclerItemClickListener;
import br.edu.ifrs.projetoexemplomd.model.Amigo;
import br.edu.ifrs.projetoexemplomd.model.Dica;

public class AmigoListFragment extends Fragment {
    //definição da variável que está visível no layout do fragmento
    RecyclerView recyclerView;

    public static AmigoListFragment newInstance() {
        return new AmigoListFragment();
    }

    //objeto não pode estar nulo
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //carrega o fragmento_list e associa com a variável root
        View root = inflater.inflate(R.layout.fragment_list_amigo, container, false);
        recyclerView = root.findViewById(R.id.recyclerViewAmigo);
        carregaListAmigos();
        return root;
    }

    public void configuraRecycle(List<Amigo> amigos) {
        AdapterAmigos adapterAmigos = new AdapterAmigos(Amigo.inicializaListaAmigos());
        recyclerView.setAdapter(adapterAmigos);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getContext(), "Item pressionado com click: " + Amigo.inicializaListaAmigos().get(position).getNomeAmigo(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onLongItemClick(View view, int position) {
                Toast.makeText(getContext(), "Item pressionado com click longo: " + Amigo.inicializaListaAmigos().get(position).getNomeAmigo(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        }));
    }

    public void carregaListAmigos() {
        DatabaseReference reference = SettingsFirebase.getNo("amigos");
        final ArrayList<Amigo> listAmigos;
        listAmigos = new ArrayList<>();
        //associar os eventos ao nó produtos para poder buscar os dados
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            //é chamado sempre que consegue recuperar algum dado
            //DataSnapshot é o retorno do Firebase => resultado da consulta
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    //para buscar todos os nós filhos de produtos
                    Amigo amigo = ds.getValue(Amigo.class);
                    amigo.setIdAmigo(ds.getKey());
                    listAmigos.add(amigo);
                }
                configuraRecycle(listAmigos);
            }

            @Override
            //chamado quando a requisição é cancelada
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}