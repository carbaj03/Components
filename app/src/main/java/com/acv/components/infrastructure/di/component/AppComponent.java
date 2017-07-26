package com.acv.components.infrastructure.di.component;

import android.app.Application;

import com.acv.components.infrastructure.ComponentApp;
import com.acv.components.infrastructure.di.module.AppModule;
import com.acv.components.infrastructure.di.module.DataModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class, AppModule.class, DataModule.class
})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }

    void inject(ComponentApp app);
}
