package ru.startandroid.develop.dialogfragmentexample;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class SecondDialog extends DialogFragment implements DialogInterface.OnClickListener {

    final String LOG_TAG = "myLogs";

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder adb = new AlertDialog.Builder(getActivity())
                .setTitle("Second title!")
                .setPositiveButton(R.string.yes, this)
                .setNegativeButton(R.string.no, this)
                .setNeutralButton(R.string.maybe, this)
                .setMessage(R.string.message_text);

        return adb.create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        int i = 0;
        switch (which) {
            case Dialog.BUTTON_POSITIVE:
                i = R.string.yes;
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                i = R.string.no;
                break;
            case Dialog.BUTTON_NEUTRAL:
                i = R.string.maybe;
                break;
        }
        if(i > 0)
            Log.d(LOG_TAG, "Dialog 2: " + getResources().getString(i));
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);
        Log.d(LOG_TAG, "Dialog 2: onDismiss");
    }

    @Override
    public void onCancel(@NonNull DialogInterface dialog) {
        super.onCancel(dialog);
        Log.d(LOG_TAG, "Dialog 2: onCancel");
    }
}
