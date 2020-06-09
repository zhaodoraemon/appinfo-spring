package com.service.Impl;

import com.dao.AppVersionDao;
import com.entity.AppVersion;
import com.service.AppVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("appversion")
public class AppversionServiceImpl implements AppVersionService {
    @Autowired
    private AppVersionDao appVersionDao;
    @Override
    public AppVersion selectByAppid(Long id) {
        return appVersionDao.selectByAppid(id);
    }
    @Override
    public List<AppVersion> showById(long id){
        return appVersionDao.showById(id);
    }

    @Override
    public int insertSelective(AppVersion record) {
        return appVersionDao.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(AppVersion record) {
        return appVersionDao.updateByPrimaryKeySelective(record);
    }
}
