package com.cartitem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cartitem.entity.CartitemEntity;
import com.common.utils.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-05-28 15:59:28
 */
public interface CartitemService extends IService<CartitemEntity> {

    PageUtils queryPage(Map<String, Object> params);

}

