package com.category.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.category.entity.CategoryEntity;
import com.common.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-05-28 15:57:21
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void removeByIdss(List<String> strings);
}

