package com.echo.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


/**
 * @author hearecho
 * @createtime 2020/3/10 19:36
 */
@Data
public class Sell {
    private Integer sid;

    /**
     * 已经销售数量
     */
    private Integer snum;

    /**
     * 销售的产品id
     */
    private Integer cid;


    /**
     * 销售负责人
     */
    private Integer uid;

    private Date occur = new Date();
}
