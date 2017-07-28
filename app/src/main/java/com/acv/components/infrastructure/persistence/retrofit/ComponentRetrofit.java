package com.acv.components.infrastructure.persistence.retrofit;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.acv.components.domain.NetworkException;
import com.acv.components.domain.NetworkGatewayException;
import com.acv.components.domain.gateway.ComponentNetworkGateway;
import com.acv.components.domain.model.User;
import com.acv.components.infrastructure.domain.mapper.Mapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ComponentRetrofit implements ComponentNetworkGateway {

    private ApiClient apiClient;
    private Mapper<UserResult, User> mapper;

    public ComponentRetrofit(ApiClient apiClient, Mapper<UserResult, User> mapper) {
        this.apiClient = apiClient;
        this.mapper = mapper;
    }

    @Override
    public LiveData<List<User>> obtainUser(String id) throws NetworkException, NetworkGatewayException {
        final MutableLiveData<List<User>> data = new MutableLiveData<>();
        apiClient.getAllRandomUsers().enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
             data.setValue(getUsers(response));
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });
//        try {
//            data.setValue(getUsers(apiClient.getAllRandomUsers().execute()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return data;
    }

    @NonNull
    private List<User> getUsers(Response<UserResponse> response) {
        List<UserResult> results = response.body().getResults();
        List<User> randomUsers = new ArrayList<>();
        if (results != null) {
            for (UserResult result : results) {
                randomUsers.add(mapper.map(result));
            }
        }
        return randomUsers;
    }
}
