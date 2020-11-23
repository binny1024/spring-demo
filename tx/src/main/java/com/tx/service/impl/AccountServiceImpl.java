package com.tx.service.impl;

import com.tx.dao.impl.AccountDaoImpl;
import com.tx.service.AccountService;


public class AccountServiceImpl implements AccountService {
    private AccountDaoImpl accountDaoImpl;

    public void setAccountDaoImpl(AccountDaoImpl accountDaoImpl) {
        this.accountDaoImpl = accountDaoImpl;
    }

    /**
     * 未开启事务
     *
     * @param outMan
     * @param inMan
     * @param money
     */
    public void transfer(String outMan, String inMan, double money) {
        accountDaoImpl.out(outMan, money);
        int i = 1 / 0;
        accountDaoImpl.in(inMan, money);
    }
    /**
     * 用过配置开启事务
     *
     * @param outMan
     * @param inMan
     * @param money
     */
    public void transfer2(String outMan, String inMan, double money) {
        accountDaoImpl.out(outMan, money);
//        int i = 1 / 0;
        accountDaoImpl.in(inMan, money);
    }
}
