package com.xbrainz.loginregisterwithintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText email,password;
    private Button btnLogin;

    private String userEmail,userPassword;

    private String intentEmail,intentPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent intent = getIntent();
        if(intent!=null)
        {
            intentEmail = intent.getStringExtra("email");
            intentPassword = intent.getStringExtra("password");
        }
        Toast.makeText(getApplicationContext(),intentEmail+"\n"+intentPassword,Toast.LENGTH_SHORT).show();
        initializeView();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userEmail = email.getText().toString().trim();
                userPassword = password.getText().toString();

                if(userEmail.isEmpty())
                {
                    email.setError("Enter Email");
                }
                else if(!isValidEmail(userEmail))
                {
                    email.setError("Enter Valid Email");
                }
                else if(userPassword.isEmpty())
                {
                    password.setError("Enter Password");
                }
                else if(password.length()<5)
                {
                    password.setError("Enter valid Password");
                    Toast.makeText(Login.this,"Password should be minimun 5 character",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    // check valid user
                    checkValidUser();

                    Intent abc = new Intent(Login.this,Dashboard.class);
                    abc.putExtra("email",userEmail);
                    abc.putExtra("password",userPassword);
                    startActivity(abc);
                }
            }
        });

    }

    public void checkValidUser()
    {
        if(!intentEmail.equalsIgnoreCase(userEmail))
        {
            Toast.makeText(getApplicationContext(),"Enter Valid Email ID",Toast.LENGTH_SHORT).show();
            return;
        }
        if(!intentPassword.equals(userPassword))
        {
            Toast.makeText(getApplicationContext(),"Enter Valid Password",Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(getApplicationContext(),"User validated",Toast.LENGTH_SHORT).show();
    }

    private void initializeView()
    {
        email = findViewById(R.id.edt_email);
        password = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
    }

    private boolean isValidEmail(CharSequence charSequence)
    {
        return Patterns.EMAIL_ADDRESS.matcher(charSequence).matches();
    }
}
