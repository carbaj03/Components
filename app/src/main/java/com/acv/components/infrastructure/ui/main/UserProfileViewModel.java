package com.acv.components.infrastructure.ui.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

public class UserProfileViewModel extends ViewModel {
    private String userId;
    private LiveData<User> user;

    public void init(String userId) {
        this.userId = userId;
    }

    public LiveData<User> getUser() {
        return user;
    }
}