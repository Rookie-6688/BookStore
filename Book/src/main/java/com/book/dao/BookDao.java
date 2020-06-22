package com.book.dao;

import com.book.entity.BookEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-05-28 16:01:20
 */
@Mapper
public interface BookDao extends BaseMapper<BookEntity> {
	
}
