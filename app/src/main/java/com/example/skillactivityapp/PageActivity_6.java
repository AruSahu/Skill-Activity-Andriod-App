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

public class PageActivity_6 extends AppCompatActivity {
    private Button cpn;
    private EditText EditTextTextPassword2, EditTextTextPassword3;
    myDbHandler handler =  new myDbHandler(this, "student_db", null, 1);
    private String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_pass);
        setTitle("Change Password");

        initWidgets();
        setOnClickListener();
    }

    private void initWidgets() {
        EditTextTextPassword2 = findViewById(R.id.editTextTextPassword2);
        EditTextTextPassword3 = findViewById(R.id.editTextTextPassword3);
        cpn = findViewById(R.id.button2);
    }

    private void setOnClickListener() {
        cpn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getIntent().getExtras();
                user = bundle.getString("user_from_db");

                String pno1 = EditTextTextPassword2.getText().toString();
                String pno2 = EditTextTextPassword3.getText().toString();

//                Toast.makeText(PageActivity_6.this, pno1+" "+pno2, Toast.LENGTH_SHORT).show();

                if(!(pno1 == pno2)){
                    handler.updatePass(user, pno1);
                    Toast.makeText(PageActivity_6.this, "Password updated successfully", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(PageActivity_6.this,PageActivity_8.class);
                    intent.putExtra("user_from_db", user);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(PageActivity_6.this, "Password do not match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}