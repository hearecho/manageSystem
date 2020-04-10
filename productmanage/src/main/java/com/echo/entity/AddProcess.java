package com.echo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author hearecho
 * @createtime 2020/4/2 15:38
 */
@Data
public class AddProcess {
    private Integer pid;

    /**
     * 该生产线生产的产品id
     */
    private int cid;

    /**
     * 负责该生产线的员工id
     */
    private int uid;

    /**
     * 生产产品数量
     */
    private Integer pnum;

    /**
     * 生产状态  0进行中 1暂停 2 完成
     */
    private Integer status;

    /**
     * 添加过程日期
     */
    private Date start = new Date();
}
