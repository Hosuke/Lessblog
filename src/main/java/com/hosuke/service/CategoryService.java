package com.hosuke.service;

import com.hosuke.model.Category;
import com.hosuke.model.dto.CategoryDto;
import com.hosuke.util.Pager;

import java.util.List;

/**
 * @Author Hosuke
 */
public interface CategoryService {
    //获取所有分类
    public List<CategoryDto> getCategories();

    //更新分类
    public void updateCategory(Category category);

    //保存或添加分类
    public void saveCategory(Category category);

    // 删除分类
    public void deleteCategory(Integer categoryId);

    //获取分类
    public Category getCategory(int categoryId);

    //是否存在该categoryId
    public boolean exist(int categoryId);

    //分页查找
    public List<CategoryDto> getPageCategories(Pager pager);

    //获取总数
    public int getCount();
}
