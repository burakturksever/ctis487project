package com.aytugburak.peopleperson;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;


public class MyService extends IntentService {

    public MyService() {
        super("MyService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d("IntentService", "Service started");
    }
}
