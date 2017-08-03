package com.acv.components.infrastructure.ui.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.acv.components.domain.NetworkGatewayException;
import com.acv.components.infrastructure.persistence.retrofit.ComponentRetrofit;
import com.acv.components.infrastructure.ui.main.model.UserItemModel;
import com.acv.components.infrastructure.ui.mapper.UserViewMapper;

import java.util.List;

import javax.inject.Inject;

public class UserViewModel extends ViewModel {
    private MutableLiveData<List<UserItemModel>> user;
    private ComponentRetrofit repo;
    private UserViewMapper mapper;

    @Inject
    public UserViewModel(ComponentRetrofit repo, UserViewMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public void init(String userId) {
        if (this.user != null) {
            // ViewModel is created per Fragment so
            // we know the userId won't change
            return;
        }
        user = new MutableLiveData<>();
        try {
            user.setValue(mapper.map(repo.obtainUser(userId).getValue()));
        } catch (NetworkGatewayException e) {
            e.printStackTrace();
        }
    }

    public LiveData<List<UserItemModel>> getUser() {
        return user;
    }
}