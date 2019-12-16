package com.example.airvyus.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.airvyus.R;
import com.example.airvyus.controller.EditController;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText email = findViewById(R.id.email_edit);
        EditText nom = findViewById(R.id.pseudo_edit);
        EditText position = findViewById(R.id.position_edit);
        Button submit  = findViewById(R.id.submit_edit);
        EditController editController = new EditController(email, nom, position);
        submit.setOnClickListener(editController);
    }
}
