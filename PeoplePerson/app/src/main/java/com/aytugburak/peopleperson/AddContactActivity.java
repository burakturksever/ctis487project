package com.aytugburak.peopleperson;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.aytugburak.peopleperson.classes.ClassList;
import com.aytugburak.peopleperson.classes.Contact;
import com.aytugburak.peopleperson.classes.ContactDB;
import com.aytugburak.peopleperson.classes.DatabaseHelper;

import java.util.ArrayList;

public class AddContactActivity extends AppCompatActivity {
    DatabaseHelper dbHelper;

    Button btnAddContactAc2;
    EditText etName, etSurname, etDob, etCategory;
    CheckBox cbFavorite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

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
}