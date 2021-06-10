package ru.startandroid.develop.dialogfragmentexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    DialogFragment item1, item2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        item1 = new FirstDialog();
        item2 = new SecondDialog();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnDlg1:
                item1.show(getSupportFragmentManager(), "dlg1");
                break;
            case R.id.btnDlg2:
                item2.show(getSupportFragmentManager(), "dlg2");
                break;
            default:
                break;
        }
    }
}