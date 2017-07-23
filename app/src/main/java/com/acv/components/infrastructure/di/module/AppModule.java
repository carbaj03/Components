package com.acv.components.infrastructure.di.module;


import android.content.Context;

import com.acv.components.infrastructure.ComponentApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final ComponentApp application;

    public AppModule(ComponentApp application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return this.application.getApplicationContext();
    }
}
