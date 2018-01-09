package com.example.morga.pokemonpedia.services;

import android.util.Log;

import com.example.morga.pokemonpedia.models.Pokemon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JSONHandler {

    private JSONObject json;
    private PokemonInterface pokemonInterface;
    private ArrayList<Pokemon> pokemonList;
    private Pokemon pokemon;

    public JSONHandler(PokemonInterface context, JSONObject json){
        this.json = json;
        this.pokemonInterface = context;
    }

    public void parsePokemon(){

        if(json != null){
            pokemonList = new ArrayList<>();
            try{
                JSONArray jArray = json.getJSONArray("ResponseData");
                for (int i = 0; i < jArray.length(); i++){
                    pokemon = new Pokemon();
                    pokemon.setName(jArray.getJSONObject(i).getString("name"));
                    pokemonList.add(pokemon);
                    Log.d("Pokemon", "name: " + pokemon.getName());
                }
                pokemonInterface.onClientComplete(pokemonList);
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
    }
}
