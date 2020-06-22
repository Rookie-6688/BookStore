package com.book.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.book.entity.BookEntity;
import com.common.utils.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-05-28 16:01:20
 */
public interface BookService extends IService<BookEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void updateCid(String cid);

    String getBName(String bid);

    void update(BookEntity book);
}

