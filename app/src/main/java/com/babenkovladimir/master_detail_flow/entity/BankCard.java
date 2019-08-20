package com.babenkovladimir.master_detail_flow.entity;

public class BankCard {

  private String ownerName;
  private String num;
  private float amount;
  private String date;
  private int pin;

  public BankCard(String ownerName, String num, float amount, String date, int pin) {
    this.ownerName = ownerName;
    this.num = num;
    this.amount = amount;
    this.date = date;
    this.pin = pin;
  }

  public String getOwnerName() {
    return ownerName;
  }

  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }

  public String getNum() {
    return num;
  }

  public void setNum(String num) {
    this.num = num;
  }

  public float getAmount() {
    return amount;
  }

  public void setAmount(float amount) {
    this.amount = amount;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public int getPin() {
    return pin;
  }

  public void setPin(int pin) {
    this.pin = pin;
  }

  @Override
  public String toString() {
    return ownerName+amount;
  }
}
