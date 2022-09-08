package com.example.trabalhoag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class setimatela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setimatela);
        getSupportActionBar().hide();

    }

    public void creditosinicio(View v){
        Intent bacana = new Intent(setimatela.this, MainActivity.class);
        startActivity(bacana);
    }

    public void instagui(View view){
        String url = "https://www.instagram.com/gui_0810x/";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void instaart(View view){
        String url = "https://www.instagram.com/art_dias_/";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

}