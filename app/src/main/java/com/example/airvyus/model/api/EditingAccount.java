package com.example.airvyus.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EditingAccount {
    private String id;

    private String nom;

    private String email;

    private String position;

    public EditingAccount(String id, String nom, String email, String position) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.position = position;
    }
}
