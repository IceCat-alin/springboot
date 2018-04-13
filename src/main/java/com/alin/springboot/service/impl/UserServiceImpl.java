package com.alin.springboot.service.impl;

import com.alin.springboot.common.Constant;
import com.alin.springboot.common.PageList;
import com.alin.springboot.dao.UserRepository;
import com.alin.springboot.entity.User;
import com.alin.springboot.framework.database.Criteria;
import com.alin.springboot.framework.database.Restrictions;
import com.alin.springboot.framework.utils.DateUtil;
import com.alin.springboot.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public PageList<User> getUserPage(Integer pageNo, Integer pageSize) {
        int currentPage = pageNo != null && pageNo > 0 ? pageNo - 1 : Constant.DEFAULT_PAGE;
        int currentSize = pageSize != null && pageSize > 0 ? pageSize : Constant.DEFAULT_SIZE;
        PageRequest pageable = PageRequest.of(currentPage, currentSize, new Sort(Sort.Direction.DESC, "createTime"));

        String name = "尚鹏";
        Date beginTime = DateUtil.formatStrToDateCommon("2018-04-10 00:00:00");
        Date endTime = DateUtil.formatStrToDateCommon("2018-04-20 00:00:00");
        Criteria<User> criteria = queryCondition(name, beginTime, endTime);

        Page<User> page = userRepository.findAll(criteria,pageable);

        return new PageList(page.getContent(), page.getTotalElements(), page.getTotalPages());
    }

    private Criteria<User> queryCondition(String name, Date beginTime, Date endTime) {
        Criteria<User> criteria = new Criteria<User>();
        if (StringUtils.isNotBlank(name)) {
            criteria.add(Restrictions.eq("name", name, true));
        }
        if (beginTime != null) {
            criteria.add(Restrictions.gte("createTime", beginTime, true));
        }
        if (endTime != null) {
            criteria.add(Restrictions.lte("createTime", endTime, true));
        }
        return criteria;
    }
}
