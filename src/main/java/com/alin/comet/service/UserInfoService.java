package com.alin.comet.service;

import com.alin.comet.common.PageList;
import com.alin.comet.entity.UserInfo;
import com.alin.comet.framework.exception.BusinessException;

public interface UserInfoService {
    PageList<UserInfo> getUserPage(Integer pageNo, Integer pageSize, String sort, String sortField, String searchInfo);

    UserInfo addUser(String name, String password);

    UserInfo updateUser(Long id, String name, String password) throws BusinessException;

    void deleteUser(Long id) throws BusinessException;

    UserInfo findByUsername(String username);

}
