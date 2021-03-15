package com.example.joker;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Joker {
    String type;
    String setup;
    String punchline;

    public Joker(JSONObject jsonObject) throws JSONException{
        type = jsonObject.getString("type");
        setup = jsonObject.getString("setup");
        punchline = jsonObject.getString("punchline");
    }

    public static List<Joker> fromJsonArray(JSONArray jokesJsonArray) throws JSONException{

        List<Joker> jokes = new ArrayList<>();// check this for errors

        for(int i = 0; i< jokesJsonArray.length(); i++){
            jokes.add(new Joker(jokesJsonArray.getJSONObject(i)));

        }
        return jokes;
    }

    public String getType() {
        return type;
    }

    public String getSetup() {
        return setup;
    }

    public String getPunchline() {
        return punchline;
    }

}
