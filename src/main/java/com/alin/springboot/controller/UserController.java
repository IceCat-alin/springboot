package com.alin.springboot.controller;

import com.alin.springboot.entity.User;
import com.alin.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserPage")
    @ResponseBody
    public Page<User> getUserPage(Integer pageNo, Integer pageSize) {
        return userService.getUserPage(pageNo, pageSize);
    }


}
