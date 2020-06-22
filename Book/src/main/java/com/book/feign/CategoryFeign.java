package com.book.feign;

import com.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("category")
public interface CategoryFeign {

    @RequestMapping("/book/category/getName/{cid}")
    public String getName(@PathVariable("cid") String cid);

}
