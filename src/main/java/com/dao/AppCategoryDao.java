package com.dao;

import com.entity.AppCategory;

import java.util.List;

public interface AppCategoryDao {
    int deleteByPrimaryKey(Long id);

    int insert(AppCategory record);

    int insertSelective(AppCategory record);

    AppCategory selectByPrimaryKey(Long id);

    List<AppCategory> selectCategory(long parentId);

    int updateByPrimaryKeySelective(AppCategory record);

    int updateByPrimaryKey(AppCategory record);
}