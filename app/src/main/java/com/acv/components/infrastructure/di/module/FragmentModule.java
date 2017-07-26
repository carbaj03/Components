package com.acv.components.infrastructure.di.module;


import android.support.v4.app.Fragment;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {

    protected final Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    public Fragment provideFragment() {
        return this.fragment;
    }
}
