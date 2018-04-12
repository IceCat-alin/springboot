package com.alin.springboot.service;

import com.alin.springboot.common.PageList;
import com.alin.springboot.entity.User;

public interface UserService {
    PageList<User> getUserPage(Integer pageNo, Integer pageSize);
}
