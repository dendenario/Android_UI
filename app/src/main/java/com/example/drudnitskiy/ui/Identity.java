package com.example.drudnitskiy.ui;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

import javax.xml.namespace.NamespaceContext;

public class Identity {
    private String Login;
    private String Password;
    //private boolean LoginOK;
    private SQLiteDatabase database;

    public Identity(SQLiteDatabase db, String login, String password)
    {
        Login = login;
        Password = password;
        database = db;
    }

//    public boolean Check()
//    {
//
//    }

    public boolean GetUser()
    {
        Cursor cursor = database.rawQuery("SELECT * FROM Users",null);
        if(cursor.moveToFirst())
        {
            List<String> table1 = new ArrayList<>();
            List<String> table2 = new ArrayList<>();
            do
            {
                table1.add(cursor.getString(0));
                table2.add(cursor.getString(1));
            }
            while ((cursor.moveToNext()));
            int passwordIndex = table1.indexOf(Login);
            String password = null;
            if(passwordIndex>=0)
            {
                password = table2.get(passwordIndex);
            }
            if(Password.equals(password))
            {
                return true;
            }
        }
        return false;
    }

}
