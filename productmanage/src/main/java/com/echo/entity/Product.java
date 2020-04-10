package com.echo.entity;

import lombok.Data;


/**
 * @author hearecho
 * @createtime 2020/3/5 22:21
 */
@Data
public class Product {
    private Integer cid;

    /**
     * 产品名称
     */
    private String cname;

    /**
     * 生产成本
     */
    private int cost;

    /**
     * 生产价格
     */
    private int price;

    /**
     * 库存数量
     */
    private int cnum;
    
}
