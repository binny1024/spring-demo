package com.jdbc.demo;

public class Loans {

  private String name;
  private double amount;
  private String datetime;
  private String comment;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public String getDatetime() {
    return datetime;
  }

  public void setDatetime(String datetime) {
    this.datetime = datetime;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  @Override
  public String toString() {
    return "Account{"
        + "name='"
        + name
        + '\''
        + ", amount="
        + amount
        + ", datetime='"
        + datetime
        + '\''
        + ", comment='"
        + comment
        + '\''
        + '}';
  }
}
