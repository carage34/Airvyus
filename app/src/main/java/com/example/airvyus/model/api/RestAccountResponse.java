package com.example.airvyus.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;



public class RestAccountResponse {

    private List<Account> data;

    public List<Account> getData() {
        return data;
    }

    public void setData(List<Account> data) {

    }
}
