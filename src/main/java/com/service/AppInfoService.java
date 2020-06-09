package com.service;

import com.entity.AppInfo;
import com.github.pagehelper.PageInfo;

public interface AppInfoService {

    PageInfo<AppInfo> show(int page);

    PageInfo<AppInfo> showApp(int page);

    PageInfo<AppInfo> selectApp(int page, String softwareName, Long status, Long flatformId, Long categoryLevel3, Long categoryLevel2, Long categoryLevel1);

    AppInfo selectByPrimaryKey(Long id);

    int checkapp(long id, long status);

    int insertSelective(AppInfo record);

    int updateByPrimaryKeySelective(AppInfo record);

    int deleteByPrimaryKey(Long id);
}
