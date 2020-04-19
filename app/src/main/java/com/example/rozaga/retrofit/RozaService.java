package com.example.rozaga.retrofit;

import com.example.rozaga.model.Example;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RozaService {
    @GET("/")
    Call<List<Example>> getUserData();
}