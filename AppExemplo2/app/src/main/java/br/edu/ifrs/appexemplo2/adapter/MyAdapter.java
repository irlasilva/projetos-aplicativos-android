package br.edu.ifrs.appexemplo2.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrs.appexemplo2.R;
import br.edu.ifrs.appexemplo2.dao.ConfiguraFirebase;
import br.edu.ifrs.appexemplo2.edit.EditActivity;
import br.edu.ifrs.appexemplo2.model.Produto;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<Produto> listaProdutos = new ArrayList<>();
    Context context;
    public MyAdapter(List<Produto> listaProdutos, Context context) {
        this.listaProdutos = listaProdutos;
        this.context = context;
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
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder myViewHolder, final int i) {
        //exibe os itens no Recycler
        final Produto p = listaProdutos.get(i);
        myViewHolder.nome.setText(p.getNome());
        myViewHolder.descricao.setText(p.getDescricao());
        myViewHolder.valor.setText(String.valueOf(p.getValorUnitario()));
        myViewHolder.editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("chave", p.getId());
                intent.putExtra("nome", p.getNome());
                intent.putExtra("descricao", p.getDescricao());
                intent.putExtra("valor", String.valueOf(p.getValorUnitario()));
                context.getApplicationContext().startActivity(intent);
            }
        });
        myViewHolder.excluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removerItem(i);
            }
        });
    }
    public void removerItem(final int position) { //colocar final pois nao pode alterar o objeto internamente
        new AlertDialog.Builder(context)
                .setTitle("Deletando produto")
                .setMessage("Tem certeza que deseja deletar esse produto?")//janela para ter certeza da delecao
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        final DatabaseReference reference = ConfiguraFirebase.getNo("produtos");
                        reference.child(listaProdutos.get(position).getId()).removeValue();
                        listaProdutos.remove(position);
                        notifyItemRemoved(position);

                    }}).setNegativeButton("Não", null).show();
     }

    @Override
    public int getItemCount() {
        //retorna a quantidade de itens que será exibida
        return listaProdutos != null ? listaProdutos.size() : 0;
}

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nome;
        TextView descricao;
        TextView valor;
        Button editar;
        Button excluir;

        public MyViewHolder(View itemView){
            super(itemView);
            //passa uma referência para os componentes que estão na interface
            nome = itemView.findViewById(R.id.txtNomeList);
            descricao = itemView.findViewById(R.id.txtDescList);
            valor = itemView.findViewById(R.id.txtValorList);
            editar = itemView.findViewById(R.id.btnEditProd);
            excluir = itemView.findViewById(R.id.btnDelProd);
        }
    }
}
