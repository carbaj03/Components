package com.acv.components.infrastructure.ui.main;


import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.acv.components.R;
import com.acv.components.infrastructure.ComponentApp;
import com.acv.components.infrastructure.di.module.MainModule;

import butterknife.BindView;

public class MainFragment extends LifecycleFragment {

    public static final String TAG = MainFragment.class.getSimpleName();
    private static final String UID_KEY = "uid";
    private UserViewModel viewModel;

    @BindView(R.id.tvMain)
    TextView tvMain;

    public static MainFragment newInstance(String id) {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        args.putString(UID_KEY, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ComponentApp.appComponent.plus(new MainModule(this)).inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String userId = getArguments().getString(UID_KEY);

        viewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        viewModel.init(userId);
        viewModel.getUser().observe(this, user -> tvMain.setText(user.get(0).getEmail()));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}