package com.alin.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alin.springboot.common.ResultInfo;
import com.alin.springboot.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserPage")
    @ResponseBody
    public ResultInfo getUserPage(Integer pageNo, Integer pageSize) {
        return ResultInfo.success("success", userService.getUserPage(pageNo, pageSize));
    }

}
