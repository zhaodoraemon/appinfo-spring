package com.service;

import com.entity.AppCategory;

import java.util.List;

public interface AppCategoryService {
    List<AppCategory> selectCategory(long parentId);
}
