package com.example.airvyus.model.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiManager {
    private static ServiceAPI serviceApi = null;
    public static final String BASE_URL = "https://airvyus.com/";
    public static final String STREAM_URL = BASE_URL + "/streams/";

    public static ServiceAPI getAPI()
    {
        if(serviceApi == null)
        {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            serviceApi = retrofit.create(ServiceAPI.class);
        }
        return serviceApi;
    }
}
