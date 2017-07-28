package com.acv.components.infrastructure.di.module;


import com.acv.components.BuildConfig;
import com.acv.components.domain.model.Id;
import com.acv.components.domain.model.Location;
import com.acv.components.domain.model.Login;
import com.acv.components.domain.model.Name;
import com.acv.components.domain.model.Picture;
import com.acv.components.domain.model.User;
import com.acv.components.infrastructure.domain.mapper.Mapper;
import com.acv.components.infrastructure.persistence.retrofit.ComponentRetrofit;
import com.acv.components.infrastructure.persistence.retrofit.UserResult;
import com.acv.components.infrastructure.persistence.retrofit.ApiClient;
import com.acv.components.infrastructure.persistence.retrofit.mapper.IdMapper;
import com.acv.components.infrastructure.persistence.retrofit.mapper.LocationMapper;
import com.acv.components.infrastructure.persistence.retrofit.mapper.LoginMapper;
import com.acv.components.infrastructure.persistence.retrofit.mapper.NameMapper;
import com.acv.components.infrastructure.persistence.retrofit.mapper.PictureMapper;
import com.acv.components.infrastructure.persistence.retrofit.mapper.UserMapper;
import com.acv.components.infrastructure.persistence.retrofit.model.IdDataModel;
import com.acv.components.infrastructure.persistence.retrofit.model.LocationDataModel;
import com.acv.components.infrastructure.persistence.retrofit.model.LoginDataModel;
import com.acv.components.infrastructure.persistence.retrofit.model.NameDataModel;
import com.acv.components.infrastructure.persistence.retrofit.model.PictureDataModel;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = ViewModelModule.class)
class DataModule {
    @Provides
    @Singleton
    public ComponentRetrofit provideRandomUserGateway(
            ApiClient apiClient,
            Mapper<UserResult, User> mapper
    ) {
        return new ComponentRetrofit(apiClient, mapper);
    }

    @Provides
    @Singleton
    @Named("EndPoint")
    public String provideEndPoint() {
        return BuildConfig.API_URL;
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(
            @Named("EndPoint") String endPoint,
            OkHttpClient okHttpClient
    ) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(endPoint)
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    public HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
        logging.setLevel(level);
        return logging;
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(final HttpLoggingInterceptor loggingInterceptor) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(loggingInterceptor);
        return builder.build();
    }

    @Provides
    @Singleton
    public ApiClient provideApiClient(Retrofit retrofit) {
        return retrofit.create(ApiClient.class);
    }


    @Provides
    @Singleton
    Mapper<UserResult, User> provideUserMapper(
            Mapper<LocationDataModel, Location> locationMapper,
            Mapper<NameDataModel, Name> nameMapper,
            Mapper<PictureDataModel, Picture> pictureMapper,
            Mapper<LoginDataModel, Login> loginMapper,
            Mapper<IdDataModel, Id> idMapper
    ) {
        return new UserMapper(nameMapper, locationMapper, pictureMapper, loginMapper, idMapper);
    }

    @Provides
    @Singleton
    Mapper<LocationDataModel, Location> provideLocationMapper() {
        return new LocationMapper();
    }

    @Provides
    @Singleton
    Mapper<NameDataModel, Name> provideNameMapper() {
        return new NameMapper();
    }

    @Provides
    @Singleton
    Mapper<PictureDataModel, Picture> providePictureMapper() {
        return new PictureMapper();
    }

    @Provides
    @Singleton
    Mapper<IdDataModel, Id> provideIdMapper() {
        return new IdMapper();
    }

    @Provides
    @Singleton
    Mapper<LoginDataModel, Login> provideLoginMapper() {
        return new LoginMapper();
    }
}
