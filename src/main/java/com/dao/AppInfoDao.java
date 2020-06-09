package com.dao;

import com.entity.AppInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppInfoDao {
    List<AppInfo> showApp();

    List<AppInfo> selectApp(@Param("softwareName")String softwareName, @Param("status")Long status, @Param("flatformId")Long flatformId, @Param("categoryLevel3")Long categoryLevel3, @Param("categoryLevel2")Long categoryLevel2, @Param("categoryLevel1")Long categoryLevel1);

    List<AppInfo> show();

    int deleteByPrimaryKey(Long id);

    int insert(AppInfo record);

    int checkapp(@Param("id")long id, @Param("status")long status);

    int insertSelective(AppInfo record);

    AppInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppInfo record);

    int updateByPrimaryKey(AppInfo record);
}