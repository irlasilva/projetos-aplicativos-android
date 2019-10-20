package br.edu.ifrs.penhaapp3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.penhaapp.R;

public class AcessoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acesso);
        ListView listaMenu = this.findViewById(R.id.menu);
        String[] itens = {"Login", "Cadastrar", "Acessar sem Cadastro", "Listar Todos", };
        ArrayAdapter<String> arrayItens = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,itens);
        listaMenu.setAdapter(arrayItens);
        listaMenu.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> listView, View v, int position, long id){
        if(position == 0) {//login
            Intent intencao = new Intent(this, LoginActivity.class);
            startActivity(intencao);
        }
        else if (position == 1){//cadastro
            Intent intencao = new Intent(this, CadastraOcorrenciaActivity.class);
            startActivity(intencao);
        }
        else if (position == 2){//listar todos
            Intent intencao = new Intent(this, ListaOcorrenciasActivity.class);
            startActivity(intencao);
        }
        else if (position == 3){//acesso sem cadastro
            Intent intencao = new Intent(this, LoginActivity.class);
            startActivity(intencao);
        }
    }
}