package com.admin.service.impl;

import com.admin.dao.AdminDao;
import com.admin.entity.AdminEntity;
import com.admin.service.AdminService;
import com.common.utils.PageUtils;
import com.common.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("adminService")
public class AdminServiceImpl extends ServiceImpl<AdminDao, AdminEntity> implements AdminService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String key = (String) params.get("key");
        QueryWrapper<AdminEntity> bookEntityQueryWrapper = new QueryWrapper<>();
        if(key!=null){
            bookEntityQueryWrapper.like("adminname",key);
        }
        IPage<AdminEntity> page = this.page(
                new Query<AdminEntity>().getPage(params),
                bookEntityQueryWrapper
        );
        return new PageUtils(page);
    }

}