package com.babenkovladimir.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.babenkovladimir.R;
import com.babenkovladimir.base.BaseActivity;
import com.babenkovladimir.dialog.alert_dialog.MyAlertDialogFragment;
import com.babenkovladimir.dialog.edit_name_dialog.EditNameDialogFragment;
import com.babenkovladimir.dialog.edit_name_dialog.EditNameDialogFragment.EditNameDialogListener;
import com.babenkovladimir.dialog.edit_name_dialog.EditNameDialogFragment.MyDialogInterace;

public class DialogActivity extends BaseActivity implements EditNameDialogListener {

  @BindView(R.id.btShowEditTextDialog)
  Button mBtShowDialog;

  @BindView(R.id.btShowAlertDialog)
  Button mBtShowAlertDialog;

  private Context context = this;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dialog);

    ButterKnife.bind(this);

    setupUI();
  }

  // Private

  private void setupUI() {
    mBtShowDialog.setOnClickListener(view -> showEditNameDialog());

    mBtShowAlertDialog.setOnClickListener(view -> showAlertDialog());

  }

  private void showEditNameDialog() {
    FragmentManager fm = getSupportFragmentManager();
    EditNameDialogFragment editNameDialogFragment = EditNameDialogFragment.newInstance("Some Title", new MyDialogInterace() {
      @Override
      public void doSomeWork(String nameData) {
        // TODO change user name in database
        Log.d("SKILLUP", "name from dialog inteface - " + nameData);
      }
    });
    editNameDialogFragment.show(fm, "fragment_edit_name");
  }

  private void showAlertDialog() {
    FragmentManager fm = getSupportFragmentManager();
    MyAlertDialogFragment alertDialog = MyAlertDialogFragment.newInstance("Some title");
    alertDialog.show(fm, "fragment_alert");
  }

  @OnClick(R.id.btShowSimpleAlertDialog)
  public void showSimpleAlertDialog() {
    AlertDialog.Builder builder = new AlertDialog.Builder(this)
        // .setIcon(R.drawable.ic_kiwi)
        //.setTitle("This is Title")
        .setMessage("Kiwi message")
        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
          }
        })
//        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//          @Override
//          public void onClick(DialogInterface dialogInterface, int i) {
//
//          }
//        })
        .setCancelable(false)
//        .setAdapter()

        .setOnDismissListener(new OnDismissListener() {
          @Override
          public void onDismiss(DialogInterface dialogInterface) {
            Toast.makeText(context, "Dialog is canceled", Toast.LENGTH_SHORT).show();
          }
        });

    Dialog dialogh = builder.create();
    dialogh.show();


  }

  /**
   * Этот метод вызывается посредсвом обращения к активити из фрагмента, когда фрагмент вызвает метод getActivity() и кастит его к интерфейсу EditNameDialogListener
   */

  @Override
  public void onFinishEditDialog(String inputText) {
    showToast(inputText);
  }
}