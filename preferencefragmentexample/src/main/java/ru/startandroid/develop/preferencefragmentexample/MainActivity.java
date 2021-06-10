package ru.startandroid.develop.preferencefragmentexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

import java.util.List;

public class MainActivity extends PreferenceActivity {

    @Override
    public void onBuildHeaders(List<Header> target) {
        loadHeadersFromResource(R.xml.pref_head1, target);
    }

    @Override
    protected boolean isValidFragment (String fragmentName) {
        return PrefFragment1.class.getName().equals(fragmentName) ||
                PrefFragment2.class.getName().equals(fragmentName);
    }

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new PrefFragment1()).commit();
    }*/
}
