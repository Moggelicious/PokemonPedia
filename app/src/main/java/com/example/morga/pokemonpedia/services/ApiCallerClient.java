package com.example.morga.pokemonpedia.services;

import android.os.AsyncTask;
import android.util.Log;

public class ApiCallerClient extends AsyncTask<String, Void, String> {

    //Variables
    private String server_Response;


    //create api call and call api
    @Override
    protected String doInBackground(String... strings) {
        //TODO Call api here

        return null;
    }

    //After apiCall
    @Override
    protected void onPostExecute(String resultString){
        super.onPostExecute(resultString);
        Log.wtf("Response", "response is: " + server_Response);
    }

}
