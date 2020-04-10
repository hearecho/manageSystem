package com.echo.service;

import com.echo.entity.Staff;
import com.echo.mapper.StaffMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author hearecho
 * @createtime 2020/3/15 10:18
 */
public interface StaffService {
    List<Staff>getOne(int id);
    List<Staff> getAll();
    List<Staff> query(String query);
    void addStaff(Staff staff);
    void deleteStaff(int uid);
    void updateKpi(float kpi,int uid);
    List<Staff> getList(int type);
    void chPosition(int uid,int type);
}
