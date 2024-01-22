package com.example.skillactivityapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.skillactivityapp.data.myDbHandler;

import static java.lang.Thread.sleep;

public class PageActivity_8 extends AppCompatActivity {

    private TextView name, course, Branch, Phone;
    private ImageView imgpart;
    myDbHandler handler =  new myDbHandler(this, "student_db", null, 1);
    private String user;
    private String nullStore = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_display);
        setTitle("Student Details");

        Bundle bundle = getIntent().getExtras();
        user = bundle.getString("user_from_db");
        
        handler.getDetailsnbcp(user);

        String name_db = handler.name_db;
        String branch_db = handler.branch_db;
        String course_db = handler.course_db;
        String phone_db = handler.phone_db;

        initWidgets();

        name.setText(name_db);
        course.setText(branch_db);
        Branch.setText(course_db);
        Phone.setText(phone_db);

        if(name_db.equals("Joey Tribbiani"))
        {
            imgpart.setImageResource(R.drawable.joey_tribbiani);
        }
        if(name_db.equals("Ross Gellar"))
        {
            imgpart.setImageResource(R.drawable.ross_gellar);
        }
        if(name_db.equals("Chandler Bing"))
        {
            imgpart.setImageResource(R.drawable.chandler_bing);
        }
        if(name_db.equals("Monica Gellar"))
        {
            imgpart.setImageResource(R.drawable.monica_gellar);
        }
        if(name_db.equals("Phoebe Buffay"))
        {
            imgpart.setImageResource(R.drawable.phoebe_buffay);
        }
        if(name_db.equals("Rachel Green"))
        {
            imgpart.setImageResource(R.drawable.rachel_green);
        }

    }
    private void initWidgets() {
        name = findViewById(R.id.Name);
        course = findViewById(R.id.Course);
        Branch = findViewById(R.id.branch);
        Phone = findViewById(R.id.phone);

        imgpart = findViewById(R.id.imageView2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_and_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.item1)
        {
            Intent intent = new Intent(PageActivity_8.this,PageActivity_9.class);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.item2){
            Intent intent = new Intent(PageActivity_8.this,PageActivity_6.class);
            intent.putExtra("user_from_db", user);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.item3){
            Intent intent = new Intent(PageActivity_8.this,PageActivity_3.class);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.item5){
            Intent intent = new Intent(PageActivity_8.this,PageActivity_2.class);
//            intent.putExtra("user_from_db", nullStore);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.item6)
        {
            Intent intent = new Intent(PageActivity_8.this,PageActivity_7.class);
            intent.putExtra("user_from_db", user);
            startActivity(intent);
            return true;
        }
//        else if(id == R.id.item4){
//
//            final AlertDialog.Builder builder = new AlertDialog.Builder(PageActivity_8.this);
//            builder.setTitle("Exit");
//            builder.setMessage("Do you want to exit ?");
//            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i){
//                    finish();
//                }
//            });
//
//            final AlertDialog.Builder not_now = builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    dialogInterface.dismiss();
//                }
//            });
//            AlertDialog dial = builder.create();
//            dial.show();
//
//            return true;
//        }
        return super.onOptionsItemSelected(item);
    }

}