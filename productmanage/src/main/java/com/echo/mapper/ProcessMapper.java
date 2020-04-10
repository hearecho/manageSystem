package com.echo.mapper;

import com.echo.entity.AddProcess;
import com.echo.entity.Process;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author hearecho
 * @createtime 2020/3/15 12:34
 */
@Mapper
public interface ProcessMapper {
    @Select("select * from process where start >= #{start}")
    @Results({
            @Result(property = "product", column = "cid", one = @One(select = "com.echo.mapper.ProductMapper.getById")),
            @Result(property = "staff", column = "uid", one = @One(select = "com.echo.mapper.StaffMapper.getOneById"))
    })
    List<Process> query(String start);

    @Select("select * from process ")
    @Results({
            @Result(property = "product", column = "cid", one = @One(select = "com.echo.mapper.ProductMapper.getById")),
            @Result(property = "staff", column = "uid", one = @One(select = "com.echo.mapper.StaffMapper.getOneById"))
    })
    List<Process> getAll();

    @Select("select * from process where status = #{status} ")
    @Results({
            @Result(property = "product", column = "cid", one = @One(select = "com.echo.mapper.ProductMapper.getById")),
            @Result(property = "staff", column = "uid", one = @One(select = "com.echo.mapper.StaffMapper.getOneById"))
    })
    List<Process> getListByStatus(int status);

    @Insert("insert into process(cid,uid,pnum,status,start) values(#{cid},#{uid},#{pnum},#{status},#{start})")
    void addProcess(AddProcess process);

    @Update("update process set status = 0 where pid = #{pid}")
    void stopProcess(int pid);

    @Update("update process set status = 2 where pid = #{pid}")
    void endProcess(int pid);

    @Update("update process set status = 1 where pid = #{pid}")
    void startProcess(int pid);
}
