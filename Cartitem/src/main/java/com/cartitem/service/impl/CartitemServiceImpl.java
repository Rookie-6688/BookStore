package com.cartitem.service.impl;

import com.cartitem.feign.BookFeiginService;
import com.cartitem.service.CartitemService;
import com.cartitem.vo.CartItemVo;
import com.common.utils.PageUtils;
import com.common.utils.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.cartitem.dao.CartitemDao;
import com.cartitem.entity.CartitemEntity;


@Service("cartitemService")
public class CartitemServiceImpl extends ServiceImpl<CartitemDao, CartitemEntity> implements CartitemService {

    @Autowired
    BookFeiginService bookFeiginService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String key = (String) params.get("key");
        QueryWrapper<CartitemEntity> bookEntityQueryWrapper = new QueryWrapper<>();
        if(key!=null){
            bookEntityQueryWrapper.like("cartItemId",key).or((query)->{
                query.like("bid",key);
            }).or().like("uid",key);
        }
        IPage<CartitemEntity> page = this.page(
                new Query<CartitemEntity>().getPage(params),
                bookEntityQueryWrapper
        );
        PageUtils pageUtils = new PageUtils(page);
        List<CartitemEntity> list = (List<CartitemEntity>) pageUtils.getList();
        if(list!=null&&list.size()>0){
            List<CartItemVo> collect = list.stream().map(cartitemEntity -> {
                CartItemVo cartItemVo = new CartItemVo();
                String name = bookFeiginService.getName(cartitemEntity.getBid());
                BeanUtils.copyProperties(cartitemEntity, cartItemVo);
                cartItemVo.setBname(name);
                return cartItemVo;
            }).collect(Collectors.toList());
            pageUtils.setList(collect);
        }
        return pageUtils;
    }

}