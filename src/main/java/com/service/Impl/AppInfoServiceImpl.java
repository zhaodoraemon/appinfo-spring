package com.service.Impl;

import com.dao.AppInfoDao;
import com.entity.AppInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.AppInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("appinfo")
public class AppInfoServiceImpl implements AppInfoService {
    @Autowired
    private AppInfoDao appinfo;
    @Override
    public PageInfo<AppInfo> show(int page) {
        PageHelper.startPage(page,5);
        List<AppInfo> appInfoList=appinfo.show();
        PageInfo<AppInfo> c=new PageInfo<>(appInfoList);
        return c;
    }

    @Override
    public PageInfo<AppInfo> showApp(int page) {
        PageHelper.startPage(page,5);
        List<AppInfo> appInfoList=appinfo.showApp();
        PageInfo<AppInfo> c=new PageInfo<>(appInfoList);
        return c;
    }

    @Override
    public PageInfo<AppInfo> selectApp(int page, String softwareName, Long status, Long flatformId, Long categoryLevel3, Long categoryLevel2, Long categoryLevel1) {
        PageHelper.startPage(page,5);
        List<AppInfo> appInfoList=appinfo.selectApp(softwareName,status,flatformId,categoryLevel3,categoryLevel2,categoryLevel1);
        PageInfo<AppInfo> c=new PageInfo<>(appInfoList);
        return c;
    }

    @Override
    public AppInfo selectByPrimaryKey(Long id) {

        return appinfo.selectByPrimaryKey(id);
    }

    @Override
    public int checkapp(long id, long status) {
        return appinfo.checkapp(id,status);
    }

    @Override
    public int insertSelective(AppInfo record) {
        return appinfo.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(AppInfo record) {
        return appinfo.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return appinfo.deleteByPrimaryKey(id);
    }


}
