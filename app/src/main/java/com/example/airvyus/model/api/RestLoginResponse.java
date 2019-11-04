package com.example.airvyus.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestLoginResponse {

    @SerializedName("auth")
    @Expose
    private String auth;
    @SerializedName("error")
    @Expose
    private String error;

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}