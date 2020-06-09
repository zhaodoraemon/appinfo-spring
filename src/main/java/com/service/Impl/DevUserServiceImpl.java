package com.service.Impl;

import com.dao.DevUserDao;
import com.entity.DevUser;
import com.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("dev")
public class DevUserServiceImpl implements DevUserService {
    @Autowired
    @Qualifier("devUserDao")
    private DevUserDao devUserDao;
    @Override
    public DevUser selectByPrimaryKey(String id) {
        return devUserDao.selectByPrimaryKey(id);
    }
}
