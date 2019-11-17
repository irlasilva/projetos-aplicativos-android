package br.edu.ifrs.projetoexemplomd.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrs.projetoexemplomd.R;
import br.edu.ifrs.projetoexemplomd.model.Pessoa;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> { //dentro de uma classe ha uma outra classe MyAdapter.MyViewHolder
    List<Pessoa> listaPessoas = new ArrayList<>(); //inicializar a lista

    public MyAdapter(List<Pessoa> pessoas) {
        this.listaPessoas = pessoas;
    } //garantir que a lista será criada fica dentro do contrutor

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //chamado para criar as visualizações - somente as primeiras que aparecem para o usuário
        //convertendo o XML em uma visualização
        //cria um objeto do tipo view
        View itemList = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_card, viewGroup, false); //troquei o adapter_card (era os cards)
        //se colocar adapter_list_dica usa a lista com separador ou sem separador
        //o separador fica na classe CategoriaListFragment
        //retorna o itemList que é passado para o construtor da MyViewHolder
        return new MyViewHolder(itemList);//processa enquanto houverem dados na lista de pessoas até o fim
    }

    @Override
    //método que ??? ouvir audio em 30'
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder myViewHolder, int i) {
        //exibe os itens no Recycler
        Pessoa p = listaPessoas.get(i);
        myViewHolder.nome.setText(p.getNome());
        myViewHolder.dataNascimento.setText(p.getDataNascimento());
        myViewHolder.endereco.setText(p.getEndereco());
    }

    @Override
    //quantos itens irá mostrar na tela - semelhante ao Ajax, feed de notícias
    public int getItemCount() {
        //retorna a quantidade de itens que será exibida
        return listaPessoas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{ //classe interna do adaptador
        //dados da pessoa que serão exibidos no recycler
        TextView nome;
        TextView dataNascimento;
        TextView endereco;

        public MyViewHolder(View itemView){
            super(itemView);
            //passa uma referência para os componentes que estão na interface
            nome = itemView.findViewById(R.id.textViewNome);
            dataNascimento = itemView.findViewById(R.id.textViewDtNasc);
            endereco = itemView.findViewById(R.id.textViewEndereco);
        }
    }
}
