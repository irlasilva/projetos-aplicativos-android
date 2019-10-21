package com.irla.meuprimeirofirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        /*Auth.createUserWithEmailAndPassword("teste123@gmail.com", "123456")
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("LOGIN", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Log.d("ERRO", currentUser.getEmail()); //imprime o e-mail do usuário
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("LOGIN ", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            Log.d("LOGIN", "createUserWithEmail:success");
                        }

                        // ...
                    }
                }); */
//para validar usuários já existentes
        mAuth.signInWithEmailAndPassword("teste@gmail.com", "123456")
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("LOGIN", "signInWithEmail:success");
                            currentUser = mAuth.getCurrentUser(); //alterei aqui após copiar código ao lado - Firebase (aba)
                            Log.d("LOGIN", currentUser.getEmail());
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("LOGIN ERRO", "signInWithEmail:failure", task.getException());
                        }

                        // ...
                    }
                });
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        currentUser = mAuth.getCurrentUser();
        //para atualizar interface - não necessário agora
        //updateUI(currentUser);

        //operador ternário ???
        if currentUser != null ? (Log.d("LOGIN entrou no sistema", currentUser.getEmail())):
                Log.d("ERRO", currentUser.getEmail()));

    }


}
