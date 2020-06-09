package com.service;

import com.entity.BackendUser;

public interface BackendUserService {
    BackendUser selectByPrimaryKey(String id);
}
