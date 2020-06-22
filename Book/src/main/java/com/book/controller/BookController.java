package com.book.controller;

import java.util.Arrays;
import java.util.Map;

import com.common.utils.PageUtils;
import com.common.utils.R;
import com.common.valid.AddGroup;
import com.common.valid.DelGroup;
import com.common.valid.UpdateGroup;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.entity.BookEntity;
import com.book.service.BookService;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-05-28 16:01:20
 */
@RestController
@RequestMapping("book/book")
public class BookController {
    @Autowired
    private BookService bookService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = bookService.queryPage(params);
        return R.ok().put("page", page);
    }


    @RequestMapping("/feign/name")
    public String getName(@RequestBody String bid){
        String name = bookService.getBName(bid);
        return name;
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{bid}")
    public R info(@PathVariable("bid") String bid){
		BookEntity book = bookService.getById(bid);

        return R.ok().put("book", book);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@Validated({AddGroup.class})@RequestBody BookEntity book){
		bookService.save(book);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@Validated({UpdateGroup.class}) @RequestBody BookEntity book){
//		bookService.updateById(book);
        bookService.update(book);
        return R.ok();
    }

    @RequestMapping("/feign/delete")
    public R updateCid(@RequestBody String cid){
		bookService.updateCid(cid);

        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@Validated({DelGroup.class})@RequestBody String[] bids){
		bookService.removeByIds(Arrays.asList(bids));

        return R.ok();
    }

}
