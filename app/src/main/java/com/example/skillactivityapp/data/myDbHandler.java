 package com.example.skillactivityapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.skillactivityapp.PageActivity_2;
import com.example.skillactivityapp.models.Student_Details;
import com.example.skillactivityapp.params.Params;

import java.net.PasswordAuthentication;


 public class myDbHandler extends SQLiteOpenHelper {
     public String user_db;
     public String pass_db;
     public String name_db;
     public String branch_db;
     public String course_db;
     public String phone_db;



    public myDbHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE IF NOT EXISTS student_details_table(Username TEXT PRIMARY KEY, Password TEXT, Name TEXT, Branch TEXT, Course TEXT, Phone_no TEXT)";
        db.execSQL(create);

    }

    //Username, Password, Name, Batch, Course, Program, Current_Sem

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop = String.valueOf("DROP TABLE IF EXISTS");
        db.execSQL(drop, new String[]{"student_details_table"});
        onCreate(db);
    }

    public void addUserPass(Student_Details details){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("Username", details.getUsername());
        values.put("Password", details.getPassword());
        values.put("Name", details.getName());
        values.put("Branch", details.getBranch());
        values.put("Course", details.getCourse());
        values.put("Phone_no", details.getPhone_no());

        long k = db.insert("student_details_table", null, values);
        Log.d("mytag", Long.toString(k));
    }

    public void getUserPass(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("student_details_table",
                new String[]{"Username", "Password"},
                "Username=?",
                new String[]{username},
                null, null, null);
        if(cursor != null && cursor.moveToFirst()){
            Log.d("mytagts", cursor.getString(0));
            Log.d("mytagts", cursor.getString(1));

            user_db = cursor.getString(0);
            pass_db = cursor.getString(1);
        }
        else {
            Log.d("mytag", "Some error occured"+cursor.getCount());
        }
    }

     public void getDetailsnbcp(String username){
         SQLiteDatabase db = this.getReadableDatabase();
         Cursor cursor = db.query("student_details_table",
                 new String[]{"Name", "Course", "Branch", "Phone_no"},
                 "Username=?",
                 new String[]{username},
                 null, null, null);
         if(cursor != null && cursor.moveToFirst()){
             Log.d("mytagts", cursor.getString(0));
             Log.d("mytagts", cursor.getString(1));
             Log.d("mytagts", cursor.getString(2));
             Log.d("mytagts", cursor.getString(3));

             name_db = cursor.getString(0);
             branch_db = cursor.getString(1);
             course_db = cursor.getString(2);
             phone_db = cursor.getString(3);
         }
         else {
             Log.d("mytag", "Some error occured"+cursor.getCount());
         }
     }

     public void updatePass(String username, String password_new){
         SQLiteDatabase db = this.getReadableDatabase();
         ContentValues cv = new ContentValues();
         cv.put("Password", password_new);
         db.update("student_details_table", cv, "Username = ?", new String[]{username});
     }

     public void updatePhoneNo(String username, String phone_new){
         SQLiteDatabase db = this.getReadableDatabase();

         ContentValues cv = new ContentValues();
         cv.put("Phone_no", phone_new);
         db.update("student_details_table", cv, "Username = ?", new String[]{username});
     }
}
