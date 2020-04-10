package com.echo.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @author hearecho
 * @createtime 2020/3/10 19:25
 */
@Data
public class Finance {
    private Integer mid;

    private Integer money;
    /***
     * 财务时间类型 生产0 销售1 发工资 2
     */
    private Integer eventType;
    /**
     * 具体生产事件
     */
    private String event;
    /**
     * 对应财务事件发生负责人id
     */
    private Integer uid;
    /**
     * 财务事件发生的时间
     */
    private Date ocdate;
}
