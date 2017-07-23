package com.acv.components.infrastructure.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.acv.components.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showUser();
    }

    private void showUser() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, MainFragment.newInstance("1"), MainFragment.TAG).commit();
    }
}
