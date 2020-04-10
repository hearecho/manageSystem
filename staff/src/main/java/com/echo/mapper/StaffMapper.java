package com.echo.mapper;

import com.echo.entity.Staff;
import org.apache.ibatis.annotations.*;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author hearecho
 * @createtime 2020/3/15 10:12
 */
@Mapper
public interface StaffMapper {
    @Select("select * from staff")
    List<Staff> getAll();

    @Select("select * from staff where uid = #{id}")
    List<Staff> getOneById(int id);

    @Select("select * from staff where uname like '${query}%'")
    List<Staff> query(@Param("query") String query);


    @Insert("insert staff(uname,type,age,sex,kpi) values(#{uname},#{type},#{age},#{sex},0)")
    @Options(useGeneratedKeys=true, keyProperty="uid", keyColumn="uid")
    void addStaff(Staff staff);

    @Delete("delete from staff where uid = #{uid}")
    void deleteStaff(int uid);

    @Update("update staff set kpi = kpi + #{kpi} where uid = #{uid}")
    void updateKpi(@Param("kpi") float kpi,@Param("uid") int uid);

    @Select("select * from staff where type = #{type}")
    List<Staff> getList(int type);

    @Update("update staff set type=#{type} where uid = #{uid}")
    void chPosition(@Param("uid")int uid,@Param("type")int type);

}
