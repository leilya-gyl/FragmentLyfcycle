package ru.startandroid.develop.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetailsFragment extends Fragment {

    public static DetailsFragment newInstance(int pos) {
        DetailsFragment detailsFragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putInt("position", pos);
        detailsFragment.setArguments(args);
        return detailsFragment;
    }

    int getPosition() {
        return getArguments().getInt("position", 0);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.details, null);
        TextView tv = v.findViewById(R.id.tvText);
        tv.setText(getResources().getStringArray(R.array.content)[getPosition()]);
        return v;
    }
}
