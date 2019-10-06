package com.example.applistas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListaIfsActivity extends ListActivity { //extends lista diz que "eu sou uma lista"

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_lista_ifs);
        //cria um objeto para acessar a lista que está no layout
        ListView lista = getListView();
        //busca as Ufs que estão declaradas na variavel Ufs - arquivo String
        //String ufs[] = getResources().getStringArray(R.array.Ufs);
        //definir o adapter
        //o adaptador vai usar a classe estado para mostrar os estados na lista. Ele vai exibir no formato definido pelo toString da classe Estado
        ArrayAdapter<Estado> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,Estado.estados);
        lista.setAdapter(listAdapter);
        lista.addHeaderView(montaCabecalho(this));
        lista.addFooterView(montaRodape(this));

    }
    //definir métodos que irá tratar os eventos dessa lista
    public void onListItemClick(ListView lista, View view, int position, long id) {
        //converte para string o item selecionado
        String itemLista = lista.getItemAtPosition(position).toString();
        //mostra uma mensagem com o nome do estado que foi selecionado
        //Toast.makeText(getApplicationContext(), "O item selecionado foi: " + itemLista, Toast.LENGTH_LONG).show();

        //FAZER: abrir uma intenção passando como parâmetro o estado que foi selecionado e mostrar o mapa da sua localidade
        //coloquei aqui uma intent e lá no manifesto na atividade correta coloquei um filtro
            Intent ObjectIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0? q=-30.0264276,-51.2233058(IFRS POA)?z=15"));
            if (ObjectIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(ObjectIntent);
            }
    }

    //FAZER como contar os itens da lista sem o cabeçalho e o rodapé? havia 4 itens na  minha lista e foram contados somente 3

    //O cabeçalho é configurado com o método montaCabecalho()
    private static TextView montaCabecalho(ListActivity lista){
        TextView cabecalho = new TextView(lista);
        cabecalho.setBackgroundColor(Color.BLACK);
        cabecalho.setTextColor(Color.WHITE);
        cabecalho.setText("Lista de Estados");
        int padding = (int)
                lista.getResources().getDimension(R.dimen.meuPadding);
        cabecalho.setPadding(padding, padding, 0, padding);
        //cabecalho.setPadding(8, 8, 0, 8);
        return cabecalho;
    }

    private static TextView montaRodape(ListActivity lista){
        TextView rodape = new TextView(lista);
        rodape.setBackgroundColor(Color.LTGRAY);
        rodape.setTextColor(Color.BLACK);
        rodape.setGravity(Gravity.END);

        rodape.setText(lista.getResources().getQuantityString(R.plurals.textoRodape,
                3,3));
        int padding = (int) lista.getResources().getDimension(R.dimen.meuPadding);
        rodape.setPadding(padding, padding, 0, padding);
        //rodape.setPadding(8, 8, 0, 8);
        return rodape;
    }

}
