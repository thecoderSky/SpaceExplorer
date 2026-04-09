package com.space.explorer;

import java.io.FileInputStream;
import java.util.Properties;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class App {

    // private static final String API_KEY = "NASA-API-KEY";
    // private static final String URL = "https://api.nasa.gov/planetary/apod?api_key=" + API_KEY;

    public static void main(String[] args) throws Exception {

        Properties props = new Properties();
        props.load(new FileInputStream("config.properties"));
        String API_KEY = props.getProperty("nasa.api.key");
        String URL = "https://api.nasa.gov/planetary/apod?api_key=" + API_KEY;

        //Creating the HTTP Client, Itis the engine that will send requests to the internet. Think of it like opening a browser — you need it ready before you can visit any URL.
        OkHttpClient client = new OkHttpClient();

        //Build the Request, this tells OkHttp where to send the request. .url(URL) sets the NASA endpoint, and .build() finalizes it.
        Request request = new Request.Builder() // start building
                                     .url(URL) //  sets where to send the request
                                     .build(); // locks everything in and returns a Request object

        // Sending the Request and get a response, this actually hits the NASA API and waits for the reply. The response contains the JSON data NASA sends back.
        Response response = client.newCall(request).execute();
        // Extract the response body
        // response.body() — gets the body of the response (the actual content NASA sent). Returns a ResponseBody object.
        // .string() — converts that body into a plain Java String.
        String jsonBody = response.body().string();
        System.out.println(jsonBody);
        // Parse the JSON string
        // JsonParser.parseString(jsonBody) — Gson reads the raw JSON string and converts it into a JsonElement (a generic representation of any JSON value)
        // .getAsJsonObject() — since our JSON starts with {, we tell Gson "treat this as a JSON object", which gives us a JsonObject we can query key by key
        JsonObject data = JsonParser.parseString(jsonBody).getAsJsonObject();

        // Check if NASA returned an error BEFORE trying to print
        if (data.has("msg")) {
            System.out.println("❌ NASA API Error: " + data.get("msg").getAsString());
            return; // stop execution
        }
        
        System.out.println("🌌 Astronomy Picture of the Day");
        System.out.println("================================");
        System.out.println("Date    : " + data.get("date").getAsString());
        System.out.println("Title   : " + data.get("title").getAsString());
        System.out.println("URL     : " + data.get("url").getAsString());
        System.out.println("Info    : " + data.get("explanation").getAsString());
        // data.get("date") — fetches the value for the key "date" from the JSON. Returns a JsonElement.
        // .getAsString() — converts that JsonElement into a plain Java String.
    }    
}