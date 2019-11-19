package com.xbrainz.loginregisterwithintent;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    private static final String TAG = "Register";
    private String userEmail,userPassword;

    private EditText email,password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"Activity Created");
        setContentView(R.layout.activity_register);

        initializeView();
    }

    private void initializeView() {
        email = findViewById(R.id.edt_email);
        password = findViewById(R.id.edt_password);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"Activity Start");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"Activity Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"activity stop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"Activity Resume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"Activity Destroyed");
    }

    public void register(View view) {
        userEmail = email.getText().toString().trim();
        userPassword = password.getText().toString();
        // validate code here

        Intent intent = new Intent(Register.this,Login.class);
        intent.putExtra("email",userEmail);
        intent.putExtra("password",userPassword);
        startActivity(intent);

    }
}
