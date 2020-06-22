package com.orderitem.service.impl;

import com.common.utils.PageUtils;
import com.common.utils.Query;
import com.orderitem.entity.OrderitemEntity;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("orderitemService")
public class OrderitemServiceImpl extends ServiceImpl<com.orderitem.dao.OrderitemDao, com.orderitem.entity.OrderitemEntity> implements com.orderitem.service.OrderitemService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String key = (String) params.get("key");
        QueryWrapper<OrderitemEntity> bookEntityQueryWrapper = new QueryWrapper<>();
        if(key!=null){
            bookEntityQueryWrapper.like("orderItemId",key).or((query)->{
                query.like("bid",key);
            }).or().like("bname",key);
        }
        IPage<OrderitemEntity> page = this.page(
                new Query<OrderitemEntity>().getPage(params),
                bookEntityQueryWrapper
        );

        return new PageUtils(page);
    }

}