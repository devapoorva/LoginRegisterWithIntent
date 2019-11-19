package com.xbrainz.loginregisterwithintent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class Dashboard extends AppCompatActivity {

    TextView email,password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        email = findViewById(R.id.text_email);
        password = findViewById(R.id.text_password);

        Intent intent = getIntent();
        if(intent != null)
        {
            email.setText(intent.getStringExtra("email"));
            password.setText(intent.getStringExtra("password"));
        }
    }
}
