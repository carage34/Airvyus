package com.example.airvyus.controller;

import android.app.Activity;
import android.widget.EditText;
import android.widget.Toast;

import com.example.airvyus.model.api.LoginCredentials;
import com.example.airvyus.model.api.RegisterCredentials;
import com.example.airvyus.model.api.RestApiManager;
import com.example.airvyus.model.api.RestLoginResponse;
import com.example.airvyus.model.api.RestRegisterReponse;

import java.io.IOException;

import retrofit2.Call;

public class RegisterController {
    private EditText pseudo;
    private EditText password;
    private EditText confirmPassword;
    private Activity register;

    public RegisterController(EditText pseudo, EditText password, EditText confirmPassword, Activity r) {
        this.pseudo = pseudo;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.register = r;
        processRegister();
    }

    public void processRegister() {
        System.out.println("BLA1");
        RestRegisterReponse restRegisterReponse= null;
        System.out.println("BLA5 " + this.pseudo);
        Call<RestRegisterReponse> callLogin = RestApiManager.getAPI().register(new RegisterCredentials(this.pseudo.getText().toString(), this.password.getText().toString(), this.confirmPassword.getText().toString()));
        try {
            restRegisterReponse = callLogin.execute().body();
            if(restRegisterReponse.getStatus().equals("success")) {
                Toast.makeText(this.register, "Inscription réussi", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this.register, restRegisterReponse.getError(), Toast.LENGTH_LONG).show();
            }
        } catch (IOException e) {
            System.out.println("BLA2" + e.getMessage());
        }
    }

}
