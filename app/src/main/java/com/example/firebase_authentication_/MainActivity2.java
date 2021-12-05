package com.example.firebase_authentication_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent= getIntent();
        String H1=intent.getStringExtra("email");
        TextView t1= findViewById(R.id.textView9);
        if (H1 != null){
            t1.setText(H1);
        }

    }
}