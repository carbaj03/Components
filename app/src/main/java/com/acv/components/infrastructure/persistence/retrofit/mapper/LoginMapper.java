package com.acv.components.infrastructure.persistence.retrofit.mapper;


import com.acv.components.domain.model.Login;
import com.acv.components.infrastructure.domain.mapper.Mapper;
import com.acv.components.infrastructure.persistence.retrofit.model.LoginDataModel;

public class LoginMapper implements Mapper<LoginDataModel, Login> {
    @Override
    public Login map(LoginDataModel loginDataModel) {
        if (loginDataModel == null) {
            return null;
        }

        return new Login(
                loginDataModel.getUsername(),
                loginDataModel.getPassword(),
                loginDataModel.getSalt(),
                loginDataModel.getMd5(),
                loginDataModel.getSha1(),
                loginDataModel.getSha256()
        );
    }
}
