package com.order.service.impl;

import com.common.utils.PageUtils;
import com.common.utils.Query;
import com.order.dao.OrderDao;
import com.order.entity.OrderEntity;
import com.order.service.OrderService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String key = (String) params.get("key");
        QueryWrapper<OrderEntity> bookEntityQueryWrapper = new QueryWrapper<>();
        if(key!=null){
            bookEntityQueryWrapper.like("oid",key).or((query)->{
                query.like("address",key);
            }).or().like("uid",key);
        }
        IPage<OrderEntity> page = this.page(
                new Query<OrderEntity>().getPage(params),
                bookEntityQueryWrapper
        );

        return new PageUtils(page);
    }

}