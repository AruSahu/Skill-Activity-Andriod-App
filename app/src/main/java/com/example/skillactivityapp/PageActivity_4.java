package com.example.skillactivityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PageActivity_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_about_td_page);
        setTitle("About");
        TextView t = findViewById(R.id.textView7);
        t.setText("Welcome to Symbios University Student Application, this app is designed for the skill activity purpose for demostrating various functions and its working to fulfil the task provided for the skill assessment.\n");
    }

}