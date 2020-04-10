package com.echo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author hearecho
 * @createtime 2020/4/2 18:30
 */
@Data
public class SellEntity {
    private Integer sid;

    /**
     * 已经销售数量
     */
    private Integer snum;

    /**
     * 销售的产品id
     */
    private Product product;


    /**
     * 销售负责人
     */
    private Staff staff;

    private Date occur = new Date();
}
