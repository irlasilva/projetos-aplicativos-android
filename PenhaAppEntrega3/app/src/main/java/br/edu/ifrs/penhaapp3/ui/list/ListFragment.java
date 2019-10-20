package br.edu.ifrs.penhaapp3.ui.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import br.edu.ifrs.penhaapp3.R;
import br.edu.ifrs.penhaapp3.adapter.MyAdapter;
import br.edu.ifrs.penhaapp3.listener.RecyclerItemClickListener;
import br.edu.ifrs.penhaapp3.model.Pessoa;

public class ListFragment extends Fragment {
    RecyclerView recyclerView;
    public static ListFragment newInstance() {
        return new ListFragment();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = root.findViewById(R.id.recyclerView);
        //configurar o adapter - que formata que o layout de cada item do recycler
        MyAdapter myAdapter = new MyAdapter(Pessoa.inicializaLista());
        recyclerView.setAdapter(myAdapter);
        //linha de código usada para otimizar o recycler
        recyclerView.setHasFixedSize(true);

        //configurar o gerenciador de layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        //definindo o layout do recycler
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //método para quando sofre um click rápido
                //método que recebe a linha do Recycler que sofreu o click
                Toast.makeText(getContext(), "Item pressionado com click: "+ Pessoa.inicializaLista().get(position).getNome(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onLongItemClick(View view, int position) {
                //método para quando sofre um click longo
                Toast.makeText(getContext(), "Item pressionado com click longo: "+ Pessoa.inicializaLista().get(position).getNome(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        }));
        return root;
    }

}