package com.babenkovladimir.master_detail_flow;

import android.os.Bundle;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.babenkovladimir.R;
import com.babenkovladimir.base.BaseActivity;
import com.babenkovladimir.master_detail_flow.entity.BankCard;
import com.babenkovladimir.master_detail_flow.manager.BankCardManager;

public class AddCardActivity extends BaseActivity {

  @BindView(R.id.etOwnerName)
  TextView mOwnerNameEditText;

  @BindView(R.id.etCardNumber)
  TextView mCardNumberEditText;

  @BindView(R.id.etAmount)
  TextView mAmountEditText;

  @BindView(R.id.etDate)
  TextView mDateTv;

  @BindView(R.id.etPin)
  TextView mPinEditText;

  // Life

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_card);

    ButterKnife.bind(this);
  }

  @OnClick(R.id.btAddCard)
  public void addCard() {
    if (!allFieldsValid()) {
      return;
    }

    String ownnerName = mOwnerNameEditText.getText().toString();
    String cardNumber = mCardNumberEditText.getText().toString();
    Float amount = Float.valueOf(mAmountEditText.getText().toString());

    BankCard card = new BankCard(ownnerName, cardNumber, amount, "DAte", 1478);

    BankCardManager.getBankCardList().add(card);
    finish();
  }

  private boolean allFieldsValid() {
    // TODO implement fields validation

    return true;
  }
}
