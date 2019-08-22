package com.babenkovladimir.dialog.edit_name_dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.babenkovladimir.R;

public class EditNameDialogFragment extends DialogFragment implements OnEditorActionListener {

  // 1. Defines the listener interface with a method passing back data result.
  public interface EditNameDialogListener {

    void onFinishEditDialog(String inputText);
  }

  public interface MyDialogInterace {

    void doSomeWork(String nameData);
  }

  private EditText mEditText;
  private MyDialogInterace myDialogInterace;

  // Public constructor

  public EditNameDialogFragment() {
    // Empty constructor is required for DialogFragment
    // Make sure not to add arguments to the constructor
    // Use `newInstance` instead as shown below
  }

  // Static instance

  public static EditNameDialogFragment newInstance(String title, MyDialogInterace myDialogInterace) {
    myDialogInterace = myDialogInterace;
    EditNameDialogFragment frag = new EditNameDialogFragment();
    frag.myDialogInterace = myDialogInterace;
    Bundle args = new Bundle();
    args.putString("title", title);
    frag.setArguments(args);
    return frag;
  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_edit_name, container);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    // Get field from view
    mEditText = (EditText) view.findViewById(R.id.txt_your_name);

    mEditText.setOnEditorActionListener(this);

    // Fetch arguments from bundle and set title
    String title = getArguments().getString("title", "Enter Name");
    getDialog().setTitle(title);
    // Show soft keyboard automatically and request focus to field
    mEditText.requestFocus();
    getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
  }

  // Listener

  // Fires whenever the textfield has an action performed
  // In this case, when the "Done" button is pressed
  // REQUIRES a 'soft keyboard' (virtual keyboard)

  /**
   * Именно тут -  EditNameDialogListener listener = (EditNameDialogListener) getActivity(); вызывается getActivity!
   */
  @Override
  public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
    if (EditorInfo.IME_ACTION_DONE == actionId) {
      // Return input text back to activity through the implemented listener
      EditNameDialogListener listener = (EditNameDialogListener) getActivity();
      listener.onFinishEditDialog(mEditText.getText().toString());
      // Close the dialog and return back to the parent activity
      myDialogInterace.doSomeWork(mEditText.getText().toString());
      dismiss();
      return true;
    }
    return false;
  }

  @Override
  public void onResume() {
    int width = getResources().getDimensionPixelSize(R.dimen.popup_width);
    int height = getResources().getDimensionPixelSize(R.dimen.popup_height);
    getDialog().getWindow().setLayout(width, height);
    // Call super onResume after sizing
    super.onResume();
  }
}
