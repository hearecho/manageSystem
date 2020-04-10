package com.echo.entity;

import lombok.Data;

/**
 * @author hearecho
 * @createtime 2020/3/2 12:47
 */
@Data
public class Staff {
    private Integer uid;
    private String uname;
    private float kpi;
    private short age;
    /**
     * 人员类型 0 生产 1销售
     */
    private short type;

    /**
     * 人员性别 0女 1男
     */
    private short sex;
}
