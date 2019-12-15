package com.example.airvyus.model.api;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.Call;
import retrofit2.http.Query;

public interface ServiceAPI {
    public static final String ENDPOINT = "https://airvyus.com/";

    @POST("login")
    Call<RestLoginResponse> login(@Body LoginCredentials data);

    @POST("register")
    Call<RestRegisterReponse> register(@Body RegisterCredentials data);

    @POST("list")
    Call<List<Account>> list();

    @POST("deleteaccountandroid")
    Call<RestDeleteAccountResponse> deleteAccount(@Body DeletingData data);


}
