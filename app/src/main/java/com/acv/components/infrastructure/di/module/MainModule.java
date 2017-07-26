package com.acv.components.infrastructure.di.module;


import com.acv.components.infrastructure.ui.main.MainFragment;

import dagger.Module;

@Module
public class MainModule extends FragmentModule {
    public MainModule(MainFragment fragment) {
        super(fragment);
    }

}
