package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.jokeactivity.JokeActivity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


public class MainActivity extends AppCompatActivity implements TaskFinishedCallback {

    private static final String JOKE_KEY = "joke";
    private ProgressBar progressBar;
    private RelativeLayout mainView;
    private InterstitialAd interstitialAd;
    private boolean resumeFromAd = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.loading_indicator);
        mainView = (RelativeLayout) findViewById(R.id.main_view);

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.banner_ad_unit_id));
        requestNewInterstitial();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!resumeFromAd) {
            showMainView();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("UnusedParameters")
    public void tellJoke(View view) {

        showLoadingIndicator();

        if (interstitialAd.isLoaded()) {
            interstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    requestNewInterstitial();
                    new EndpointsAsyncTask(MainActivity.this).execute();
                }
            });
            resumeFromAd = true;
            interstitialAd.show();
        } else {
            new EndpointsAsyncTask(MainActivity.this).execute();
        }
    }


    @Override
    public void onTaskFinished(String result) {
        Context context = getApplicationContext();
        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra(JOKE_KEY, result);
        resumeFromAd = false;
        context.startActivity(intent);
    }

    @SuppressWarnings("WeakerAccess")
    void requestNewInterstitial() {
        AdRequest request = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        interstitialAd.loadAd(request);
    }

    private void showMainView() {
        progressBar.setVisibility(View.INVISIBLE);
        mainView.setVisibility(View.VISIBLE);
    }

    private void showLoadingIndicator() {
        progressBar.setVisibility(View.VISIBLE);
        mainView.setVisibility(View.INVISIBLE);
    }
}
