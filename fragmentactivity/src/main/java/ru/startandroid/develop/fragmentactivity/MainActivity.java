package ru.startandroid.develop.fragmentactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;

import android.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Fragment2.onMyEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment2 frag2 = new Fragment2();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.fragment_container, frag2);
        ft.commit();
    }

    public void onClick(View view) {
        /*Fragment frag1 = getFragmentManager().findFragmentById(R.id.frag1);
        ((TextView)frag1.getView().findViewById(R.id.tv)).setText("Access to Fragment 1 from MainActivity");

        Fragment frag2 = getFragmentManager().findFragmentById(R.id.fragment_container);
        ((TextView)frag2.getView().findViewById(R.id.tv2)).setText("Access to Fragment 2 from MainActivity");*/
    }

    @Override
    public void myEvent(String s) {
        Fragment frag1 = getFragmentManager().findFragmentById(R.id.frag1);
        ((TextView)frag1.getView().findViewById(R.id.tv)).setText("Text from Fragment 2: " + s);
    }
}