package com.example.airvyus.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Button;
import android.widget.EditText;

import com.example.airvyus.R;
import com.example.airvyus.controller.LoginController;

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
        submit.setOnClickListener(new LoginController(this, inputPseudo, inputPassword));
    }
}
