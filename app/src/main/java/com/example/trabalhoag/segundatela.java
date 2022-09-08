package com.example.trabalhoag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class segundatela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundatela);
        getSupportActionBar().hide();

    }

    public void onClick(View v){
        Intent bacana = new Intent(segundatela.this, quartatela.class);
        startActivity(bacana);
    }

    public void bussola(View v){
        Intent bacana = new Intent(segundatela.this, terceiratela.class);
        startActivity(bacana);
    }

    public void inicio (View v){
        Intent bacana = new Intent(segundatela.this, MainActivity.class);
        startActivity(bacana);
    }

    public void pergunta (View v){
        Intent bacana = new Intent(segundatela.this, quintatela.class);
        startActivity(bacana);
    }
}