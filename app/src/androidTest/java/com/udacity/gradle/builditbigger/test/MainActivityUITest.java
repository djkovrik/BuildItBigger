package com.udacity.gradle.builditbigger.test;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityActivityTestRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void buttonLaunchesOtherActivity() throws Exception {

        // Action
        onView(withId(R.id.btn_tell_joke))
                .perform(click());

        // Assert
        onView(withId(R.id.joke_text))
                .check(matches(notNullValue()));
    }
}
