package com.example.drudnitskiy.ui;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class Sign_In extends AppCompatActivity {

    private Button btnSignUp;
    private NewDBHelper mDBHelper;
    private SQLiteDatabase mDb;
    private EditText etName;
    private EditText etEmail;
    private EditText etPassword;
    private Identity SignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__in);
        mDBHelper  = new NewDBHelper(this);
        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }

        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }
        Check();
    }

    private void Check()
    {
        btnSignUp = (Button)findViewById(R.id.button);
        etName = (EditText)findViewById(R.id.editText);
        etEmail = (EditText)findViewById(R.id.editText2);
        etPassword = (EditText)findViewById(R.id.editText3);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUp = new Identity(mDb,etName.getText().toString(),etPassword.getText().toString());
                if(SignUp.GetUser())
                {
                    Toast.makeText(Sign_In.this,"Right",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Sign_In.this,"Wrong",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
