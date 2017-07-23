package com.acv.components.infrastructure;


import android.app.Application;

import com.acv.components.infrastructure.di.component.AppComponent;
import com.acv.components.infrastructure.di.component.DaggerAppComponent;
import com.acv.components.infrastructure.di.module.AppModule;

public class ComponentApp extends Application{

    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = initializeDagger();
    }

    private AppComponent initializeDagger() {
        return DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public void setAppComponent(AppComponent appComponent) {
        ComponentApp.appComponent = appComponent;
    }

}
