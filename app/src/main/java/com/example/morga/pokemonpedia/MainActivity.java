package com.example.morga.pokemonpedia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.morga.pokemonpedia.services.ApiCallerClient;

public class MainActivity extends AppCompatActivity {

    //Variables
    String url ="https://pokeapi.co/api/v2/pokemon/?limit=151";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new ApiCallerClient().execute(url);
    }
}
