package com.admin.service;


import com.admin.entity.AdminEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.common.utils.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-05-28 16:02:24
 */
public interface AdminService extends IService<AdminEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

