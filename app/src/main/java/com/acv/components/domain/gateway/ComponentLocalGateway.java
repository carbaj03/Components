package com.acv.components.domain.gateway;


import android.arch.lifecycle.LiveData;

import com.acv.components.domain.LocalGatewayException;
import com.acv.components.domain.model.User;

public interface ComponentLocalGateway {
    LiveData<User> obtainUser(String id) throws LocalGatewayException;
}