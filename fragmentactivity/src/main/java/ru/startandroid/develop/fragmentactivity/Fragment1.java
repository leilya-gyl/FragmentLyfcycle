package ru.startandroid.develop.fragmentactivity;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;

public class Fragment1 extends Fragment {

    final String LOG_TAG = "myLogs";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment1, null);
        Button btn = v.findViewById(R.id.btn);
        btn.setOnClickListener(v1 -> Log.d(LOG_TAG, "Button click in Fragment1"));
        return v;
    }
}
