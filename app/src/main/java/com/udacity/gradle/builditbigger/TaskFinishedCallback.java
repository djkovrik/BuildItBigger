package com.udacity.gradle.builditbigger;

@SuppressWarnings("WeakerAccess")
public interface TaskFinishedCallback {
    void onTaskFinished(String result);
}