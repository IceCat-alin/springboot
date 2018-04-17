package com.alin.springboot.service;

import com.alin.springboot.common.PageList;
import com.alin.springboot.entity.User;
import com.alin.springboot.framework.exception.BusinessException;

public interface UserService {
    PageList<User> getUserPage(Integer pageNo, Integer pageSize, String sort, String sortField, String searchInfo);

    User addUser(String name, String password);

    User updateUser(Long id, String name, String password) throws BusinessException;

    void deleteUser(Long id) throws BusinessException;
}
