package com.example.sharepreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private EditText phone;
    private EditText sex;
    private Button save;
    private Button read;
    private Button clear;
    private SharedPreferences settings;
    private static final String data = "DATA";
    private static final String nameField = "NAME";
    private static final String phoneField = "PHONE";
    private static final String sexField = "SEX";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText)findViewById(R.id.nameField);
        phone = (EditText)findViewById(R.id.phoneField);
        sex = (EditText)findViewById(R.id.sexField);
        save = (Button)findViewById(R.id.saveButton);
        read = (Button)findViewById(R.id.readButton);
        clear = (Button)findViewById(R.id.clearButton);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settings = getSharedPreferences(data,0);
                settings.edit()
                        .putString(nameField, name.getText().toString())
                        .putString(phoneField, phone.getText().toString())
                        .putString(sexField, sex.getText().toString())
                        .commit();
            }
        });
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settings = getSharedPreferences(data,0);
                name.setText(settings.getString(nameField, ""));
                phone.setText(settings.getString(phoneField, ""));
                sex.setText(settings.getString(sexField, ""));
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                phone.setText("");
                sex.setText("");
            }
        });
    }

}