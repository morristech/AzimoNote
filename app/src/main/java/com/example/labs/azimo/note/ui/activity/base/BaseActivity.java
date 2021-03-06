package com.example.labs.azimo.note.ui.activity.base;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.labs.azimo.note.R;
import com.example.labs.azimo.note.ui.dialog.CustomProgressDialog;
import com.example.labs.azimo.note.ui.dialog.MessageDialog;

import dagger.android.AndroidInjection;

/**
 * Created by F1sherKK on 24/07/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
    }

    public void showMessageDialog(String message) {
        MessageDialog dialog = MessageDialog.newInstance(message);
        dialog.show(getFragmentManager(), MessageDialog.TAG);
    }

    public void showLoadingDialog() {
        String message = getString(R.string.progress_dialog_message);
        CustomProgressDialog dialog = CustomProgressDialog.newInstance(message);
        dialog.show(getFragmentManager(), CustomProgressDialog.TAG);

    }

    public void hideLoadingDialog() {
        dismissDialogByTag(CustomProgressDialog.TAG);
    }

    private void dismissDialogByTag(String tag) {
        DialogFragment progressDialogFragment = (DialogFragment) getFragmentManager().findFragmentByTag(tag);
        if (progressDialogFragment != null) {
            progressDialogFragment.dismissAllowingStateLoss();
        }
    }

}
