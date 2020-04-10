package com.echo.controller;

import com.echo.entity.*;
import com.echo.entity.Process;
import com.echo.response.R;
import com.echo.service.SellService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hearecho
 * @createtime 2020/4/2 17:13
 */
@RestController
@RequestMapping("/sell")
@CrossOrigin
public class SellController {
    @Autowired
    SellService sellService;

    @GetMapping("/all")
    public R query(@RequestParam("query")String query,
                   @RequestParam("pagenum")int pageNum,
                   @RequestParam("pagesize")int pageSize) {
        List<SellEntity> all ;
        if ("".equals(query)) {
            all = sellService.getAll();
        } else {
            all = sellService.query(query);
        }
        int from = (pageNum-1)*pageSize;
        int to = pageNum*pageSize;
        int num = all.size();
        if (to > num) {
            to = num;
        }
        List<SellEntity> resu = all.subList(from,to);
        return R.ok().data(resu,num);
    }

    @PostMapping("/add")
    public R add(@RequestBody Sell sell) {
        sellService.addSell(sell);
        return R.ok().message("更新成功");
    }

    @DeleteMapping("/delete/{id}")
    public R deleteStaff(@PathVariable(name = "id") int sid) {
        sellService.delete(sid);
        return R.ok().message("删除成功");
    }
    @GetMapping("/most")
    public R getMost() {
        List<SellEntity> resu = sellService.getRecent();
        return R.ok().data("items",resu,resu.size());
    }
}
