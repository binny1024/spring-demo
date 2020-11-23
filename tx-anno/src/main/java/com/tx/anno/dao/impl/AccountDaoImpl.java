package com.tx.anno.dao.impl;

import com.tx.anno.beans.Account;
import com.tx.anno.dao.AccountDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("accountDaoImpl")
public class AccountDaoImpl implements AccountDao {

    private final JdbcTemplate jdbcTemplate;

    public AccountDaoImpl(@Qualifier("jdbcTemplate") JdbcTemplate jdbcTemplate) {
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

    public void balance(String name) {
        Account nancy = jdbcTemplate.queryForObject("select money from account where name=?", new BeanPropertyRowMapper<Account>(Account.class), name);
        System.out.println(nancy.getMoney());
    }
}
