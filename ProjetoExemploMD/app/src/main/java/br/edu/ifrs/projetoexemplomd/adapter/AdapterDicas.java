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
import br.edu.ifrs.projetoexemplomd.model.Dica;
import br.edu.ifrs.projetoexemplomd.model.Pessoa;

public class AdapterDicas extends RecyclerView.Adapter<AdapterDicas.DicaViewHolder> {
    List<Dica> listaDicas = new ArrayList<>();

    public AdapterDicas(List<Dica> dicas) {
        this.listaDicas = dicas;
    }

    @NonNull
    @Override
    public AdapterDicas.DicaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //chamado para criar as visualizações - somente as primeiras que aparecem para o usuário
        //convertendo o XML em uma visualização
        //cria um objeto do tipo view
        View itemList = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_card, viewGroup, false); //troquei o adapter_card (era os cards)
        //se colocar adapter_list usa a lista com separador ou sem separador
        //o separador fica na classe CategoriaListFragment
        //retorna o itemList que é passado para o construtor da MyViewHolder
        return new DicaViewHolder(itemList);//processa enquanto houverem dados na lista de pessoas até o fim
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDicas.DicaViewHolder dicaViewHolder, int i) {
        //exibe os itens no Recycler
        Dica d = listaDicas.get(i);
        dicaViewHolder.assunto.setText(d.getAssuntoDica());
        dicaViewHolder.descricao.setText(d.getDescricaoDica());
    }

    @Override
    //quantos itens irá mostrar na tela - semelhante ao Ajax, feed de notícias
    public int getItemCount() {
        //retorna a quantidade de itens que será exibida
        return listaDicas.size();
    }

    public class DicaViewHolder extends RecyclerView.ViewHolder{ //classe interna do adaptador
        //dados da pessoa que serão exibidos no recycler
        TextView assunto;
        TextView descricao;

        public DicaViewHolder(View itemView){
            super(itemView);
            //passa uma referência para os componentes que estão na interface
            assunto = itemView.findViewById(R.id.txt_item_card_assunto_dica);
            descricao = itemView.findViewById(R.id.txt_item_card_descricao_dica);
        }
    }
}

