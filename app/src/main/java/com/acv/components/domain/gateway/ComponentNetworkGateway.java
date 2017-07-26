package com.acv.components.domain.gateway;


import android.arch.lifecycle.LiveData;

import com.acv.components.domain.NetworkException;
import com.acv.components.domain.NetworkGatewayException;
import com.acv.components.domain.model.User;

import java.util.List;

public interface ComponentNetworkGateway {
    LiveData<List<User>> obtainUser(String id) throws NetworkException, NetworkGatewayException;
}
