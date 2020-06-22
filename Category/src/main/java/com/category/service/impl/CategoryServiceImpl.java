package com.category.service.impl;

import com.category.dao.CategoryDao;
import com.category.entity.CategoryEntity;
import com.category.feign.BookFeignService;
import com.category.service.CategoryService;
import com.common.utils.PageUtils;
import com.common.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.util.StringUtils;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Autowired
    BookFeignService bookFeignService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String key = (String) params.get("key");
        QueryWrapper<CategoryEntity> bookEntityQueryWrapper = new QueryWrapper<>();
        if(key!=null){
            bookEntityQueryWrapper.like("cname",key).or((query)->{
                query.like("desc1",key);
            });
        }
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                bookEntityQueryWrapper
        );

        return new PageUtils(page);
    }

    @Override
    public void removeByIdss(List<String> cids) {
        if(!StringUtils.isEmpty(cids)){
            for (String cid : cids) {
                this.baseMapper.deleteById(cid);
                System.out.println("1");
                bookFeignService.updateCid(cid);
            }
        }
    }

}