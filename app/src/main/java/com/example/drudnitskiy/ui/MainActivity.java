package com.example.drudnitskiy.ui;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

private Button btnChange;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Change();
    }

    public void Change()
    {
        btnChange = (Button)findViewById(R.id.sign_up_button);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent some = new Intent(".Sign_In");
                startActivity(some);
            }
        });
    }


}
