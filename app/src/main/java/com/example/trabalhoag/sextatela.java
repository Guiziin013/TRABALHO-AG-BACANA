package com.example.trabalhoag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class sextatela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sextatela);
        getSupportActionBar().hide();

    }

    public void inicioquiz2 (View v){
        Intent bacana = new Intent(sextatela.this, segundatela.class);
        startActivity(bacana);
    }

    public void quizcreditos (View v){
        Intent bacana = new Intent(sextatela.this, setimatela.class);
        startActivity(bacana);
    }

    public void menuquiz2 (View v){
        Intent bacana = new Intent(sextatela.this, MainActivity.class);
        startActivity(bacana);
    }
}