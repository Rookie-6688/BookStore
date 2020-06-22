package com.book.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookVo {
    private String bid;
    /**
     *
     */
    private String bname;
    /**
     *
     */
    private String url;

    private String author;
    /**
     *
     */
    private BigDecimal price;
    /**
     *
     *
     */
    private String press;
    /**
     *
     */
    private String publishtime;
    /**
     *
     */
    private Integer wordnum;
    /**
     *
     */
    private String printtime;
    /**
     *
     */
    private String cid;
    private String cname;
    /**
     *
     */
    private Integer orderby;
}
