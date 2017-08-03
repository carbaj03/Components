package com.acv.components.infrastructure.ui;

import android.widget.ImageView;

public interface ImageLoader {
    void load(String url, ImageView view);
    void loadCircle(String url, ImageView view);
}
