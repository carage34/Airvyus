package com.example.airvyus.controller;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.example.airvyus.view.RegisterActivity;

public class SignUpController implements View.OnClickListener {

    private Activity loginActivity;

    public SignUpController(Activity loginAct) {
        this.loginActivity = loginAct;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this.loginActivity, RegisterActivity.class);
        view.getContext().startActivity(intent);
    }
}
