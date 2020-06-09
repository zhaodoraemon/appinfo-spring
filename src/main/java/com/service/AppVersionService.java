package com.service;

import com.entity.AppVersion;

import java.util.List;

public interface AppVersionService {
    AppVersion selectByAppid(Long id);

    List<AppVersion> showById(long id);

    int insertSelective(AppVersion record);

    int updateByPrimaryKeySelective(AppVersion record);
}
