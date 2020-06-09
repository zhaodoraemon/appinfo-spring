package com.service.Impl;

import com.dao.AppCategoryDao;
import com.entity.AppCategory;
import com.service.AppCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("appcategory")
public class AppCategoryServiceImpl implements AppCategoryService {
    @Autowired
    private AppCategoryDao appCategoryDao;
    @Override
    public List<AppCategory> selectCategory(long parentId) {
        return appCategoryDao.selectCategory(parentId);
    }
}
