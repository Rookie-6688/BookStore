package com.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.order.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-05-28 15:56:26
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
