package com.alin.comet.service;

import com.alin.comet.common.PageList;
import com.alin.comet.entity.User;
import com.alin.comet.framework.exception.BusinessException;

public interface UserService {
    PageList<User> getUserPage(Integer pageNo, Integer pageSize, String sort, String sortField, String searchInfo);

    User addUser(String name, String password);

    User updateUser(Long id, String name, String password) throws BusinessException;

    void deleteUser(Long id) throws BusinessException;
}
