package com.acv.components.infrastructure.ui.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.acv.components.domain.NetworkGatewayException;
import com.acv.components.domain.model.User;
import com.acv.components.infrastructure.persistence.retrofit.ComponentRetrofit;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

public class UserViewModel extends ViewModel {
    private LiveData<List<User>> user;
    private ComponentRetrofit repo;

    @Inject
    public UserViewModel(ComponentRetrofit repo) {
        this.repo = repo;
    }

    public void init(String userId) {
        if (this.user != null) {
            // ViewModel is created per Fragment so
            // we know the userId won't change
            return;
        }
        try {
            user = repo.obtainUser(userId);
        } catch (NetworkGatewayException e) {
            e.printStackTrace();
        }
    }

    public LiveData<List<User>> getUser() {
        return user;
    }
}