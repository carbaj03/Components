package com.acv.components.infrastructure.persistence.retrofit;

import retrofit2.http.GET;

public interface ApiClient {
    @GET("/?results=40")
    Call<UserResponse> getAllRandomUsers();
}