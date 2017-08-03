package com.acv.components.infrastructure.ui.main;

import android.view.ViewGroup;

import com.acv.components.R;
import com.acv.components.infrastructure.ui.common.BaseAdapterList;
import com.acv.components.infrastructure.ui.common.BaseListViewHolder;
import com.acv.components.infrastructure.ui.main.model.UserItemModel;

import java.util.List;

class UserAdapter extends BaseAdapterList<UserItemModel> {

    @Override
    public UserItemModel getItem(int position) {
        return data.get(position);
    }

    @Override
    public List<UserItemModel> getItems() {
        return data;
    }

    @Override
    public void set(List<UserItemModel> randomUsers) {
        validateCollection(randomUsers);
        data = randomUsers;
        notifyDataSetChanged();
    }

    @Override
    public BaseListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserViewHolder(inflate(parent, viewType), itemClickListener);
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.item_random_user;
    }

    @Override
    public void onBindViewHolder(BaseListViewHolder holder, int position) {
        holder.render(data.get(position));
    }
}
