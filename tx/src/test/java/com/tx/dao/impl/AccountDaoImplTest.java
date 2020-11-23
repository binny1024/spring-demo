package com.tx.dao.impl;

import com.tx.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class AccountDaoImplTest {
    @Autowired
    @Qualifier("accountService")
    private AccountService accountService;

    @Test
    public void connection(){
        accountService.transfer("biter","nancy",5);
    }
}