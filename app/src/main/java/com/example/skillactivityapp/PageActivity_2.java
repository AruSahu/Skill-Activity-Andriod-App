package com.example.skillactivityapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.skillactivityapp.data.myDbHandler;
import com.example.skillactivityapp.models.Student_Details;

public class PageActivity_2 extends AppCompatActivity {

    private Button signIN;
    private EditText editText, editText2;
    private String user, pass, user_db, pass_db;
    private String users = "empty";
    myDbHandler handler =  new myDbHandler(this, "student_db", null, 1);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        setTitle("Login");

//        Bundle bundle = getIntent().getExtras();
//        users = bundle.getString("user_from_db");
//
//        if(!users.equals(null))
//        {
//
//        }

        handler.addUserPass(new Student_Details("ross.gellar", "dinosaur", "Ross Gellar", "Paleontology", "BioTech", "7946132580"));
        handler.addUserPass(new Student_Details("joey.tribbiani", "howudoin", "Joey Tribbiani", "B.Tech", "CSIT", "7641389564"));
        handler.addUserPass(new Student_Details("chandler.bing", "iamsarcastic", "Chandler Bing", "B.Tech", "CSIT", "9865321470"));
        handler.addUserPass(new Student_Details("monica.gellar", "iknow", "Monica Gellar", "Home Science", "Cooking", "7469852310"));
        handler.addUserPass(new Student_Details("phoebe.buffay", "myeyes", "Phoebe Buffay", "B.Tech", "CSIT", "7485963120"));
        handler.addUserPass(new Student_Details("rachel.green", "iamashoe", "Rachel Green", "Fashion Designing", "Modeling", "7425896310"));

//        handler.getUserPass("ross.gellar");

        initWidgets();
        setOnClickListener();
    }

    private void setOnClickListener() {
        signIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = editText.getText().toString();
                pass = editText2.getText().toString();

                handler.getUserPass(user);

                user_db = handler.user_db.toString();
                pass_db = handler.pass_db.toString();

//                Toast.makeText(PageActivity_2.this,user_db+" "+pass_db+" "+user+" "+pass,Toast.LENGTH_SHORT).show();

                if((user.equals(user_db)) && (pass.equals(pass_db)))
                {
                    Toast.makeText(PageActivity_2.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(PageActivity_2.this,PageActivity_8.class);
                    intent.putExtra("user_from_db", user);
                    user = null;
                    pass = null;
                    user_db = null;
                    pass_db = null;
                    startActivity(intent);
                }
                else{
//                    if(!(user != user_db && pass != pass_db))
                    {
                        Toast.makeText(PageActivity_2.this,"Login Unsuccessful",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void initWidgets() {
        signIN = findViewById(R.id.signIN);
        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.welcome_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.item1)
        {
            Intent intent = new Intent(PageActivity_2.this,PageActivity_3.class);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.item2){
            Intent intent = new Intent(PageActivity_2.this,PageActivity_4.class);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.item3){
            Intent intent = new Intent(PageActivity_2.this,PageActivity_5.class);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.item4){

            final AlertDialog.Builder builder = new AlertDialog.Builder(PageActivity_2.this);
            builder.setTitle("Exit");
            builder.setMessage("Do you want to exit ?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i){
                    finish();
                }
            });

            final AlertDialog.Builder not_now = builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            AlertDialog dial = builder.create();
            dial.show();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}