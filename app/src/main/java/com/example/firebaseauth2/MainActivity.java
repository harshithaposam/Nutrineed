package com.example.firebaseauth2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.firebaseauth2.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firebaseAuth=firebaseAuth.getInstance();
        firebaseFirestore=firebaseFirestore.getInstance();

        progressDialog=new ProgressDialog(this);

        binding.signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=binding.fullName.getText().toString();

                String number=binding.mobileNumber.getText().toString();
                String email=binding.emailAddress.getText().toString();
                String password=binding.textPassword.getText().toString();

                progressDialog.show();

firebaseAuth.createUserWithEmailAndPassword(email,password)
        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
               startActivity(new Intent(MainActivity.this,LoginActivity.class));

                progressDialog.cancel();

                firebaseFirestore.collection("User")
                        .document(FirebaseAuth.getInstance().getUid())
                        .set(new UserModel(name,number,email));
            }
        })

        .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.cancel();
            }
        });
            }
        });
        binding.goToLogInActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,LoginActivity.class));

            }
        });
    }
}