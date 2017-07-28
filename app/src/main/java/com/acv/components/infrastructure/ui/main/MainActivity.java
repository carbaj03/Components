package com.acv.components.infrastructure.ui.main;

import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.acv.components.R;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity
        extends AppCompatActivity
        implements LifecycleRegistryOwner, HasSupportFragmentInjector {
    private final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showUser();
    }

    private void showUser() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, MainFragment.create("1"), MainFragment.TAG).commit();
    }

    @Override
    public LifecycleRegistry getLifecycle() {
        return lifecycleRegistry;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}
