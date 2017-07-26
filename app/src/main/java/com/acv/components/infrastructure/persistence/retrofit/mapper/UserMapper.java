package com.acv.components.infrastructure.persistence.retrofit.mapper;


import com.acv.components.domain.model.Id;
import com.acv.components.domain.model.Location;
import com.acv.components.domain.model.Login;
import com.acv.components.domain.model.Name;
import com.acv.components.domain.model.Picture;
import com.acv.components.domain.model.User;
import com.acv.components.infrastructure.domain.mapper.Mapper;
import com.acv.components.infrastructure.persistence.retrofit.UserResult;
import com.acv.components.infrastructure.persistence.retrofit.model.IdDataModel;
import com.acv.components.infrastructure.persistence.retrofit.model.LocationDataModel;
import com.acv.components.infrastructure.persistence.retrofit.model.LoginDataModel;
import com.acv.components.infrastructure.persistence.retrofit.model.NameDataModel;
import com.acv.components.infrastructure.persistence.retrofit.model.PictureDataModel;

public class UserMapper implements Mapper<UserResult, User> {
    private final Mapper<NameDataModel, Name> nameMapper;
    private final Mapper<LocationDataModel, Location> locationMapper;
    private final Mapper<PictureDataModel, Picture> pictureMapper;
    private final Mapper<LoginDataModel, Login> loginMapper;
    private final Mapper<IdDataModel, Id> idMapper;

    public UserMapper(
            Mapper<NameDataModel, Name> nameMapper,
            Mapper<LocationDataModel, Location> locationMapper,
            Mapper<PictureDataModel, Picture> pictureMapper,
            Mapper<LoginDataModel, Login> loginMapper,
            Mapper<IdDataModel, Id> idMapper
    ) {
        this.nameMapper = nameMapper;
        this.locationMapper = locationMapper;
        this.pictureMapper = pictureMapper;
        this.loginMapper = loginMapper;
        this.idMapper = idMapper;
    }

    @Override
    public User map(UserResult user) {
        if (user == null) {
            return null;
        }
        User randomUser = new User(
                user.getGender(),
                nameMapper.map(user.getName()),
                locationMapper.map(user.getLocation()),
                user.getEmail(),
                loginMapper.map(user.getLogin()),
                user.getDob(),
                user.getRegistered(),
                user.getPhone(),
                user.getCell(),
                idMapper.map(user.getId()),
                pictureMapper.map(user.getPicture()),
                user.getNat()
        );

        return randomUser;
    }
}
