package com.babenkovladimir.master_detail_flow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.babenkovladimir.R;
import com.babenkovladimir.master_detail_flow.MyRecyclerAdapter.BankCardViewHolder;
import com.babenkovladimir.master_detail_flow.entity.BankCard;
import java.util.ArrayList;
import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<BankCardViewHolder> {

  private List<BankCard> cards = new ArrayList();

  private OnCardItemClick onCardItemClick;

  public void setOnCardItemClick(OnCardItemClick onCardItemClick) {
    this.onCardItemClick = onCardItemClick;
  }

  public void setCards(List<BankCard> cards) {
    this.cards = cards;
    notifyDataSetChanged();
  }

  @NonNull
  @Override
  public BankCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    Context context = parent.getContext();
    LayoutInflater inflater = LayoutInflater.from(context);
    View view = inflater.inflate(R.layout.item_bank_card_holder, parent, false);
    return new BankCardViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull BankCardViewHolder holder, int position) {
    holder.bind(cards.get(position), onCardItemClick, position);

  }

  @Override
  public int getItemCount() {
    return cards.size();
  }

  // No need overriding
  @Override
  public int getItemViewType(int position) {
    return super.getItemViewType(position);
  }

  // View Holder

  static class BankCardViewHolder extends RecyclerView.ViewHolder {

    public BankCardViewHolder(@NonNull View itemView) {
      super(itemView);
    }

    // Public

    public void bind(BankCard card, OnCardItemClick onCardItemClick, int position) {

      TextView ownerName = itemView.findViewById(R.id.tvOwnerName);
      TextView number = itemView.findViewById(R.id.tvCardNumber);
      TextView amount = itemView.findViewById(R.id.tvAmount);
      TextView data = itemView.findViewById(R.id.tvDate);
      TextView pin = itemView.findViewById(R.id.tvPin);

      ownerName.setText(card.getOwnerName());
      number.setText(card.getNum());
      amount.setText(String.valueOf(card.getAmount()));
      data.setText(card.getDate());
      pin.setText(Integer.toString(card.getPin()));

      number.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          onCardItemClick.onCardClick(position);
        }
      });
    }
  }
}

interface OnCardItemClick {

  void onCardClick(int position);
}
