package com.example.morga.pokemonpedia.services;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiCallerClient extends AsyncTask<String, Void, JSONObject> {

    //Variables

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //checks to do before calling api
    }

    //create api call and call api
    @Override
    protected JSONObject doInBackground(String... strings) {
        //Function Variables
        String server_response;
        URL url;
        HttpURLConnection urlConnection = null;

        try {
            url = new URL(strings[0]);//set input call parameter to url
            urlConnection = (HttpURLConnection) url.openConnection();

            int responseCode = urlConnection.getResponseCode();
            Log.d("hello", "doInBackground: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK){
                Log.d("hello", "doInBackground: connection acquired");
                server_response = readStream(urlConnection.getInputStream());
                return new JSONObject(server_response);
            }else{

                urlConnection.disconnect();//disconnect from api
            }
        } catch (JSONException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return null;
    }

    //After apiCall
    @Override
    protected void onPostExecute(JSONObject result){
        super.onPostExecute(result);
        //Do something with result
        Log.wtf("Response", "response is: " + result);
    }

    //Read Stream from api
    private String readStream(InputStream in){
        BufferedReader reader = null;
        StringBuffer response = new StringBuffer();
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null){
                response.append(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        } finally {
            if (reader != null){
                try {
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return response.toString();
    }

}
