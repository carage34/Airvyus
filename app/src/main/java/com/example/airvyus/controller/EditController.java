package com.example.airvyus.controller;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.airvyus.model.api.EditingAccount;
import com.example.airvyus.model.api.RegisterCredentials;
import com.example.airvyus.model.api.RestApiManager;
import com.example.airvyus.model.api.RestEditResponse;
import com.example.airvyus.model.api.RestRegisterReponse;
import com.example.airvyus.view.EditActivity;
import com.example.airvyus.view.MainActivity;

import java.io.IOException;

import retrofit2.Call;

public class EditController implements View.OnClickListener {
    EditText nom;
    EditText position;
    EditText email;
    String id;
    EditActivity ctx;

    public EditController(EditText email, EditText nom, EditText position,  String id, EditActivity ctx) {
        this.nom = nom;
        this.position = position;
        this.email = email;
        this.id = id;
        this.ctx = ctx;
    }


    public void onClick(View v) {
        processEdit();
    }

    public void processEdit() {
        RestEditResponse restEditResponse= null;
        Call<RestEditResponse> callEdit = RestApiManager.getAPI().editAccount(new EditingAccount(id, this.nom.getText().toString(), this.email.getText().toString(), this.position.getText().toString()));
        try {
            System.out.println("BLOU");
            restEditResponse = callEdit.execute().body();
            Toast.makeText(this.ctx, "Modification effectué avec succès", Toast.LENGTH_LONG).show();
            ctx.finish();
            /*if(restEditResponse.getStatus().equals("success")) {
                Toast.makeText(this.register, "Inscription réussi", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this.register, restRegisterReponse.getError(), Toast.LENGTH_LONG).show();
            }*/
        } catch (IOException e) {
            System.out.println("BLA2" + e.getMessage());
        }
    }
}
