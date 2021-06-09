package ru.startandroid.develop.fragmentactivity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;

public class Fragment2 extends Fragment {

    public interface onMyEventListener {
        public void myEvent(String s);
    }

    onMyEventListener myEventListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            myEventListener = (onMyEventListener) activity;
        } catch (ClassCastException e ){
            throw new ClassCastException(activity.toString() + " must implemented onMyEventListener ");
        }
    }

    final String LOG_TAG = "myLogs";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment2, null);

        Button btn = v.findViewById(R.id.btn2);
        btn.setOnClickListener(v1 -> myEventListener.myEvent("Test text to Fragment 1"));
        return v;
    }
}
