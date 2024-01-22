package com.example.skillactivityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.skillactivityapp.data.myDbHandler;

public class PageActivity_7 extends AppCompatActivity {
    private Button cpn;
    private EditText EditTextPhone;
    myDbHandler handler =  new myDbHandler(this, "student_db", null, 1);
    private String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_phone);
        setTitle("Change Phone Number");

        initWidgets();
        setOnClickListener();
    }

    private void initWidgets() {
        EditTextPhone = findViewById(R.id.editTextPhone);
        cpn = findViewById(R.id.button3);
    }

    private void setOnClickListener() {
        cpn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getIntent().getExtras();
                user = bundle.getString("user_from_db");

                String pno1 = EditTextPhone.getText().toString();

                handler.updatePhoneNo(user, pno1);
                Toast.makeText(PageActivity_7.this, "Phone Number updated successful", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(PageActivity_7.this,PageActivity_8.class);
                intent.putExtra("user_from_db", user);
                startActivity(intent);
            }
        });
    }

}