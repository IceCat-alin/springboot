package com.alin.comet.dao;

import com.alin.comet.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long>,JpaSpecificationExecutor<UserInfo>{

    /**
     * 根据用户名查找数据
     * @param username
     * @return
     */
    UserInfo findByUsername(String username);
}
