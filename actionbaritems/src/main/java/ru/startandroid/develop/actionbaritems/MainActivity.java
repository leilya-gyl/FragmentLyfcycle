package ru.startandroid.develop.actionbaritems;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBar.Tab;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {

    final  String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        Tab tab = actionBar.newTab();
        tab.setText("tab1");
        tab.setTabListener(this);
        actionBar.addTab(tab);

        tab = actionBar.newTab();
        tab.setText("tab2");
        tab.setTabListener(this);
        actionBar.addTab(tab);

        //getSupportActionBar().setDisplayShowTitleEnabled(false); // убирает название с ActionBar
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        Log.d(LOG_TAG, "selected tab: "+ tab.getText());
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        Log.d(LOG_TAG, "unselected tab: "+ tab.getText());
    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
        Log.d(LOG_TAG, "reselected tab: "+ tab.getText());
    }
}