package com.echo.service;

import com.echo.entity.Finance;
import com.echo.entity.FinanceEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hearecho
 * @createtime 2020/3/15 9:14
 */
@Service
public interface FinanceService {
    /**
     * 获取全部的财务信息
     * @return
     */
    List<FinanceEntity> getAll();

    /**
     * 通过时间获取财务信息
     * @param start
     * @return
     */
    List<FinanceEntity> query(String start);

    /**
     * 新增财务信息
     * @param finance
     */
    void addEvent(Finance finance);

    void delete(int mid);
}
