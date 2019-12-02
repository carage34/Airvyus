package com.example.airvyus.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.airvyus.R;
import com.example.airvyus.controller.RegisterController;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

public class RegisterActivity extends AppCompatActivity implements Validator.ValidationListener {

    @NotEmpty
    @Length(min=3)
    private EditText pseudo;

    @NotEmpty
    @Password(min=3)
    private EditText password;

    @NotEmpty
    @ConfirmPassword
    private EditText confirmPassword;

    private Button buttonValidate;

    private Validator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        validator = new Validator(this);
        validator.setValidationListener(this);
    }

    private void initView() {
        pseudo = findViewById(R.id.pseudo);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirm_password);
        buttonValidate = findViewById(R.id.submit_register);
        buttonValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trimValues();
                validator.validate();
            }
        });
    }

    public void trimValues() {
        pseudo.setText(pseudo.getText().toString().trim());
        password.setText(password.getText().toString().trim());
        confirmPassword.setText(confirmPassword.getText().toString().trim());
    }

    @Override
    public void onValidationSucceeded() {
        System.out.println("BLA3");
        System.out.println("BLA4 " + this.pseudo.getText().toString());
        System.out.println("BLA4 " + this.password.getText().toString());
        System.out.println("BLA4 " + this.confirmPassword.getText().toString());
        new RegisterController(this.pseudo, this.password, this.confirmPassword, this);
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);
            // Display error messages
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        }
    }
}
