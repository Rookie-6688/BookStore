package com.book.feign;

import com.book.to.OrderItemTo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("orderitem")
public interface OrderItemFeignService {
    @RequestMapping("/book/orderitem/feign/update")
    public void updateBName(@RequestBody OrderItemTo orderItemTo);
}
