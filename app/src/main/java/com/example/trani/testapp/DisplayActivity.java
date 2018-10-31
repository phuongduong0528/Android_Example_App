package com.example.trani.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.MESSAGE);
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int selection;
        Spinner spinner = findViewById(R.id.spinner);
        TextView textView = findViewById(R.id.textView);
        selection = spinner.getSelectedItemPosition();
        switch (selection){
            case 0:
                textView.setTextSize(15.0f);
                break;
            case 1:
                textView.setTextSize(20.0f);
                break;
            case 2:
                textView.setTextSize(25.0f);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
