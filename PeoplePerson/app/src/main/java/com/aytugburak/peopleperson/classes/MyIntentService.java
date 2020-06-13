package com.aytugburak.peopleperson.classes;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 */
public class MyIntentService extends IntentService {
    // One needs to implement a constructor for the class and call its superclass
    // with the name of the intent service (setting it with a string).
    public MyIntentService() {
        super("MyIntentService");
    }

    // The onHandleIntent() method is where you place the code that needs to be executed on
    // a separate thread, such as downloading a file from a server. When the code has
    // finished executing, the thread is terminated and the service is stopped automatically.

    protected void onHandleIntent(Intent intent) {
        Log.d("IntentService", "Service Started");
        Toast.makeText(this, "!", Toast.LENGTH_SHORT).show();
        Log.d("IntentService", "Service will be terminated");
        Log.d("IntentService", "Activity thread cannot be access from the IntentService");
    }
}