package ru.startandroid.develop.myapplication;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

public class DetailsActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        Если горизонтальная ориентация и большой экран
         */
        if(getResources().getConfiguration().orientation
               == Configuration.ORIENTATION_LANDSCAPE && isLarge()){
            finish();
            return;
        }
        if(savedInstanceState == null) {
            DetailsFragment detailsFragment =
                    DetailsFragment.newInstance(getIntent()
                            .getIntExtra("position", 0));
            getSupportFragmentManager().beginTransaction()
                    .add(android.R.id.content, detailsFragment).commit();
        }
    }

    /**
     * МЕтод определяет, большой экран или нет.
     * @return
     */
    boolean isLarge() {
        return (getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK )
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }
}
