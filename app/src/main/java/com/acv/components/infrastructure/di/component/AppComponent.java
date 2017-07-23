package com.acv.components.infrastructure.di.component;

import com.acv.components.infrastructure.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class,
})
public interface AppComponent {

}
