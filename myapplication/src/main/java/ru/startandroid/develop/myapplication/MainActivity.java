package ru.startandroid.develop.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends FragmentActivity implements TitleFragment.onItemClickListener {

    int position = 0;
    boolean withDetails = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null)
            position = savedInstanceState.getInt("position");
        withDetails = (findViewById(R.id.cont) != null);
        if(withDetails)
            showDetails(position);
    }

    @Override
    public void itemClick(int position) {
        this.position = position;
        showDetails(position);
    }

    void showDetails(int position) {
        if(withDetails) {
            DetailsFragment details = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.cont);
            if (details == null || details.getPosition() != position) {
                details = DetailsFragment.newInstance(position);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.cont, details).commit();
            }
        } else {
            startActivity(new Intent(this, DetailsActivity.class));
        }

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("position", position);
    }
}
