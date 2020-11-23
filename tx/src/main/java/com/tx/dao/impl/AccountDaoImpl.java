package com.tx.dao.impl;

import com.tx.dao.AccountDao;
import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDaoImpl implements AccountDao {

    private final JdbcTemplate jdbcTemplate;


    public AccountDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void out(String outMan, double money) {
        System.out.println("jdbcTemplate = " + jdbcTemplate);
        try {
            jdbcTemplate.update("update account set money=money-? where name=?", money, outMan);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void in(String inMan, double money) {
        System.out.println(inMan);
        jdbcTemplate.update("update account set money=money+? where name=?", money, inMan);
    }
}
