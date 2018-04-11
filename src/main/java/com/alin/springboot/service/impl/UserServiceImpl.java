package com.alin.springboot.service.impl;

import com.alin.springboot.dao.UserRepository;
import com.alin.springboot.entity.User;
import com.alin.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public Page<User> getUserPage(Integer pageNo , Integer pageSize){
        PageRequest pageable = PageRequest.of(pageNo, pageSize);
        return userRepository.findAll(pageable);
    }
}
