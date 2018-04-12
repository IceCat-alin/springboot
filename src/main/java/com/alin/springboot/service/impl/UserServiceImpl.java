package com.alin.springboot.service.impl;

import com.alin.springboot.common.Constant;
import com.alin.springboot.common.PageList;
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
    public PageList<User> getUserPage(Integer pageNo , Integer pageSize){
        int currentPage = pageNo != null && pageNo > 0 ? pageNo - 1 : Constant.DEFAULT_PAGE;
        int currentSize = pageSize != null && pageSize > 0 ? pageSize : Constant.DEFAULT_SIZE;
        PageRequest pageable = PageRequest.of(currentPage, currentSize);

        Page<User> page = userRepository.findAll(pageable);

        return new PageList(page.getContent(),page.getTotalElements(),page.getTotalPages());
    }
}
