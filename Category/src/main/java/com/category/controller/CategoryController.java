package com.category.controller;

import java.util.Arrays;
import java.util.Map;

import com.category.entity.CategoryEntity;
import com.category.service.CategoryService;
import com.common.utils.PageUtils;
import com.common.utils.R;
import com.common.valid.AddGroup;
import com.common.valid.UpdateGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-05-28 15:57:21
 */
@RestController
@RequestMapping("book/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = categoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{cid}")
    public R info(@PathVariable("cid") String cid){
		CategoryEntity category = categoryService.getById(cid);

        return R.ok().put("category", category);
    }
    @RequestMapping("/getName/{cid}")
    public String getName(@PathVariable("cid") String cid){
		CategoryEntity category = categoryService.getById(cid);
        if(category!=null){
            return category.getCname();
        }
        return null;
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@Validated({AddGroup.class})@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@Validated({UpdateGroup.class}) @RequestBody CategoryEntity category){
		categoryService.updateById(category);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] cids){
        categoryService.removeByIdss(Arrays.asList(cids));
        return R.ok();
    }

}
