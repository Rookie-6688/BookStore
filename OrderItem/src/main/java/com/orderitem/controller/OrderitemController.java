package com.orderitem.controller;

import java.util.Arrays;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.common.utils.PageUtils;
import com.common.utils.R;
import com.common.valid.AddGroup;
import com.common.valid.UpdateGroup;
import com.orderitem.entity.OrderitemEntity;
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
 * @date 2020-05-28 15:54:29
 */
@RestController
@RequestMapping("book/orderitem")
public class OrderitemController {
    @Autowired
    private com.orderitem.service.OrderitemService orderitemService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderitemService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{orderitemid}")
    public R info(@PathVariable("orderitemid") String orderitemid){
		com.orderitem.entity.OrderitemEntity orderitem = orderitemService.getById(orderitemid);

        return R.ok().put("orderitem", orderitem);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@Validated({AddGroup.class})@RequestBody com.orderitem.entity.OrderitemEntity orderitem){
		orderitemService.save(orderitem);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@Validated({UpdateGroup.class}) @RequestBody com.orderitem.entity.OrderitemEntity orderitem){
		orderitemService.updateById(orderitem);

        return R.ok();
    }

    @RequestMapping("/feign/update")
    public void updateBName(@Validated({UpdateGroup.class})@RequestBody OrderitemEntity orderitemEntity){
        orderitemService.update(orderitemEntity,new QueryWrapper<OrderitemEntity>().eq("bid",orderitemEntity.getBid()));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] orderitemids){
		orderitemService.removeByIds(Arrays.asList(orderitemids));

        return R.ok();
    }

}
