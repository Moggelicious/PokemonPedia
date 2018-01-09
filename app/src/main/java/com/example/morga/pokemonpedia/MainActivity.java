package com.example.morga.pokemonpedia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.morga.pokemonpedia.models.Pokemon;
import com.example.morga.pokemonpedia.services.ApiCallerClient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Variables
    String url ="https://pokeapi.co/api/v2/Pokemon/?limit=151";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new ApiCallerClient().execute(url);
    }
}
