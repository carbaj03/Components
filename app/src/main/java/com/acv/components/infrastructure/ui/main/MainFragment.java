package com.acv.components.infrastructure.ui.main;


import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.acv.components.R;
import com.acv.components.infrastructure.di.Injectable;
import com.acv.components.infrastructure.ui.Navigator;
import com.acv.components.infrastructure.ui.common.DividerStickyDecoration;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainFragment extends LifecycleFragment implements Injectable {
    public static final String TAG = MainFragment.class.getSimpleName();
    private static final String UID_KEY = "uid";

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    @Inject
    protected Navigator navigator;

    @BindView(R.id.rvUsers)
    RecyclerView rvUsers;

    private UserViewModel viewModel;
    private UserAdapter adapter;

    public static MainFragment create(String id) {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        args.putString(UID_KEY, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String userId = getArguments().getString(UID_KEY);

        final DividerStickyDecoration divider = new DividerStickyDecoration(
                ContextCompat.getColor(getContext(), R.color.colorPrimary), 1);
        adapter = new UserAdapter();
        adapter.setListener((view, position) -> {
            navigator.navigateToDetail(getActivity(), view, adapter.getItem(position).getId());
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rvUsers.addItemDecoration(divider);
        rvUsers.setAdapter(adapter);
        rvUsers.setLayoutManager(linearLayoutManager);
        rvUsers.setHasFixedSize(true);

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(UserViewModel.class);
        viewModel.init(userId);
        viewModel.getUser().observe(this, user -> adapter.set(user));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, inflate);
        return inflate;
    }
}