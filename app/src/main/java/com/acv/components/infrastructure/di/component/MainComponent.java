package com.acv.components.infrastructure.di.component;


import com.acv.components.infrastructure.di.module.MainModule;
import com.acv.components.infrastructure.di.scope.ActivityScope;
import com.acv.components.infrastructure.ui.main.MainFragment;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {MainModule.class})
public interface MainComponent {
    void inject(MainFragment fragment);

}
