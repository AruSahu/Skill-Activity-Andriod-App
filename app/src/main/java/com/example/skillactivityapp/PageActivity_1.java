package com.example.skillactivityapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PageActivity_1 extends AppCompatActivity {

    private long bpt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcom_page);
        setTitle("STUDENT APP");
        Button b = findViewById(R.id.login);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PageActivity_1.this,PageActivity_2.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {


        if(bpt + 2000 > System.currentTimeMillis()){
            super.onBackPressed();
            return;
        }
        else{
            Toast.makeText(getBaseContext(),"Press back again to exit",Toast.LENGTH_SHORT).show();
        }

        bpt = System.currentTimeMillis();
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
            Intent intent = new Intent(PageActivity_1.this,PageActivity_3.class);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.item2){
            Intent intent = new Intent(PageActivity_1.this,PageActivity_4.class);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.item3){
            Intent intent = new Intent(PageActivity_1.this,PageActivity_5.class);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.item4){

            final AlertDialog.Builder builder = new AlertDialog.Builder(PageActivity_1.this);
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