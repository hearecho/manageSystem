package com.echo.controller;

import com.alibaba.fastjson.JSONObject;
import com.echo.entity.Staff;
import com.echo.exception.CMSException;
import com.echo.response.R;
import com.echo.response.ResultCodeEnum;
import com.echo.service.StaffService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hearecho
 * @createtime 2020/3/15 10:19
 */
@RestController
@RequestMapping("/staff")
@CrossOrigin
public class MainController {
    @Autowired
    StaffService staffService;

    @GetMapping("/{id}")
    public R getOne(@PathVariable(name = "id") int id ) {
        List<Staff> staffs = staffService.getOne(id);
        if (staffs.size() == 0) {
            throw new CMSException(ResultCodeEnum.DB_ERROR);
        }
        return R.ok().data(staffs,staffs.size());
    }

    @GetMapping("/all")
    public R query(@RequestParam("query")String query,
                   @RequestParam("pagenum")int pageNum,
                   @RequestParam("pagesize")int pageSize) {
        List<Staff> all = staffService.query(query);
        int from = (pageNum-1)*pageSize;
        int to = pageNum*pageSize;
        int num = all.size();
        if (to > num) {
            to = num;
        }
        List<Staff> resu = all.subList(from,to);
        return R.ok().data("items",resu,num);
    }


    @PostMapping("/add")
    public R addStaff(@RequestBody Staff staff) {
        staffService.addStaff(staff);
        return R.ok().message("添加完成");
    }

    @DeleteMapping("/delete/{id}")
    public R deleteStaff(@PathVariable(name = "id") int uid) {
        staffService.deleteStaff(uid);
        return R.ok().message("删除成功");
    }

    @PutMapping("/update/{uid}")
    public R updateKpi(@RequestBody JSONObject data,
                       @PathVariable(name = "uid")int uid) {
        staffService.updateKpi(((Double)data.get("kpi")).floatValue(),uid);
        return R.ok().message("更新完成");
    }

    @GetMapping("/list/type/{type}")
    public R getList(@PathVariable("type") int type) {
        List<Staff> all;
        if (type == 3) {
            all = staffService.getAll();
        } else {
            all = staffService.getList(type);
        }
        return R.ok().data(all,all.size());
    }
    @PutMapping("/chtype/{uid}")
    public R chPosition(@RequestBody JSONObject data,
                       @PathVariable(name = "uid")int uid) {
        staffService.chPosition(uid,(Integer)data.get("type"));
        return R.ok().message("更新完成");
    }
}
