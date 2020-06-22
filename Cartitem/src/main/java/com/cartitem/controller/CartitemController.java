package com.cartitem.controller;

import java.util.Arrays;
import java.util.Map;

import com.cartitem.entity.CartitemEntity;
import com.cartitem.service.CartitemService;
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
 * @date 2020-05-28 15:59:28
 */
@RestController
@RequestMapping("book/cartitem")
public class CartitemController {
    @Autowired
    private CartitemService cartitemService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cartitemService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{cartitemid}")
    public R info(@PathVariable("cartitemid") String cartitemid){
		CartitemEntity cartitem = cartitemService.getById(cartitemid);

        return R.ok().put("cartitem", cartitem);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@Validated({AddGroup.class})@RequestBody CartitemEntity cartitem){
		cartitemService.save(cartitem);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@Validated({UpdateGroup.class}) @RequestBody CartitemEntity cartitem){
		cartitemService.updateById(cartitem);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] cartitemids){
		cartitemService.removeByIds(Arrays.asList(cartitemids));

        return R.ok();
    }

}
