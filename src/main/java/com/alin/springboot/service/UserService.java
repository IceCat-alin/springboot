package com.alin.springboot.service;

import com.alin.springboot.entity.User;
import org.springframework.data.domain.Page;

public interface UserService {
    Page<User> getUserPage(Integer pageNo, Integer pageSize);
}
