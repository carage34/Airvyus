package com.example.airvyus.model.api;

public class RegisterCredentials {

    private String pseudo;
    private String pass;
    private String confirmpass;

    public RegisterCredentials(String pseudo, String password, String confirmPassword) {
        this.pseudo = pseudo;
        this.pass = password;
        this.confirmpass = confirmPassword;
    }
}
