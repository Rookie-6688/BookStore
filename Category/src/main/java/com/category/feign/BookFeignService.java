package com.category.feign;

import com.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("book")
public interface BookFeignService {
    @RequestMapping("/book/book/feign/delete")
    public R updateCid(@RequestBody String cid);
}
