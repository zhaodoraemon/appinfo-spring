package com.service;

import com.entity.DevUser;

public interface DevUserService {
    DevUser selectByPrimaryKey(String id);
}
