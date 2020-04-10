package com.echo.service.impl;

import com.echo.entity.AddProcess;
import com.echo.entity.Process;
import com.echo.mapper.ProcessMapper;
import com.echo.service.ProcessService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hearecho
 * @createtime 2020/3/15 13:45
 */
@Service
public class ProcessServiceImpl implements ProcessService {
    @Autowired
    ProcessMapper processMapper;

    @Override
    public List<Process> query(String start) {
        return processMapper.query(start);
    }

    @Override
    public List<Process> getAll() {
        return processMapper.getAll();
    }

    @Override
    public void addProcess(AddProcess process) {
        process.setStatus(1);
        processMapper.addProcess(process);
    }

    @Override
    public void stopProcess(int pid) {
        processMapper.stopProcess(pid);
    }

    @Override
    public void endProcess(int pid) {
        processMapper.endProcess(pid);
    }

    @Override
    public void startProcess(int pid) {
        processMapper.startProcess(pid);
    }

    @Override
    public List<Process> getListByStatus(int status) {
        return processMapper.getListByStatus(status);
    }
}
