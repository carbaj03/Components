package com.acv.components.infrastructure.ui;

import android.widget.ImageView;

import com.acv.components.R;
import com.bumptech.glide.RequestManager;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class GlideLoader implements ImageLoader {
    private RequestManager glide;

    @Inject
    public GlideLoader(RequestManager glide) {
        this.glide = glide;
    }

    @Override
    public void load(String url, ImageView view) {
        glide.load(url).into(view);
    }

    @Override
    public void loadCircle(String url, ImageView view) {
        glide.load(url).error(R.drawable.circle).transform(new CircleTransform(view.getContext())).into(view);
    }
}
