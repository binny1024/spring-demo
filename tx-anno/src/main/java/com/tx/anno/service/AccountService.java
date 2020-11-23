package com.tx.anno.service;

public interface AccountService {

    void transfer(String outMan, String inMan, double money);
    void transfer2(String outMan, String inMan, double money);
    void balance(String name);
}
