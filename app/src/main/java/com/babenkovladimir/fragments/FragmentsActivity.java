package com.babenkovladimir.fragments;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.babenkovladimir.R;

public class FragmentsActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_fragments);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.btShowFragment)
  public void showFragment() {
    FragmentOne fragmentOne = FragmentOne.getInstance(new Bundle());

    FragmentManager supportFragmentManager = getSupportFragmentManager();

    supportFragmentManager
        .beginTransaction()
        .add(R.id.container, fragmentOne)
        .addToBackStack("One")
        .commit();
  }

  @OnClick(R.id.btShowSecondFragment)
  public void showSecond() {

    getSupportFragmentManager()
        .beginTransaction()
        .add(R.id.container, FragmentTwo.getInstance())
        .addToBackStack("seccond")
        .commit();
  }

  @Override
  public void onBackPressed() {

    int count = getSupportFragmentManager().getBackStackEntryCount();

    if (count > 0) {
      //getSupportFragmentManager().;
    }
    super.onBackPressed();
  }
}
