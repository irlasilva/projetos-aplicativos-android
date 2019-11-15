package br.edu.ifrs.projetoexemplomd.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrs.projetoexemplomd.R;
import br.edu.ifrs.projetoexemplomd.model.Telefone;

public class AdapterTelefonesEmergencia extends RecyclerView.Adapter<AdapterTelefonesEmergencia.MyViewHolder> {

    List<Telefone> listaTelefones = new ArrayList<>(); //inicializar a lista

    //garantir que a lista será criada fica dentro do contrutor
    public AdapterTelefonesEmergencia(List<Telefone> telefones) {
        this.listaTelefones = telefones;
        Log.d("teste", telefones.toString());
    }

    @NonNull
    @Override
    public AdapterTelefonesEmergencia.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //chamado para criar as visualizações - somente as primeiras que aparecem para o usuário
        //convertendo o XML em uma visualização
        //cria um objeto do tipo view
        View itemList = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_list_telefone, viewGroup, false);
        //se colocar adapter_list usa a lista com separador ou sem separador
        //o separador fica na classe CategoriaListFragment
        //retorna o itemList que é passado para o construtor da MyViewHolder
        return new MyViewHolder(itemList);//processa enquanto houverem dados na lista até o fim
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterTelefonesEmergencia.MyViewHolder myViewHolder, int i) {
        //exibe os itens no Recycler
        Telefone t = listaTelefones.get(i);
        Log.d("teste lista telefone",listaTelefones.toString());
        Log.d("teste t", t.toString());
        myViewHolder.nomeLocalTelefone.setText(t.getNomeLocalTelefone());
        myViewHolder.endereco.setText(t.getEndereco());
        myViewHolder.numeroTelefone.setText(String.valueOf(t.getNumeroTelefone()));
    }

    @Override
    //quantos itens irá mostrar na tela - semelhante ao Ajax, feed de notícias
    public int getItemCount() {
        //retorna a quantidade de itens que será exibida
        return listaTelefones.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{ //classe interna do adaptador
        //telefone que serão exibidos no recycler
        TextView nomeLocalTelefone;
        TextView endereco;
        TextView numeroTelefone;

        public MyViewHolder(View itemView){
            super(itemView);
            //passa uma referência para os componentes que estão na interface
            nomeLocalTelefone = itemView.findViewById(R.id.nomeLocalTelefone);
            endereco = itemView.findViewById(R.id.endereco);
            numeroTelefone = itemView.findViewById(R.id.numeroTelefone);
        }
    }
}
