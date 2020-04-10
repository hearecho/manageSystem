package com.echo.service.impl;

import com.echo.entity.Staff;
import com.echo.mapper.StaffMapper;
import com.echo.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hearecho
 * @createtime 2020/3/15 10:19
 */
@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    StaffMapper staffMapper;

    @Override
    public List<Staff>getOne(int id) {
        return staffMapper.getOneById(id);
    }

    @Override
    public List<Staff> getAll() {
        return staffMapper.getAll();
    }

    @Override
    public void addStaff(Staff staff) {
        staffMapper.addStaff(staff);
    }

    @Override
    public void deleteStaff(int uid) {
        staffMapper.deleteStaff(uid);
    }

    @Override
    public void updateKpi(float kpi, int uid) {
        staffMapper.updateKpi(kpi,uid);
    }

    @Override
    public List<Staff> query(String query) {
        return staffMapper.query(query);
    }

    @Override
    public List<Staff> getList(int type) {
        return staffMapper.getList(type);
    }

    @Override
    public void chPosition(int uid, int type) {
        staffMapper.chPosition(uid,type);
    }
}
