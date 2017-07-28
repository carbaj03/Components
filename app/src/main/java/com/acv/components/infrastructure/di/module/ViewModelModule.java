package com.acv.components.infrastructure.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.acv.components.infrastructure.ui.main.ComponentViewModelFactory;
import com.acv.components.infrastructure.ui.main.UserViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel.class)
    abstract ViewModel bindUserViewModel(UserViewModel userViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ComponentViewModelFactory factory);
}
