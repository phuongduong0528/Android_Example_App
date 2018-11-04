package com.example.trani.testapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {
    public static final String MESSAGE = "com.example.trani.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSend(View view){
        EditText editText = findViewById(R.id.editText);
        String message = String.valueOf(editText.getText());
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,message);
        startActivity(intent);
    }

    public void onDisplay(View view){
        Intent intent = new Intent(this, DisplayActivity.class);
        EditText editText = findViewById(R.id.editText);
        String message = String.valueOf(editText.getText());
        if(message.equalsIgnoreCase("")){
            //Prepare AlertDialog -> AlertDialog.Builder(Context context)
            AlertDialog.Builder alBuilder = new AlertDialog.Builder(this);
            //Message to be displayed
            alBuilder.setMessage(R.string.alert_dialog_message);
            alBuilder.setPositiveButton("OK",this);
            alBuilder.create();
            //Show Dialog
            alBuilder.show();
        }
        else{
            intent.putExtra(MESSAGE,message);
            startActivity(intent);
        }
    }

    public void onClickTimer(View view){
        Intent intent = new Intent(this, StopWatchActivity.class);
        startActivity(intent);
    }

    public void onClickListView(View view) {
        Intent intent = new Intent(this, ListViewExample.class);
        startActivity(intent);
    }

    public void onClickTableLayout(View view) {
        Intent intent = new Intent(this, TableLayoutExample.class);
        startActivity(intent);
    }

    //When click OK;
    @Override
    public void onClick(DialogInterface dialog, int which) {
        //Display pop up message - Context - Display Text - Duration (sec?)
        Toast.makeText(this, "Please type in the text box",Toast.LENGTH_LONG);
    }
}
