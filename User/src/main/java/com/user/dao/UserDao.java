package com.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.user.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-05-28 15:51:58
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
	
}
