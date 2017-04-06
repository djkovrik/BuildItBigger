package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.builditbigger.myapplication.backend.myApi.MyApi;
import com.example.jokeactivity.JokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {

    private static final String JOKE_KEY = "joke";

    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Context... params) {
        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigger-163817.appspot.com/_ah/api/");

            myApiService = builder.build();
        }

        context = params[0];

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra(JOKE_KEY, joke);
        intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
