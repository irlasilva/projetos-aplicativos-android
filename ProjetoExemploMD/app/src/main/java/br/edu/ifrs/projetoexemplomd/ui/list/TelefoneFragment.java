package br.edu.ifrs.projetoexemplomd.ui.list;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import br.edu.ifrs.projetoexemplomd.R;
import br.edu.ifrs.projetoexemplomd.adapter.AdapterTelefonesEmergencia;
import br.edu.ifrs.projetoexemplomd.adapter.MyAdapter;
import br.edu.ifrs.projetoexemplomd.listener.RecyclerItemClickListener;
import br.edu.ifrs.projetoexemplomd.model.Pessoa;
import br.edu.ifrs.projetoexemplomd.model.Telefone;

// implements BottomNavigationView.OnNavigationItemSelectedListener()

public class TelefoneFragment extends Fragment {
    //definição da variável que está visível no layout do fragmento
    RecyclerView recyclerView;
    public static TelefoneFragment newInstance() {
        return new TelefoneFragment();
    }
    //objeto não pode estar nulo
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //carrega o fragmento_list e associa com a variável root
        View root = inflater.inflate(R.layout.fragment_list_telefone, container, false);
        recyclerView = root.findViewById(R.id.recyclerViewTelefone);
        //configurar o adapter - que formata que o layout de cada item do recycler
        AdapterTelefonesEmergencia adapterTelefonesEmergencia = new AdapterTelefonesEmergencia(Telefone.inicializaLista());
        //o recycler vai mostrar esses dados (myAdapter)
        recyclerView.setAdapter(adapterTelefonesEmergencia);
        //linha de código usada para otimizar o recycler
        recyclerView.setHasFixedSize(true);

        //configurar o gerenciador de layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        //StaggeredGridLayoutManager layoutManager2 = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL); //vertical - se adapta ao conteúdo
        //GridLayoutManager layoutManager3 = new GridLayoutManager(getContext(), 2);

        //adiciona um separador entre os itens da lista carregados na tela
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        //definindo o layout do rFecycler
        //para os itens ficarem de acordo com o layout escolhido
        recyclerView.setLayoutManager(layoutManager);
        Log.i("É AQUI MEMO", "teste");

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //método para quando sofre um click rápido
                //método que recebe a linha do Recycler que sofreu o click
                Toast.makeText(getContext(), "Item pressionado com click: "+ Telefone.inicializaLista().get(position).getNomeLocalTelefone(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onLongItemClick(View view, int position) {
                //método para quando sofre um click longo
                Toast.makeText(getContext(), "Item pressionado com click longo: "+ Telefone.inicializaLista().get(position).getNomeLocalTelefone(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        }));
        return root;
    }
}