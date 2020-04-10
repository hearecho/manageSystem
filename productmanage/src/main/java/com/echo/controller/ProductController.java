package com.echo.controller;

import com.alibaba.fastjson.JSONObject;
import com.echo.entity.Product;
import com.echo.response.R;
import com.echo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hearecho
 * @createtime 2020/3/6 20:16
 */
@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/all")
    public R query(@RequestParam("query")String query,
                   @RequestParam("pagenum")int pageNum,
                   @RequestParam("pagesize")int pageSize) {
        List<Product> all = productService.query(query);
        int from = (pageNum-1)*pageSize;
        int to = pageNum*pageSize;
        int num = all.size();
        if (to > num) {
            to = num;
        }
        List<Product> resu = all.subList(from,to);
        return R.ok().data("items",resu,num);
    }


    @PostMapping("/add")
    public R addProduct(@RequestBody Product product) {
        product.setCnum(0);
        productService.add(product);
        return R.ok().message("新增完成");
    }

    @GetMapping("/most")
    public R getMost() {
        List<Product> resu = productService.getMostCost();
        return R.ok().data("items",resu,resu.size());
    }


    @GetMapping("/{cid}")
    public R getOne(@PathVariable(name = "cid")int cid) {
        List<Product> resu = productService.getById(cid);
        return R.ok().data("items",resu,1);
    }

    @PutMapping("/update/{cid}")
    public R updateCnum(@RequestBody JSONObject data,
                       @PathVariable(name = "cid")int cid) {
        productService.changeCnum(cid,(Integer) data.get("cnum"));
        return R.ok().message("更新完成");
    }

    @PutMapping("/change/{cid}")
    public R updateCostOrPrice(@RequestBody JSONObject data,
                        @PathVariable(name = "cid")int cid) {
        productService.changeCostOrPrice(cid,(Integer)data.get("cost"),(Integer) data.get("price"));
        return R.ok().message("更新完成");
    }

    @DeleteMapping("/delete/{id}")
    public R deleteStaff(@PathVariable(name = "id") int cid) {
        productService.deleteProduct(cid);
        return R.ok().message("删除成功");
    }

    @GetMapping("/list")
    public R getList() {
        List<Product> all = productService.query("");
        return R.ok().data(all,all.size());
    }


}
