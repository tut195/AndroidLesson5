package com.babenkovladimir.master_detail_flow;

import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.babenkovladimir.R;
import com.babenkovladimir.base.BaseActivity;
import com.babenkovladimir.master_detail_flow.manager.BankCardManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MasterDetailFlowActivity extends BaseActivity {

  @BindView(R.id.recycler)
  RecyclerView mRecycler;

  @BindView(R.id.btAddBankCard)
  FloatingActionButton btAddCard;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_master_detail_flow);

    ButterKnife.bind(this);

    setupRecycler();

  }

  @OnClick(R.id.btAddBankCard)
  public void openAddCardActivity() {
    startActivity(new Intent(this, AddCardActivity.class));
  }

  private void setupRecycler() {
    MyRecyclerAdapter recyclerAdapter = new MyRecyclerAdapter();

    recyclerAdapter.setOnCardItemClick(new OnCardItemClick() {
      @Override
      public void onCardClick(int position) {
//        showToast(name);
        showAboutActivity(position);
      }
    });

    LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

    mRecycler.setLayoutManager(layoutManager);
    mRecycler.setAdapter(recyclerAdapter);

    BankCardManager.initBankCardList();
    recyclerAdapter.setCards(BankCardManager.getBankCardList());
  }

  private void showAboutActivity(int position) {
    Intent aboutIntent = new Intent(this, BankCardAboutActivity.class);
    aboutIntent.putExtra("position", position);

    startActivity(aboutIntent);
  }
}
