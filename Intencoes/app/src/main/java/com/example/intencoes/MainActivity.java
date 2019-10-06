package com.example.intencoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.strictmode.IntentReceiverLeakedViolation;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String NOME="nome"; // criar a constante para nome
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //colocar aqui os métodos onStop, osDestroy etc


  public void onClickAbrir(View view) {


//
//      Intent intencao = new Intent(Intent.ACTION_SEND); //intenção implícita - enviar um e-mail (buscar informações em outro site)
//      intencao.setType("text/plan");
//      intencao.putExtra(Intent.EXTRA_TEXT, "Meu nome é irla");
//      startActivity(intencao);


        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://poa.ifrs.edu.br")); //intenção implícita - abrir navegador - buscar informações em outro site)
        startActivity(intent);

      //para abrir num campo de pequisa - Intent.ACTION_WEB_SEARCH
      //para abrir um mapa - Intent.ACTION_VIEW (ver documentação


  }
}
