package com.acv.components.infrastructure.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.View;

import com.acv.components.R;
import com.acv.components.domain.model.Id;

import javax.inject.Inject;

public class Navigator {

    @Inject
    public Navigator() {
    }

    public void navigateToDetail(@NonNull Activity context, View view, String id) {
//        Intent callingIntent = DetailActivity.getCallingIntent(context, id);
//
//        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(context,
//                Pair.create(view.findViewById(R.id.ivPicture),
//                        context.getString(R.string.transition_name_circle)),
//                Pair.create(view.findViewById(R.id.tvName),
//                        context.getString(R.string.transition_name_name))
//        );
//        ActivityCompat.startActivity(context, callingIntent, options.toBundle());
    }
    
}
