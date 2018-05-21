package com.alin.comet.controller;

import com.alin.comet.common.ResultInfo;
import com.alin.comet.entity.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 类描述：
 * @Author 创建人：linying
 * @Date 创建时间：2018/5/21 10:54
 * @Version 版本号：v1.0.0
 */
@Controller
public class IndexController {

    /**
     * 登入
     *
     * @param userInfo 用戶信息
     * @return 登入信息
     */
    @PostMapping(value = "/login")
    @ResponseBody
    public ResultInfo login(UserInfo userInfo) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUsername(), userInfo.getPassword());
        try {
            subject.login(token);
            Map<String, Object> map = new HashMap<>(16);
            map.put("token", subject.getSession().getId());
            return ResultInfo.success("登入成功", map);
        } catch (IncorrectCredentialsException e) {
            return ResultInfo.failure("密码错误");
        } catch (LockedAccountException e) {
            return ResultInfo.failure("登录失败，该用户已被冻结");
        } catch (AuthenticationException e) {
            return ResultInfo.failure("该用户不存在");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultInfo.resultInfo(ResultInfo.CODE_EXCEPTION, "系統异常", null);
        }
    }

    /**
     * @return 未登入信息
     */
    @RequestMapping(value = "/unauth")
    @ResponseBody
    public ResultInfo unauth() {
        return ResultInfo.resultInfo(ResultInfo.CODE_REFUSE, "未登录", null);
    }
}
