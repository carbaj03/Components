package com.acv.components.infrastructure.ui.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.acv.components.R;
import com.acv.components.infrastructure.ui.ImageLoader;
import com.acv.components.infrastructure.ui.common.BaseListViewHolder;
import com.acv.components.infrastructure.ui.common.ItemClickListener;
import com.acv.components.infrastructure.ui.main.model.UserItemModel;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserViewHolder extends BaseListViewHolder<UserItemModel> {

    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvEmail)
    TextView tvEmail;
    @BindView(R.id.tvPhone)
    TextView tvPhone;
    @BindView(R.id.ivPicture)
    ImageView ivPicture;

    @Inject
    protected ImageLoader loader;

    public UserViewHolder(View itemView, ItemClickListener itemClickListener) {
        super(itemView, itemClickListener);
        ButterKnife.bind(this, itemView);
//        RandomUserApp.appComponent.plus(new HolderModule()).inject(this);
    }

    @Override
    public void render(UserItemModel randomUser) {
        loader.loadCircle(randomUser.getPicture(), ivPicture);
        tvName.setText(randomUser.getFullName());
        tvEmail.setText(randomUser.getEmail());
        tvPhone.setText(randomUser.getPhone());
    }
}