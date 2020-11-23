package com.jdbc.demo.config;

import com.jdbc.demo.Account;
import com.jdbc.demo.Loans;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringCoreConfigure.class)
public class SpringCoreConfigureTest {

    //    从spring容器中获取指定id的bean 示例
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test1() {

        List<Map<String, String>> query =
                jdbcTemplate.query(
                        "select * from loans",
                        new RowMapper<Map<String, String>>() {
                            // 这个会被查询结果多次调用
                            public Map<String, String> mapRow(ResultSet resultSet, int i)
                                    throws SQLException {
                                Map<String, String> res = new HashMap<String, String>();
                                res.put("name", resultSet.getString("name"));
                                res.put("amount", resultSet.getString("amount"));
                                res.put("comment", resultSet.getString("comment"));
                                System.out.println("3eee");
                                return res;
                            }
                        });
        System.out.println("query  " + query);
    }

    @Test
    public void testLoans() {
        List<Loans> query =jdbcTemplate.query("select * from loans", new BeanPropertyRowMapper<Loans>(Loans.class));
        System.out.println("query  " + query);
    }

    @Test
    public void testAccount() {
        List<Account> query =
                jdbcTemplate.query(
                        "select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println("query  " + query);
    }

    @Test
    public void test3() {
        Loans loans = jdbcTemplate.queryForObject("select * from loans where name=?",new BeanPropertyRowMapper<Loans>(Loans.class),"李洪志");
        System.out.println("query  " + loans);
    }
    @Test
    public void getConnect() throws SQLException, PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/myself");
        dataSource.setUser("root");
        dataSource.setPassword("liux1228");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
