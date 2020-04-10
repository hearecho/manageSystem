package com.echo.mapper;

import com.echo.entity.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hearecho
 * @createtime 2020/4/1 21:46
 */
@Mapper
public interface StaffMapper {
    @Select("select * from staff where uid = #{id}")
    Staff getOneById(int id);
}
