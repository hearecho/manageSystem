package com.echo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author hearecho
 * @createtime 2020/3/5 22:37
 */
@Data
public class Process {
    private Integer pid;

    /**
     * 该生产线生产的产品id
     */
    private Product product;

    /**
     * 负责该生产线的员工id
     */
    private Staff staff;

    /**
     * 生产产品数量
     */
    private Integer pnum;

    /**
     * 生产状态  0暂停 1进行中 2 完成
     */
    private Integer status;

    /**
     * 添加过程日期
     */
    private Date start = new Date();
}
