package com.service.Impl;

import com.dao.BackendUserDao;
import com.entity.BackendUser;
import com.service.BackendUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("backend")
public class BackendUserServiceImpl implements BackendUserService {
    @Autowired
    @Qualifier("backendUserDao")
    private BackendUserDao b;
    @Override
    public BackendUser selectByPrimaryKey(String id) {
        return b.selectByPrimaryKey(id);
    }
}
