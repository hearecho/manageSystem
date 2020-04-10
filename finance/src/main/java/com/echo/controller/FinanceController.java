package com.echo.controller;

import com.echo.entity.Finance;
import com.echo.entity.FinanceEntity;
import com.echo.response.R;
import com.echo.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hearecho
 * @createtime 2020/3/30 10:58
 */
@RestController
@RequestMapping("/finance")
public class FinanceController {
    @Autowired
    FinanceService financeService;

    @GetMapping("/all")
    public R query(@RequestParam("query")String query,
                   @RequestParam("pagenum")int pageNum,
                   @RequestParam("pagesize")int pageSize) {
        List<FinanceEntity> all ;
        if ("".equals(query)) {
            all = financeService.getAll();
        } else {
            all = financeService.query(query);
        }
        int from = (pageNum-1)*pageSize;
        int to = pageNum*pageSize;
        int num = all.size();
        if (to > num) {
            to = num;
        }
        List<FinanceEntity> resu = all.subList(from,to);
        return R.ok().data(resu,num);
    }

    @PostMapping("/add")
    public R add(@RequestBody Finance finance) {
        financeService.addEvent(finance);
        return R.ok().message("更新成功");
    }

    @DeleteMapping("/delete/{id}")
    public R deleteStaff(@PathVariable(name = "id") int mid) {
        financeService.delete(mid);
        return R.ok().message("删除成功");
    }

}
