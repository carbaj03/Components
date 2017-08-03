package com.acv.components.infrastructure.ui.mapper;


import com.acv.components.domain.model.User;
import com.acv.components.infrastructure.domain.mapper.Mapper;
import com.acv.components.infrastructure.ui.main.model.UserItemModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserViewMapper implements Mapper<User, UserItemModel> {
    @Inject
    public UserViewMapper() {
    }

    public List<UserItemModel> map(List<User> randomUsers) {
        if (randomUsers == null)
            return new ArrayList<>();

        List<UserItemModel> modelViews = new ArrayList<>();
        for (User randomUser : randomUsers) {
            modelViews.add(map(randomUser));
        }
        return modelViews;
    }

    @Override
    public UserItemModel map(User user) {
        if (user == null) {
            return null;
        }
        return new UserItemModel(
                user.getId().getValue(),
                user.getFullname(),
                user.getEmail(),
                user.getThumbPicture(),
                user.getPhone()
        );
    }
}
