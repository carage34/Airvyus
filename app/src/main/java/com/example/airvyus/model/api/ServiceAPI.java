package com.example.airvyus.model.api;

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

}
