package com.tx.anno.dao;

public interface AccountDao {

    void out(String outMan, double money);
    void in(String inMan, double money);
    void balance(String name);
}
