package com.aytugburak.peopleperson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

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

    }
}