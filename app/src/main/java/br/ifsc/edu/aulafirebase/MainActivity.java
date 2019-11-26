package br.ifsc.edu.aulafirebase;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;

import br.ifsc.edu.aulafirebase.R;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth=FirebaseAuth.getInstance();
        mAuth.signOut();

        mAuth.signInWithEmailAndPassword("maraschidiogo@gmail.com","123456789").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),mAuth.getCurrentUser().getEmail(),Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Falha no login",Toast.LENGTH_LONG).show();
                }
            }
        });

        FirebaseUser fUser = mAuth.getCurrentUser();

        if (fUser != null){
            Log.d("tag","UsuarioLogado " + fUser.getEmail());
        }else {
            Log.d("tag","Falha");
        }
    }
}
