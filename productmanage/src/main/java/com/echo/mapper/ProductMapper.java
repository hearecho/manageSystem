package com.echo.mapper;

import com.echo.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author hearecho
 * @createtime 2020/3/15 12:44
 */
@Mapper

public interface ProductMapper {
    @Select("select * from product")
    List<Product> getAll();

//    @Select("select * from product where cid = #{id}")
//    List<Product> getById(int id);

    @Select("select * from product order by cost desc limit 4")
    List<Product> getMostNum();

    @Select("select * from product where cname like '${query}%'")
    List<Product> query(@Param("query") String query);

    @Insert("insert product(cname,cnum,cost,price) values(#{cname},#{cnum},#{cost},#{price})")
    void add(Product p);

    @Update("update product set cnum = cnum + #{cnum} where cid = #{cid}")
    void changeCnum(@Param("cid") int cid,@Param("cnum") int cnum);

    @Update("update product set cost = #{cost},price = #{price} where cid = #{cid}")
    void changeCostOrPrice(@Param("cid") int cid,@Param("cost") int cost,@Param("price") int price);

    @Delete("delete from product where cid = #{cid}")
    void deleteProduct(int cid);

    @Select("select * from product where cid = #{id}")
    Product getById(int id);

}
