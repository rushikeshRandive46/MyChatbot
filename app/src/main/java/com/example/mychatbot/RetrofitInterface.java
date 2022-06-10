package com.example.mychatbot;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RetrofitInterface {

    @GET()
    Call<Model> getAns();
}
