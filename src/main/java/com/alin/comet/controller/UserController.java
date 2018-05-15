package com.alin.comet.controller;

import com.alibaba.fastjson.JSON;
import com.alin.comet.common.PageList;
import com.alin.comet.common.ResultInfo;
import com.alin.comet.entity.UserInfo;
import com.alin.comet.framework.exception.BusinessException;
import com.alin.comet.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * @param pageNo
     * @param pageSize
     * @return
     * @throws
     * @Description 分页查询用户
     * @Date 2018/4/17 9:36
     **/
    @GetMapping("/getUserPage")
    @ResponseBody
    public ResultInfo getUserPage(Integer pageNo, Integer pageSize, String sort, String sortField, String searchInfo) {
        PageList<UserInfo> userPageList = userInfoService.getUserPage(pageNo, pageSize, sort, sortField, searchInfo);
        System.out.println(JSON.toJSON(userPageList));
        return ResultInfo.success("分页查询用户成功", userPageList);
    }

    /**
     * @param name
     * @param password
     * @return
     * @Description 新增用户
     * @Date 2018/4/17 9:46
     **/
    @PostMapping("/addUser")
    @ResponseBody
    public ResultInfo addUser(String name, String password) {
        return ResultInfo.success("新增用户成功", userInfoService.addUser(name, password));
    }

    /**
     * @param id
     * @param name
     * @param password
     * @return
     * @throws BusinessException 业务异常
     * @Description 修改用户
     * @Date 2018/4/17 10:01
     **/
    @PostMapping("/updateUser")
    @ResponseBody
    public ResultInfo updateUser(Long id, String name, String password) throws BusinessException {
        try {
            UserInfo user = userInfoService.updateUser(id, name, password);
            return ResultInfo.success("修改用户成功", user);
        } catch (BusinessException e) {
            return ResultInfo.failure("修改用户失败:" + e.getMessage());
        }
    }

    /**
     * @param id
     * @return
     * @throws BusinessException 业务异常
     * @Description 删除用户
     * @Date 2018/4/17 10:28
     **/
    @DeleteMapping("/deleteUser")
    @ResponseBody
    public ResultInfo deleteUser(Long id) throws BusinessException {
        try {
            userInfoService.deleteUser(id);
            return ResultInfo.success("删除用户成功");
        } catch (BusinessException e) {
            return ResultInfo.failure("删除用户失败:" + e.getMessage());
        }
    }

}
