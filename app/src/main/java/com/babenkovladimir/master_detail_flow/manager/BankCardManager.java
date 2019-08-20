package com.babenkovladimir.master_detail_flow.manager;


import com.babenkovladimir.master_detail_flow.entity.BankCard;
import java.util.ArrayList;
import java.util.List;


public class BankCardManager {

  public static final String ARG_CARD_ID = "arg card id";

  private static List<BankCard> bankCardList = new ArrayList<>();


  public static List<BankCard> getBankCardList() {
    return bankCardList;
  }


  public static void initBankCardList(){
    bankCardList.add(new BankCard("Danya", "1234 5678 9012 4578", 1000f, "21.02.2017", 1458));
    bankCardList.add(new BankCard("Vanya", "32323 4587 9012 4578", 1000f, "21.02.2017", 7896));
    bankCardList.add(new BankCard("Olya", "1234 5678 3698 4578", 1000f, "21.02.2017", 4555));
    bankCardList.add(new BankCard("Kira", "1234 5678 7854 4578", 1000f, "21.02.2017", 3563));
    bankCardList.add(new BankCard("Misha", "9874 5678 9012 4578", 1000f, "21.02.2017", 1234));
    bankCardList.add(new BankCard("Masyanya", "1234 2588 9012 4578", 1000f, "21.02.2017", 7777));
    bankCardList.add(new BankCard("Mikhalich", "1234 5678 9012 3333", 1000f, "21.02.2017", 8888));
    bankCardList.add(new BankCard("Lesha", "0000 5678 9012 4578", 1000f, "21.02.2017", 9999));
    bankCardList.add(new BankCard("Vitalik", "9999 5678 9012 4578", 1000f, "21.02.2017", 1212));
  }
}
