package com.category.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.category.entity.CategoryEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-05-28 15:57:21
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
