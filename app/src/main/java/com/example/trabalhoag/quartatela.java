package com.example.trabalhoag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

public class quartatela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quartatela);
        getSupportActionBar().hide();

    }

    public void onClick (View v){
        Intent bacana = new Intent(quartatela.this, terceiratela.class);
        startActivity(bacana);
    }

        TextView log;
        TextView lat;
        TextView bairro;
        TextView est;
        TextView pais;

        private Location lugar;
        private LocationManager gps;

        private Address ender;

        public void busca (View v){
            lat = findViewById(R.id.lat);
            log = findViewById(R.id.lon);
            bairro = findViewById(R.id.bairro);
            est = findViewById(R.id.est);
            pais = findViewById(R.id.pais);

            double lati = 0.0;
            double logi = 0.0;

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){

            } else{
                gps = (LocationManager)
                        getSystemService(Context.LOCATION_SERVICE);
                lugar = gps.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            }
            if(lugar != null){

                lati = lugar.getLatitude();
                logi = lugar.getLongitude();
            }
            mostrarGoogleMaps(lati, logi);
            log.setText("Longitude: " + logi);
            lat.setText("Latitude: " + lati);

            try {
                ender = buscarEndereco(lati, logi);

                bairro.setText("Bairro: " +ender.getSubLocality());
                est.setText("Estado: " +ender.getAdminArea());
                pais.setText("País: " +ender.getCountryName());

            } catch (IOException e) {

                Log.i("GPS", e.getMessage());
            }
        }

        public Address buscarEndereco(double lat, double log)
                throws IOException {

            Geocoder geocoder;
            Address address = null;
            List<Address> addresses;

            geocoder = new Geocoder(getApplicationContext());

            addresses = geocoder.getFromLocation(lat, log,1);
            if (addresses.size() > 0){
                address = addresses.get(0);

            }
            return address;

        }
    public void mostrarGoogleMaps(double lati, double logi) {
        WebView wv = findViewById(R.id.bacana);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("https://www.google.com/maps/search/?api=1&query=" + lati + "," + logi);
    }
    public void Recuperar(View v){
            String Latitude,log,bairro,est,pais;
        SharedPreferences prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        Latitude = prefs.getString("Latitude","Não Encontrado");
        log = prefs.getString("Longitude","Não Encontrado");
        bairro = prefs.getString("Bairro","Não Encontrado");
        est = prefs.getString("Estado","Não Encontrado");
        pais = prefs.getString("Pais","Não Encontrado");
        lat.setText(Latitude);
    }

    public void Gravar(View v){
        SharedPreferences prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = prefs.edit();
        ed.putString("Latitude", lat.getText().toString());
        ed.putString("Longitude", log.getText().toString());
        ed.putString("Bairro", bairro.getText().toString());
        ed.putString("Estado", est.getText().toString());
        ed.putString("Pais", pais.getText().toString());
        ed.commit();
        Toast.makeText(getBaseContext(),"Gravado com Sucesso",Toast.LENGTH_SHORT).show();
    }
    }
