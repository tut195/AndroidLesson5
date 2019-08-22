package com.babenkovladimir.dialog.alert_dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;


public class MyAlertDialogFragment extends DialogFragment {

  public MyAlertDialogFragment() {
    // Empty constructor required for DialogFragment
  }

  public static MyAlertDialogFragment newInstance(String title) {
    MyAlertDialogFragment frag = new MyAlertDialogFragment();
    Bundle args = new Bundle();
    args.putString("title", title);
    frag.setArguments(args);
    return frag;
  }

  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    String title = getArguments().getString("title");
    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
    alertDialogBuilder.setTitle(title);
    alertDialogBuilder.setMessage("Are you sure?");
    alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        // on success
      }
    });
    alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        if (dialog != null) {
          dialog.dismiss();
        }
      }
    });

    return alertDialogBuilder.create();
  }
}
