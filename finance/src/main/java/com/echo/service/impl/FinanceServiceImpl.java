package com.echo.service.impl;

import com.echo.entity.Finance;
import com.echo.entity.FinanceEntity;
import com.echo.mapper.FinanceMapper;
import com.echo.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hearecho
 * @createtime 2020/3/15 9:14
 */
@Service
public class FinanceServiceImpl implements FinanceService {

    @Autowired
    FinanceMapper financeMapper;

    @Override
    public List<FinanceEntity> getAll() {
        return financeMapper.getAll();
    }

    @Override
    public void addEvent(Finance finance) {
        financeMapper.addEvent(finance);
    }

    @Override
    public List<FinanceEntity> query(String start) {
        return financeMapper.query(start);
    }

    @Override
    public void delete(int mid) {
        financeMapper.delete(mid);
    }
}
