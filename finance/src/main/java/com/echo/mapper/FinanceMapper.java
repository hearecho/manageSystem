package com.echo.mapper;

import com.echo.entity.Finance;
import com.echo.entity.FinanceEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author hearecho
 * @createtime 2020/3/30 10:24
 */
@Mapper
public interface FinanceMapper {
    @Select("select * from finance where ocdate >= #{start}")
    @Results(
            @Result(property = "staff", column = "uid", one = @One(select = "com.echo.mapper.StaffMapper.getOneById"))
    )
    List<FinanceEntity> query(String start);

    @Select("select * from finance")
    @Results(
            @Result(property = "staff", column = "uid", one = @One(select = "com.echo.mapper.StaffMapper.getOneById"))
    )
    List<FinanceEntity> getAll();

    @Insert("insert into finance(event,event_type,money,uid,ocdate) values(#{event},#{eventType},#{money},#{uid},#{ocdate})")
    void addEvent(Finance f);

    @Delete("delete from finance where mid = #{mid}")
    void delete(int mid);

}
