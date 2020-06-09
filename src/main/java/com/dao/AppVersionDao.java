package com.dao;

import com.entity.AppVersion;

import java.util.List;

public interface AppVersionDao {
    int deleteByPrimaryKey(Long id);

    int insert(AppVersion record);

    int insertSelective(AppVersion record);

    AppVersion selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppVersion record);

    int updateByPrimaryKey(AppVersion record);

    AppVersion selectByAppid(Long id);

    List<AppVersion> showById(long id);
}