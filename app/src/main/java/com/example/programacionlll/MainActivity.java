package com.example.programacionlll;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends Activity {

    private EditText mEditTextName;
    private EditText mEditTextEmail;
    private EditText mEditTextPassword;
    private Button mButtonRegister;

    //variables de los datos que se van a registrar
    private String name = "";
    private String email = "";
    private String password = "";

    FirebaseAuth mAuth;
    DatabaseReference mDataBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        mDataBase = FirebaseDatabase.getInstance().getReference();

        mEditTextName = (EditText) findViewById(R.id.editTextName);
        mEditTextEmail = (EditText) findViewById(R.id.editTextEmail);
        mEditTextPassword = (EditText) findViewById(R.id.editTextPassword);
        mButtonRegister = (Button) findViewById(R.id.btnregister);

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = mEditTextName.getText().toString();
                email = mEditTextEmail.getText().toString();
                password = mEditTextPassword.getText().toString();

                if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {

                    if (password.length() >= 6){
                        startActivity(new Intent(MainActivity.this, MainActivity2.class));
                        registerUser();

                    }
                    else{
                        Toast.makeText(MainActivity.this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
                    }

                }
                else {
                    Toast.makeText(MainActivity.this, "Debe completar los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void registerUser(){
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
               if (task.isSuccessful()) {

                   Map<String, Object> map = new HashMap<>();
                   map.put("name", name);
                   map.put( "email", email);
                   map.put( "password", password);

                   String id = mAuth.getCurrentUser().getUid();

                   mDataBase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                       @Override
                       public void onComplete(@NonNull Task<Void> task2) {
                           if (task2.isSuccessful()){
                               startActivity(new Intent(MainActivity.this,MainActivity2.class));
                               finish();


                           }
                           else {
                               Toast.makeText(MainActivity.this, "REGISTRADO CON EXITO", Toast.LENGTH_SHORT).show();
                           }
                       }
                   });
               }
               else {
                   Toast.makeText(MainActivity.this, "No se pudieron crear los datos correctamente", Toast.LENGTH_SHORT).show();
               }
            }
        });

    }






}