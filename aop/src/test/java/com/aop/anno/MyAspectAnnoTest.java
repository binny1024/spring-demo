package com.aop.anno;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={SpringConfigCore.class})
public class MyAspectAnnoTest {
    @Autowired
    @Qualifier("target")
    private Target target;
    @Test
    public void annoTest(){
        target.save();
    }
}