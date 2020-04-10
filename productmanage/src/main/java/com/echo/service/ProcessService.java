package com.echo.service;

import com.echo.entity.AddProcess;
import com.echo.entity.Process;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hearecho
 * @createtime 2020/3/15 13:34
 */
@Service
public interface ProcessService {
    /**
     * 获得所有的生产线
     * @return
     */
    List<Process> getAll();

    List<Process> query(String start);
    /**
     * 增加生产线
     * @param process
     */
    void addProcess(AddProcess process);

    /**
     * 暂停生产线
     * @param pid
     */
    void stopProcess(int pid);

    /**
     * 完成生产线
     * @param pid
     */
    void endProcess(int pid);

    void startProcess(int pid);

    List<Process> getListByStatus(int status);

}
