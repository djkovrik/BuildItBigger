package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.example.builditbigger.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<EndpointsAsyncTask.TaskFinishedCallback, Void, String> {

    private static MyApi myApiService = null;
    private static TaskFinishedCallback callback;

    interface TaskFinishedCallback {
        void onTaskFinished(String result);
    }

    @Override
    protected String doInBackground(TaskFinishedCallback... params) {
        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigger-163817.appspot.com/_ah/api/");

            myApiService = builder.build();
        }

        callback = params[0];

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        callback.onTaskFinished(joke);
    }
}
