package com.example.airvyus.controller;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.airvyus.model.api.EditingAccount;
import com.example.airvyus.model.api.RegisterCredentials;
import com.example.airvyus.model.api.RestApiManager;
import com.example.airvyus.model.api.RestEditResponse;
import com.example.airvyus.model.api.RestRegisterReponse;

import java.io.IOException;

import retrofit2.Call;

public class EditController implements View.OnClickListener {
    String nom;
    String position;
    String email;
    String id;

    public EditController(EditText email, EditText position, EditText nom, String id) {
        this.nom = nom.getText().toString();
        this.position = position.getText().toString();
        this.email = email.getText().toString();
        this.id = id;
    }


    public void onClick(View v) {
        processEdit()
    }

    public void processEdit() {
        RestEditResponse restEditResponse= null;
        Call<RestEditResponse> callEdit = RestApiManager.getAPI().editAccount(new EditingAccount(id, this.nom, this.email, this.position));
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
