package com.orderitem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.utils.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-05-28 15:54:29
 */
public interface OrderitemService extends IService<com.orderitem.entity.OrderitemEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

