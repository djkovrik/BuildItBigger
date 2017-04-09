package com.udacity.gradle.builditbigger.test;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {

    @Rule
    public final ActivityTestRule<MainActivity> mActivityActivityTestRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testAsyncTaskLoadsJoke() throws Exception {

        // Assign
        EndpointsAsyncTask testTask = new EndpointsAsyncTask(mActivityActivityTestRule.getActivity());

        // Action
        testTask.execute();
        String joke = testTask.get();

        // Assert
        assertNotNull(joke);
        assertFalse(joke.isEmpty());
    }
}
