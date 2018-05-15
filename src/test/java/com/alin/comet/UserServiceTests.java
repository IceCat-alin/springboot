package com.alin.comet;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.alin.comet.common.PageList;
import com.alin.comet.entity.User;
import com.alin.comet.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserServiceTests {

    @Autowired
    UserService userService;

    @Test
    public void getUserPageTest() {
        PageList<User> page = userService.getUserPage(0, 10,"","","");
        System.out.println(JSON.toJSONString(page));
    }

}
