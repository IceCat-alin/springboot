package com.alin.comet.framework.exception;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.alin.comet.config.AOPConfig;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 类描述：全局异常处理
 * @Author 创建人：linying
 * @Date 创建时间：2018/5/21 11:02
 * @Version 版本号：v1.0.0
 */
public class MyExceptionHandler implements HandlerExceptionResolver {

    /**
     * 日志
     */
    private static final Logger LOG = LoggerFactory.getLogger(AOPConfig.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        ModelAndView mv = new ModelAndView();
        FastJsonJsonView view = new FastJsonJsonView();
        Map<String, Object> attributes = new HashMap<>();
        if (ex instanceof UnauthenticatedException) {
            attributes.put("code", "10004");
            attributes.put("msg", "token错误");
        } else if (ex instanceof UnauthorizedException) {
            attributes.put("code", "10004");
            attributes.put("msg", "用户无权限");
        } else {
            attributes.put("code", "10002");
            attributes.put("msg", "系统异常:" + ex.getMessage());
            LOG.error(ex.getMessage());
        }

        view.setAttributesMap(attributes);
        mv.setView(view);
        return mv;
    }
}
