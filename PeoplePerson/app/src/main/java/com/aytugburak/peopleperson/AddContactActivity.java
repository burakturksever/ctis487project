package com.aytugburak.peopleperson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.aytugburak.peopleperson.classes.ContactDB;
import com.aytugburak.peopleperson.classes.DatabaseHelper;

public class AddContactActivity extends AppCompatActivity {
    DatabaseHelper dbHelper;

    Button btnAddContactAc2;
    EditText etName, etSurname, etDob, etCategory;
    CheckBox cbFavorite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        etName = findViewById(R.id.etName);
        etSurname = findViewById(R.id.etSurname);
        etDob = findViewById(R.id.etDob);
        etCategory = findViewById(R.id.etCategory);
        cbFavorite = findViewById(R.id.cbFavorite);

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
            }
        });
    }
}