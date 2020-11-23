package com.tx;

import com.tx.beans.Account;
import com.tx.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class TestService {
//    @Autowired
//    @Qualifier("accountService")
//    private AccountServiceImpl accountService1;

    @Autowired
    @Qualifier("accountService")
    private AccountService accountService;

    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Test
    public void transfer() {
        accountService.transfer("biter", "nancy", 5);
    }

    @Test
    public void jdbc() {
        List<Account> query =
                jdbcTemplate.query(
                        "select * from account", new BeanPropertyRowMapper<Account>(Account.class));

        System.out.println(query);
    }
}
