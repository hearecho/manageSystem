package com.echo.service;

import com.echo.entity.Product;

import java.util.List;

/**
 * @author hearecho
 * @createtime 2020/3/15 12:53
 */
public interface ProductService {
    List<Product> getAll();
    List<Product> getById(int id);

    /**
     * 获取成本最高的五个产品
     * @return
     */
    List<Product> getMostCost();
    List<Product> query(String query);
    void add(Product product);
    void changeCnum(int cid,int cnum);
    void deleteProduct(int cid);
    void changeCostOrPrice(int cid,int cost,int price);
}
