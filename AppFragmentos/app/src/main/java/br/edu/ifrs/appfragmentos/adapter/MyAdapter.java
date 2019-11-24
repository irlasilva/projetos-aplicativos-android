package br.edu.ifrs.appfragmentos.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrs.appfragmentos.R;
import br.edu.ifrs.appfragmentos.model.Pessoa;
import br.edu.ifrs.appfragmentos.ui.add.AddFragment;
import br.edu.ifrs.appfragmentos.ui.list.ListFragment;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    List<Pessoa> listaPessoas = new ArrayList<>();
    ListFragment.FragmentListener listener;

    public MyAdapter(Context context , ListFragment.FragmentListener listener, List<Pessoa> pessoas) {
        this.context = context;
        this.listaPessoas = pessoas;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //chamado para criar as visualizações - somente as primeiras que aparecem para o usuário
        //convertendo o XML em uma visualização
        //cria um objeto do tipo view
        View itemList = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_card, viewGroup, false);
        //retorna o itemList que é passado para o construtor da MyViewHolder

        return new MyViewHolder(itemList);

    }

    @Override
    public void onBindViewHolder(@NonNull final MyAdapter.MyViewHolder myViewHolder, final int i) {
        //exibe os itens no Recycler
        Pessoa p = listaPessoas.get(i);
        myViewHolder.nome.setText(p.getNome());
        myViewHolder.endereco.setText(p.getEndereco());
        myViewHolder.btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               listener.itemClicked(2, i);//origem 2 informa que é o editar - 1 é listar
            }
        });
        myViewHolder.btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaPessoas.remove(i);
                notifyItemRemoved(i);
                notifyItemRangeChanged(i, listaPessoas.size());
                Toast.makeText(context, "Removido com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        //retorna a quantidade de itens que será exibida
        return listaPessoas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        //dados da pessoa que serão exibidos no recycler
        TextView nome;
        TextView endereco;
        Button btnEditar;
        Button btnExcluir;
        Context context;

        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            //passa uma referência para os componentes que estão na interface
            nome = itemView.findViewById(R.id.textViewNome);
            endereco = itemView.findViewById(R.id.textViewEndereco);
            btnEditar = itemView.findViewById(R.id.btnEditar);
            btnExcluir = itemView.findViewById(R.id.btnExcluir);

        }
    }
}
