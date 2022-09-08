package com.example.trabalhoag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

    }

    public void onClick(View v){
        Intent bacana = new Intent(MainActivity.this, segundatela.class);
        startActivity(bacana);
    }

    public void creditos(View v){
        Intent bacana = new Intent(MainActivity.this, setimatela.class);
        startActivity(bacana);
    }
}