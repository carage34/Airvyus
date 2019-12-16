package com.example.airvyus.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.airvyus.R;
import com.example.airvyus.controller.EditController;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_layout);
        EditText email = findViewById(R.id.email_edit);
        EditText nom = findViewById(R.id.pseudo_edit);
        EditText position = findViewById(R.id.position_edit);
        Button submit  = findViewById(R.id.submit_edit);
        TextView tv = (TextView)findViewById(R.id.edit_name);

        Intent intent = getIntent();
        email.setText(intent.getStringExtra("email"));
        position.setText(intent.getStringExtra("position"));
        nom.setText(intent.getStringExtra("pseudo"));
        tv.setText("Modification de " + intent.getStringExtra("pseudo"));
        int id = intent.getIntExtra("id", -1);
        EditController editController = new EditController(email, nom, position, id+"", this);
        submit.setOnClickListener(editController);
    }
}
