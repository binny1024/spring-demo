package com.my.anno.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class DaoAccount implements IDaoAccount{
    @Autowired
    @Qualifier
    public void in(String account, double money) {

    }

    public void out(String account, double money) {

    }
}
