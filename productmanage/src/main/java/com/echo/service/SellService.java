package com.echo.service;

import com.echo.entity.Sell;
import com.echo.entity.SellEntity;

import java.util.List;

/**
 * @author hearecho
 * @createtime 2020/4/2 21:28
 */
public interface SellService {
    /**
     * 根据参数查询
     * @param query 创建时间
     * @return
     */
    List<SellEntity> query(String query);

    /**
     * 获取全部
     * @return
     */
    List<SellEntity> getAll();

    /**
     * 插入一条销售记录
     * @param sell
     */
    void addSell(Sell sell);

    /**
     * 删除一条销售记录
     * @param sid
     */
    void delete(int sid);

    List<SellEntity> getRecent();
}
