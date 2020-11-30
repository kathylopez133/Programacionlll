package com.example.programacionlll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }
    public void regresar (View view){
        Intent regresar = new Intent(registro.this,MainActivity.class);
        startActivity(regresar);
        finish();
    }
    public void principal(View view){
        Intent principal = new Intent(registro.this,MainActivity2.class);
        startActivity(principal);
        finish();

    }
}