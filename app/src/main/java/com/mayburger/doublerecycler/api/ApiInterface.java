package com.mayburger.doublerecycler.api;

import com.mayburger.doublerecycler.model.Data;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/scholarship/all")
    Call<Data> getDataInfo();
}
