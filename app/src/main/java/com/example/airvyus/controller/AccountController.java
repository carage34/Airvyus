package com.example.airvyus.controller;

import android.content.Context;
import android.widget.Toast;

import com.example.airvyus.model.api.Account;
import com.example.airvyus.model.api.DeletingData;
import com.example.airvyus.model.api.RegisterCredentials;
import com.example.airvyus.model.api.RestAccountResponse;
import com.example.airvyus.model.api.RestApiManager;
import com.example.airvyus.model.api.RestDeleteAccountResponse;
import com.example.airvyus.model.api.RestRegisterReponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class AccountController {

    private List<Account> accountList;

    public List<Account> getAccounts() {
        RestAccountResponse restAccountResponse= null;
        Call<List<Account>> callList = RestApiManager.getAPI().list();
        try {
            accountList = callList.execute().body();
            //accountList = restAccountResponse.getData();
            System.out.println(accountList + " BLA");
            return accountList;
            //Toast.makeText(restAccountResponse, "Inscription réussi", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            System.out.println("BLA2" + e.getMessage());
        }
        return null;
    }

    public void deleteAccount (String id, Context context) {
        RestDeleteAccountResponse restDeleteAccountResponse = null;
        Call<RestDeleteAccountResponse> callDelete = RestApiManager.getAPI().deleteAccount(new DeletingData(id));
        try {
            restDeleteAccountResponse = callDelete.execute().body();
            //if(restDeleteAccountResponse.getStatus().equals("success")) {
                Toast.makeText(context, "Suppression effectué", Toast.LENGTH_LONG).show();
            //} else {
                //Toast.makeText(context, "Erreur lors de la suppression", Toast.LENGTH_LONG).show();
            //}

        } catch(IOException e) {

        }
    }


}
