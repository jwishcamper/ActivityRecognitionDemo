package com.example.activitytest;

import android.app.IntentService;
import android.content.Intent;

import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;


public class ActivityIntentService extends IntentService {

    public ActivityIntentService() {
        super("ActivityIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if(ActivityRecognitionResult.hasResult(intent)) {
            ActivityRecognitionResult result = ActivityRecognitionResult.extractResult(intent);
            handleDetectedActivities( result.getMostProbableActivity() );
        }
    }
    private void handleDetectedActivities(DetectedActivity probableActivities) {
        switch( probableActivities.getType() ) {
            case DetectedActivity.IN_VEHICLE: {
                MainActivity.t.setText("Vehicle: " + probableActivities.getConfidence() + "%");
                break;
            }
            case DetectedActivity.ON_BICYCLE: {
                MainActivity.t.setText("Bicycle: " + probableActivities.getConfidence() + "%");
                break;
            }
            case DetectedActivity.STILL: {
                MainActivity.t.setText("Still: " + probableActivities.getConfidence() + "%");
                break;
            }
            case DetectedActivity.WALKING: {
                MainActivity.t.setText("Walking: " + probableActivities.getConfidence() + "%");
                break;
            }
            case DetectedActivity.RUNNING: {
                MainActivity.t.setText("Running: " + probableActivities.getConfidence() + "%");
                break;
            }
            case DetectedActivity.ON_FOOT: {
                MainActivity.t.setText("On Foot: " + probableActivities.getConfidence() + "%");
                break;
            }
            case DetectedActivity.TILTING: {
                MainActivity.t.setText("Tilting: " + probableActivities.getConfidence() + "%");
                break;
            }
            case DetectedActivity.UNKNOWN: {
                MainActivity.t.setText("Unknown: " + probableActivities.getConfidence() + "%");
                break;
            }
        }
    }
}

