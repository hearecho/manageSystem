package com.echo.service.impl;

import com.echo.entity.Product;
import com.echo.mapper.ProductMapper;
import com.echo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hearecho
 * @createtime 2020/3/15 13:04
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Override
    public List<Product> getAll() {
        return productMapper.getAll();
    }

    @Override
    public List<Product> getById(int id) {
        List<Product> p = new ArrayList<>();
        p.add(productMapper.getById(id));
        return p;
    }

    @Override
    public void add(Product product) {
        productMapper.add(product);
    }

    @Override
    public void changeCnum(int cid, int cnum) {
        productMapper.changeCnum(cid,cnum);
    }

    @Override
    public List<Product> getMostCost() {
        return productMapper.getMostNum();
    }

    @Override
    public List<Product> query(String query) {
        return productMapper.query(query);
    }

    @Override
    public void deleteProduct(int cid) {
        productMapper.deleteProduct(cid);
    }

    @Override
    public void changeCostOrPrice(int cid, int cost, int price) {
        productMapper.changeCostOrPrice(cid,cost,price);
    }
}
