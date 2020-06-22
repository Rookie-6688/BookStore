package com.cartitem.vo;

import lombok.Data;

@Data
public class CartItemVo {
    private String cartitemid;
    /**
     *
     */
    private Integer quantity;
    /**
     *
     */
    private String bid;
    private String bname;
    /**
     *
     */
    private String uid;
    /**
     *
     */
    private Integer orderby;

}
