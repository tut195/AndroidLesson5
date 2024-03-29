package com.babenkovladimir;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.babenkovladimir.base.BaseActivity;
import com.babenkovladimir.dialog.DialogActivity;
import com.babenkovladimir.fragments.FragmentsActivity;
import com.babenkovladimir.master_detail_flow.MasterDetailFlowActivity;
import com.babenkovladimir.preferences.PreferencesActivity;
import com.babenkovladimir.resource.ResourceActivity;

public class MainActivity extends BaseActivity {

  @BindView(R.id.btMasterDetailFlow)
  Button mMasterDetailFlowBt;
  @BindView(R.id.btFragments)
  Button mFragmentsBt;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ButterKnife.bind(this);

//    mMasterDetailFlowBt.setOnClickListener(view -> navigateMasterDetailsFlow());

    mFragmentsBt.setOnClickListener(view -> navigateFragments());
  }

  @OnClick(R.id.btMasterDetailFlow)
  public void navigateMasterDetailsFlow() {
    startActivity(new Intent(this, MasterDetailFlowActivity.class));
  }

  private void navigateFragments() {
    startActivity(new Intent(this, FragmentsActivity.class));
  }

  @OnClick(R.id.btDialog)
  public void navigateDialog() {
    startActivity(new Intent(this, DialogActivity.class));

  }

  @OnClick(R.id.btResources)
  public void navigateResources(){
    startActivity(new Intent(this, ResourceActivity.class));
  }

  @OnClick(R.id.btPrefs)
  public void navigatePrefsActivity(){
    startActivity(new Intent(this, PreferencesActivity.class));
  }
}
