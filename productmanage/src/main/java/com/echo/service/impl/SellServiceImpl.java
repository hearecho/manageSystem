package com.echo.service.impl;

import com.echo.entity.Sell;
import com.echo.entity.SellEntity;
import com.echo.mapper.SellMapper;
import com.echo.service.SellService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hearecho
 * @createtime 2020/4/2 21:36
 */
@Service
public class SellServiceImpl implements SellService {
    @Autowired
    SellMapper sellMapper;
    @Override
    public List<SellEntity> query(String query) {
        return sellMapper.query(query);
    }

    @Override
    public List<SellEntity> getAll() {
        return sellMapper.getAll();
    }

    @Override
    public void addSell(Sell sell) {
        sellMapper.addSell(sell);
    }

    @Override
    public void delete(int sid) {
        sellMapper.delete(sid);
    }

    @Override
    public List<SellEntity> getRecent() {
        return sellMapper.getRecent();
    }
}
