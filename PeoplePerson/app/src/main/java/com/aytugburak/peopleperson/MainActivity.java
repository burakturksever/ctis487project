package com.aytugburak.peopleperson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    SharedPreferences preferences = null;
    private GestureDetectorCompat mDetector;
    MediaPlayer kurtlarVadisi;
    Button btnAddContact;
    TextView tvWelcomeMessage;
    ArrayList<String> yourname = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        preferences = getSharedPreferences("com.aytugburak.peopleperson", MODE_PRIVATE);

        // service
        Intent serviceintent = new Intent(getBaseContext(), MyService.class);
        startService(serviceintent);

        //Making header gradient
        TextView textView = (TextView) findViewById(R.id.textView);
        TextPaint paint = textView.getPaint();
        float width = paint.measureText("PeoplePerson");

        Shader textShader = new LinearGradient(0, 0, width, textView.getTextSize(),
                new int[]{
                        Color.parseColor("#F6255F"),
                        Color.parseColor("#BD62DD"),
                }, null, Shader.TileMode.CLAMP);
        textView.getPaint().setShader(textShader);
        //Making header gradient end

        // gesture detector
        mDetector = new GestureDetectorCompat(this,this);
        // add contact activity functionality
        btnAddContact = findViewById(R.id.btnAddContact);
        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAddContactActivity();
            }
        });
        kurtlarVadisi = MediaPlayer.create(MainActivity.this, R.raw.kurtlarvadisi);
        kurtlarVadisi.start();
        kurtlarVadisi.setVolume((float)0.1, (float)0.1);
        tvWelcomeMessage = findViewById(R.id.tvWelcomeMessage);
    }

    public void startAddContactActivity(){
        Intent intent = new Intent(MainActivity.this, AddContactActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (preferences.getBoolean("firstrun", true)) {
            Intent jsonintent = new Intent(MainActivity.this, JsonActivity.class);
            startActivity(jsonintent);
            preferences.edit().putBoolean("firstrun", false).commit();
        }
        else {
            try {
                String json;
                InputStream inputStream = getAssets().open("yourname.json");
                int size = inputStream.available();
                byte[] buffer = new byte[size];
                inputStream.read();
                inputStream.close();

                json = new String(buffer, "UTF-8");
                JSONArray jsonArray = new JSONArray(json);
                for(int i = 0; i <  jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    yourname.add(jsonObject.getString("name"));
                }
                tvWelcomeMessage.setText("Welcome, " + yourname.get(0));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        startAddContactActivity();
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}