package com.example.jokeactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    private static final String JOKE_KEY = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Intent intent = getIntent();

        TextView jokeTextView = (TextView) findViewById(R.id.joke_text);

        if (intent.hasExtra(JOKE_KEY)) {
            String jokeText = intent.getStringExtra(JOKE_KEY);

            if (jokeText != null && jokeText.length() != 0) {
                jokeTextView.setText(jokeText);
            }
        }
    }
}
