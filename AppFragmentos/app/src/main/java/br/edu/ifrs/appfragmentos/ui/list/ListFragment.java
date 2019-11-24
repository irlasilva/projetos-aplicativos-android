package br.edu.ifrs.appfragmentos.ui.list;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import br.edu.ifrs.appfragmentos.R;
import br.edu.ifrs.appfragmentos.adapter.MyAdapter;
import br.edu.ifrs.appfragmentos.model.Pessoa;
import br.edu.ifrs.appfragmentos.ui.add.AddFragment;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.List;


public class ListFragment extends Fragment implements View.OnClickListener{

    RecyclerView recyclerView;
    private  List<Pessoa> lista;

    public List<Pessoa> getLista() {
        return lista;
    }

    public void setLista(List<Pessoa> lista) {
        this.lista = lista;
    }
    public static ListFragment newInstance() {
        return new ListFragment();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = root.findViewById(R.id.recyclerView);
        MyAdapter myAdapter = new MyAdapter(root.getContext(), listener, lista);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setHasFixedSize(true);

          RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        GridLayoutManager layoutManager3 = new GridLayoutManager(getContext(), 2);
        StaggeredGridLayoutManager layoutManager2 =
                new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager2);

        return root;
    }
    @Override
    public void onClick(View v) {  }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (ListFragment.FragmentListener) context;
    }
    public static interface FragmentListener {
        void itemClicked(int idOrigem, int posicao);
    }

    private FragmentListener listener;

}