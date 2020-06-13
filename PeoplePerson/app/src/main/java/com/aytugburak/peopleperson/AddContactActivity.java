package com.aytugburak.peopleperson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.aytugburak.peopleperson.classes.ClassList;
import com.aytugburak.peopleperson.classes.Contact;
import com.aytugburak.peopleperson.classes.ContactDB;
import com.aytugburak.peopleperson.classes.DatabaseHelper;
import com.aytugburak.peopleperson.classes.RVAdapter;

import java.util.ArrayList;

public class AddContactActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    DatabaseHelper dbHelper;

    GestureDetectorCompat mDetector;
    Button btnAddContactAc2;
    EditText etName, etSurname, etDob, etCategory;
    CheckBox cbFavorite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        // Gesture detection
        mDetector = new GestureDetectorCompat(this, this);

        //Making header gradient
        TextView textView = (TextView) findViewById(R.id.textView2);
        TextPaint paint = textView.getPaint();
        float width = paint.measureText("Add Contact");

        Shader textShader = new LinearGradient(0, 0, width, textView.getTextSize(),
                new int[]{
                        Color.parseColor("#F6255F"),
                        Color.parseColor("#BD62DD"),
                }, null, Shader.TileMode.CLAMP);
        textView.getPaint().setShader(textShader);
        //Making header gradient end

        etName = (EditText)findViewById(R.id.etName);
        etSurname = (EditText)findViewById(R.id.etSurname);
        etDob = (EditText)findViewById(R.id.etDob);
        etCategory = (EditText)findViewById(R.id.etCategory);
        cbFavorite = (CheckBox) findViewById(R.id.cbFavorite);
        dbHelper = new DatabaseHelper(this);
        btnAddContactAc2 = findViewById(R.id.btnAddContactAc2);
        btnAddContactAc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String surname = etSurname.getText().toString();
                String birthDate = etDob.getText().toString();
                String category = etCategory.getText().toString();
                boolean favorited = cbFavorite.isChecked();

                ContactDB.insertContact(dbHelper, name, surname, birthDate, category, favorited);
                finish();
            }
        });
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
        finish();
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