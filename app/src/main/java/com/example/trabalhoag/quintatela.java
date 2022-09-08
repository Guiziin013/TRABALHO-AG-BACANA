package com.example.trabalhoag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class quintatela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quintatela);
        getSupportActionBar().hide();

    }

    public void quiz1(View v){
        Intent bacana = new Intent(quintatela.this, quartatela.class);
        startActivity(bacana);
    }

    public void quizresposta (View v){
        Intent bacana = new Intent(quintatela.this, segundatela.class);
        startActivity(bacana);
    }

    public void respostacerta (View v){
        Intent bacana = new Intent(quintatela.this, sextatela.class);
        startActivity(bacana);
    }
}