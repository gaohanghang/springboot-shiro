package com.gaohang.springbootshiro;

import com.gaohang.springbootshiro.domin.User;
import com.gaohang.springbootshiro.service.Userservice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootShiroApplicationTests {

    @Autowired
    private Userservice userservice;

    @Test
    public void contextLoads() {
        User test = userservice.findByName("test");
        System.out.println(test);
    }
}

