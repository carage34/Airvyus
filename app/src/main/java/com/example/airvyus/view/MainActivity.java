package com.example.airvyus.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.airvyus.R;
import com.example.airvyus.controller.LoginController;
import com.example.airvyus.controller.SignUpController;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button submit = (Button) findViewById(R.id.submit_login);
        EditText inputPseudo = (EditText) findViewById(R.id.pseudo);
        EditText inputPassword = (EditText) findViewById(R.id.password);
        TextView signup = findViewById(R.id.link_signup);
        signup.setOnClickListener(new SignUpController(this));
        submit.setOnClickListener(new LoginController(this, inputPseudo, inputPassword));
    }
}
