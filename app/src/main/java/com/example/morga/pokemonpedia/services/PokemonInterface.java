package com.example.morga.pokemonpedia.services;

import com.example.morga.pokemonpedia.models.Pokemon;

import java.util.ArrayList;

public interface PokemonInterface {
    void onClientComplete(ArrayList<Pokemon> Pokemons);
}
