package com.user.service.impl;

import com.common.utils.PageUtils;
import com.common.utils.Query;
import com.user.dao.UserDao;
import com.user.entity.UserEntity;
import com.user.service.UserService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String key = (String) params.get("key");
        QueryWrapper<UserEntity> bookEntityQueryWrapper = new QueryWrapper<>();
        if(key!=null){
            bookEntityQueryWrapper.like("uid",key).or((query)->{
                query.like("loginname",key);
            }).or().like("email",key);
        }
        IPage<UserEntity> page = this.page(
                new Query<UserEntity>().getPage(params),
                bookEntityQueryWrapper
        );

        return new PageUtils(page);
    }

}