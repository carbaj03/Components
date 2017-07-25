package com.acv.components.infrastructure.domain.model;


import android.arch.lifecycle.LiveData;

import com.acv.components.domain.NetworkException;
import com.acv.components.domain.NetworkGatewayException;
import com.acv.components.domain.gateway.ComponentNetworkGateway;
import com.acv.components.infrastructure.ui.main.User;

public class ComponentRetrofit implements ComponentNetworkGateway {

    private ApiClient apiClient;
    private Mapper<RandomUserResult, RandomUser> mapper;


    @Override
    public LiveData<User> obtainUser(String id) throws NetworkException, NetworkGatewayException {
        return null;
    }
}
