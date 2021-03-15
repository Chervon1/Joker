package com.example.joker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;

public class MainActivity extends AppCompatActivity {

    public static final String JOKER_URL = "https://raw.githubusercontent.com/15Dkatz/official_joke_api/master/jokes/index.json";
    public static final String TAG = "MainActivity";

    List<Joker> jokes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvJokes = findViewById(R.id.rvJokes);
        jokes = new ArrayList<>();

        JokerAdapter jokerAdapter = new JokerAdapter(this, jokes);
        rvJokes.setAdapter(jokerAdapter);

        rvJokes.setLayoutManager(new LinearLayoutManager(this));

        AsyncHttpClient client = new AsyncHttpClient();

        client.get(JOKER_URL, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Headers headers, JSON json) {
                Log.d(TAG, "onSuccess");
                Log.d(TAG, json.jsonArray.toString());
                try{
                    jokes.addAll(Joker.fromJsonArray(json.jsonArray));
                    jokerAdapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int i, Headers headers, String s, Throwable throwable) {
                Log.d(TAG, "onFailure");
            }
        });
    }
}