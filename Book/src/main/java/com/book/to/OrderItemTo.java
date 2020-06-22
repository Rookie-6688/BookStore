package com.book.to;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemTo {
    private String orderitemid;
    /**
     *
     */
    private Integer quantity;
    /**
     *
     */
    private BigDecimal subtotal;
    /**
     *
     */
    private String bid;
    /**
     *
     */
    private String bname;
    /**
     *
     */
    private BigDecimal currprice;
    /**
     *
     */
    /**
     *
     */
    private String oid;
}
