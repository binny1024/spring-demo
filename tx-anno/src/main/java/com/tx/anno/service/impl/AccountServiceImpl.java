package com.tx.anno.service.impl;

import com.tx.anno.dao.impl.AccountDaoImpl;
import com.tx.anno.service.AccountService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


//类级别
public class AccountServiceImpl implements AccountService {

    private AccountDaoImpl accountDaoImpl;

    public void setAccountDaoImpl(AccountDaoImpl accountDaoImpl) {
        this.accountDaoImpl = accountDaoImpl;
    }

    //事务控制,方法级别
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
//    @Transactional(value = "dataSourceTransactionManager")
    public void transfer(String outMan, String inMan, double money) {
        accountDaoImpl.out(outMan, money);
        int i = 1 / 0;
        accountDaoImpl.in(inMan, money);
    }

    public void transfer2(String outMan, String inMan, double money) {
        accountDaoImpl.out(outMan, money);
        accountDaoImpl.in(inMan, money);

    }

    public void balance(String name) {
        accountDaoImpl.balance(name);
    }
}
