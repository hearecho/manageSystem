package com.echo.controller;

import com.alibaba.fastjson.JSONObject;
import com.echo.entity.AddProcess;
import com.echo.entity.Process;
import com.echo.response.R;
import com.echo.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hearecho
 * @createtime 2020/3/15 13:08
 */
@RestController
@RequestMapping("/process")
@CrossOrigin
public class ProcessController {
    @Autowired
    ProcessService processService;

    @GetMapping("/all")
    public R query(@RequestParam("query")String query,
                   @RequestParam("pagenum")int pageNum,
                   @RequestParam("pagesize")int pageSize) {
        List<Process> all = new ArrayList<>();
        if ("".equals(query)) {
             all = processService.getAll();
        } else {
            all = processService.query(query);
        }
        int from = (pageNum-1)*pageSize;
        int to = pageNum*pageSize;
        int num = all.size();
        if (to > num) {
            to = num;
        }
        List<Process> resu = all.subList(from,to);
        return R.ok().data(resu,num);
    }

    @PostMapping("/add")
    public R add(@RequestBody AddProcess process) {
        processService.addProcess(process);
        return R.ok().message("更新成功");
    }

    @PutMapping("/chsta/{pid}")
    public R changeStatus(@PathVariable("pid")int pid,
                          @RequestBody JSONObject data) {
        int status = (Integer)data.get("status");
        if (status == 1) {
            processService.startProcess(pid);
        } else if (status == 2){
            processService.endProcess(pid);
        } else {
            processService.stopProcess(pid);
        }
        return R.ok();
    }

    @GetMapping("/list/status")
    public R getListByStatus(@RequestParam("query")String query,
                             @RequestParam("pagenum")int pageNum,
                             @RequestParam("pagesize")int pageSize) {
        List<Process> all;
        if (Integer.parseInt(query) == 3) {
            all = processService.getAll();
        } else {
            all = processService.getListByStatus(Integer.parseInt(query));
        }
        int from = (pageNum-1)*pageSize;
        int to = pageNum*pageSize;
        int num = all.size();
        if (to > num) {
            to = num;
        }
        List<Process> resu = all.subList(from,to);
        return R.ok().data(resu,num);
    }


}
