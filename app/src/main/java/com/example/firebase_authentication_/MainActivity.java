package com.example.firebase_authentication_;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    Activity context = this;
    Button b1, b2, b3, b4;
    TextView tv4, tv8;
    EditText et1, et2, et3, et4;
    String email;

    FirebaseAuth mAuth;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);

        et1 = findViewById(R.id.editText);
        et2 = findViewById(R.id.editText2);
        et3 = findViewById(R.id.editText3);
        et4 = findViewById(R.id.editText4);

        tv4 = findViewById(R.id.textView4);
        tv8 = findViewById(R.id.textView8);

        mAuth = FirebaseAuth.getInstance();

        b1.setOnClickListener(view -> mAuth.createUserWithEmailAndPassword(et1.getText().toString(), et2.getText().toString()).addOnCompleteListener(context, task -> {
            if (task.isSuccessful()) {
                FirebaseUser user = mAuth.getCurrentUser();
                assert user != null;
                tv4.setText("結果：" + user.getEmail() + "註冊成功!!!!!!");
            } else {
                tv4.setText("結果：註冊失敗!!!!!!" + task.getException());
            }
        }));

        b2.setOnClickListener(view -> {
            et1.setText(null);
            et2.setText(null);
        });

        b3.setOnClickListener(v -> mAuth.signInWithEmailAndPassword(et3.getText().toString(), et4.getText().toString()).addOnCompleteListener(context, task -> {
            if (task.isSuccessful()) {
                FirebaseUser user = mAuth.getCurrentUser();
                assert user != null;
                tv8.setText("結果：登入" + user.getEmail() + "成功!!!!");
                email = user.getEmail();

            } else {

                tv8.setText("結果：登入失敗!!!!!!!" + task.getException());
            }
        }));

        b4.setOnClickListener(v -> {
            Intent intent=new Intent();
            intent.setClass(MainActivity.this,MainActivity2.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            intent.putExtra("email",email);
            startActivity(intent);

        });

    }
}