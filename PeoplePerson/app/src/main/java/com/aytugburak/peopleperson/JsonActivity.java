package com.aytugburak.peopleperson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class JsonActivity extends AppCompatActivity {

    Button btnAddYourInfo;
    EditText etYourName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        btnAddYourInfo = findViewById(R.id.btnAddYourself);
        etYourName = findViewById(R.id.etYourName);
        btnAddYourInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!etYourName.getText().toString().isEmpty()) {
                    String yourname = etYourName.getText().toString();

                    finish();
                }
                else {
                    Toast.makeText(JsonActivity.this, "Please enter a valid name", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}