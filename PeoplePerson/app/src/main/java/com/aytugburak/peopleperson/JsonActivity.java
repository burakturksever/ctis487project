package com.aytugburak.peopleperson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

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
                    File file = new File("yourname.json");
                    try {
                        FileWriter fw = new FileWriter(file);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write("{'yourname':[{'name':" + yourname+ "}]}");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    finish();
                }
                else {
                    Toast.makeText(JsonActivity.this, "Please enter a valid name", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}