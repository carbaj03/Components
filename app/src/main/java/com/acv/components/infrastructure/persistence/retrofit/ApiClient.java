package com.acv.components.infrastructure.persistence.retrofit;

import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.http.GET;

@Singleton
public interface ApiClient {
    @GET("/?results=40")
    Call<UserResponse> getAllRandomUsers();
}