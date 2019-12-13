package com.example.airvyus.controller;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.airvyus.model.api.LoginCredentials;
import com.example.airvyus.model.api.RestApiManager;
import com.example.airvyus.model.api.RestLoginResponse;
import com.example.airvyus.view.AccountsActivity;
import com.example.airvyus.view.RegisterActivity;

import java.io.IOException;

import retrofit2.Call;

public class LoginController implements View.OnClickListener {
    Activity main;
    EditText pseudo;
    EditText password;
    public LoginController(Activity m, EditText pseudo, EditText password) {
        this.main = m;
        this.pseudo = pseudo;
        this.password = password;
    }

    public void onClick(View v) {
        //Toast.makeText(this.main, this.pseudo.getText().toString(), Toast.LENGTH_LONG).show();

        RestLoginResponse restLoginResponse= null;
        Call<RestLoginResponse> callLogin = RestApiManager.getAPI().login(new LoginCredentials(this.pseudo.getText().toString(), this.password.getText().toString()));
        try {
            restLoginResponse = callLogin.execute().body();
            if(restLoginResponse.getAuth().equals("success")) {
                Toast.makeText(this.main, "Authentification réussi", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this.main, AccountsActivity.class);
                v.getContext().startActivity(intent);
            } else {
                Toast.makeText(this.main, restLoginResponse.getError(), Toast.LENGTH_LONG).show();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
