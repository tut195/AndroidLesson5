package com.babenkovladimir.preferences;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.babenkovladimir.R;

public class PreferencesActivity extends AppCompatActivity {

  @BindView(R.id.btSaveToPrefs)
  Button mSaveToPrefsButton;

  @BindView(R.id.btReadFromPrefs)
  Button mloadFromPrefs;

  @BindView(R.id.etToPrefs)
  EditText mToPrefsEditText;

  @BindView(R.id.tvFromPrefs)
  TextView mFromPrefs;

  private static final String STRING_KEY = "string_key";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_preferences);

    ButterKnife.bind(this);

    AppPrefs appPrefs = AppPrefs.getInstance(this);

    mSaveToPrefsButton.setOnClickListener(view -> {
      appPrefs.setString(STRING_KEY, mToPrefsEditText.getText().toString());
    });

    mloadFromPrefs.setOnClickListener(view -> {
      String fromPrefs = appPrefs.getString(STRING_KEY);
      mFromPrefs.setText(fromPrefs);

    });
  }
}
