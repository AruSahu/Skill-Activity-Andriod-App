package com.example.skillactivityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PageActivity_5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_about_td_page);
        setTitle("Terms & Conditions");
        TextView t = findViewById(R.id.textView7);
        t.setText("This Application is not for commercial usage or for deployment on gooogle app store. This is made just for fulfilment of skill activity of Mobile Application Development. Any further upgradation or change in certain functionalities cannot be done unless consulted with the application developer or the faculty in charge.");
    }

}