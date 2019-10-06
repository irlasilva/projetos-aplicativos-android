package com.example.penhaapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import com.example.penhaapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button botao = findViewById(R.id.btnBegin);
    }

     public void entrarnoAppOnclick(View v) {
        Intent intencao = new Intent(this, AcessoActivity.class);
        startActivity(intencao);
    }
}
