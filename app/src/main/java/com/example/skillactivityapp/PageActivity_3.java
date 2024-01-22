package com.example.skillactivityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PageActivity_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_about_td_page);
        setTitle("Help");
        TextView t = findViewById(R.id.textView7);
        t.setText("Welcome, to begin with the application follow the below steps :\n" +
                " 1. Click on the login button on the screen.\n" +
                " 2. Now enter the username (your enrollment number) & your password as informed by your class coordinator.\n" +
                "\n" +
                "If you want to update or add your profile picture, follow the below steps :\n" +
                " 1. Log in to your student account and click on update option from the menu.\n" +
                " 2. Now choose update Image option.\n" +
                " 3. Now, you have been provided with 2 options, i.e., either you can click a new photo or select from youe device.\n" +
                "\n" +
                "If you want to update or add your phone number, follow the below steps :\n" +
                " 1. Log in to your student account and click on update option from the menu.\n" +
                " 2. Now choose update phone number option.\n" +
                " 3. Now fill the blank with the phone number you want to update and click update. \n" +
                "\n" +
                "If you want to update or add your password, follow the below steps :\n" +
                " 1. Log in to your student account and click on Change Password option from the menu.\n" +
                " 2. Now give the new password and confirm it, then click on update option to update it.");
    }

}