package com.acv.components.domain.gateway;


import android.arch.lifecycle.LiveData;

import com.acv.components.domain.NetworkException;
import com.acv.components.domain.NetworkGatewayException;
import com.acv.components.infrastructure.ui.main.User;

public interface ComponentNetworkGateway {
    LiveData<User> obtainUser(String id) throws NetworkException, NetworkGatewayException;
}
