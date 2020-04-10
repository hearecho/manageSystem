package com.echo.mapper;

import com.echo.entity.Process;
import com.echo.entity.Sell;
import com.echo.entity.SellEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author hearecho
 * @createtime 2020/4/2 18:25
 */
@Mapper
public interface SellMapper {
    @Select("select * from sell where occur >= #{start}")
    @Results({
            @Result(property = "product", column = "cid", one = @One(select = "com.echo.mapper.ProductMapper.getById")),
            @Result(property = "staff", column = "uid", one = @One(select = "com.echo.mapper.StaffMapper.getOneById"))
    })
    List<SellEntity> query(String start);

    @Select("select * from sell ")
    @Results({
            @Result(property = "product", column = "cid", one = @One(select = "com.echo.mapper.ProductMapper.getById")),
            @Result(property = "staff", column = "uid", one = @One(select = "com.echo.mapper.StaffMapper.getOneById"))
    })
    List<SellEntity> getAll();

    @Insert("insert into sell(cid,uid,snum,occur) values(#{cid},#{uid},#{snum},#{occur})")
    void addSell(Sell sell);

    @Delete("delete from sell where sid = #{sid}")
    void delete(int sid);

    @Select("select * from sell order by occur desc limit 4")
    @Results({
            @Result(property = "product", column = "cid", one = @One(select = "com.echo.mapper.ProductMapper.getById")),
            @Result(property = "staff", column = "uid", one = @One(select = "com.echo.mapper.StaffMapper.getOneById"))
    })
    List<SellEntity> getRecent();

}
