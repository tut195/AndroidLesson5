package com.babenkovladimir.master_detail_flow;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.babenkovladimir.R;
import com.babenkovladimir.master_detail_flow.entity.BankCard;
import com.babenkovladimir.master_detail_flow.manager.BankCardManager;

public class BankCardAboutActivity extends AppCompatActivity {

  @BindView(R.id.tvOwnerName)
  TextView mOwnerNameTextView;

  @BindView(R.id.tvCardNumber)
  TextView mcardNumberTextView;

  @BindView(R.id.tvAmount)
  TextView mAmountTextView;

  @BindView(R.id.tvDate)
  TextView mDateTv;

  @BindView(R.id.tvPin)
  TextView mPinTextView;

  // Life

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_bank_card_about);

    ButterKnife.bind(this);

    Intent intent = getIntent();

    int position = intent.getIntExtra("position", 0);

    setupFields(position);
  }

  private void setupFields(int position) {
    BankCard bankCard = BankCardManager.getBankCardList().get(position);

    mOwnerNameTextView.setText(bankCard.getOwnerName());
    mcardNumberTextView.setText(bankCard.getNum());
  }
}
