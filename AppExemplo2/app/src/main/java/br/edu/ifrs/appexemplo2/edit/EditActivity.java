package br.edu.ifrs.appexemplo2.edit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.edu.ifrs.appexemplo2.MainActivity;
import br.edu.ifrs.appexemplo2.R;
import br.edu.ifrs.appexemplo2.dao.ConfiguraFirebase;
import br.edu.ifrs.appexemplo2.model.Produto;

public class EditActivity extends AppCompatActivity  implements Button.OnClickListener{
   Button button;
   String chave;
   TextInputEditText nome;
   TextInputEditText descricao;
   TextInputEditText valorUnitario;
   View root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        Intent intent = getIntent();
        nome = findViewById(R.id.txtNome);
        nome.setText(intent.getStringExtra("nome"));
        descricao = findViewById(R.id.txtDesc);
        descricao.setText(intent.getStringExtra("descricao"));
        valorUnitario = findViewById(R.id.txtValorUnitario);
        valorUnitario.setText(intent.getStringExtra("valor"));
        chave = intent.getStringExtra("chave");
        button = findViewById(R.id.btnEditProd);
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("produtos").child(chave);
            Produto p = new Produto(nome.getText().toString(), descricao.getText().toString(), Double.parseDouble(valorUnitario.getText().toString()) );
            reference.setValue(p);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
   }

}
