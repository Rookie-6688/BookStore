package com.cartitem.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("book")
public interface BookFeiginService {

    @RequestMapping("/book/book/feign/name")
    public String getName(@RequestBody String bid);
}
