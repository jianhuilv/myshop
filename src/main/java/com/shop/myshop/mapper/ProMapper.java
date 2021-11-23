package com.shop.myshop.mapper;

import com.shop.myshop.entity.Order;
import com.shop.myshop.entity.Production;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface ProMapper {
    @Insert("insert into production(pname,detail,price,image,sold,url) values(#{pname},#{detail},#{price},#{image},#{sold},#{url})")
    public boolean insertPro(Production production);
    @Delete("delete from production where pid=#{pid}")
    public boolean deletePro(int pid);
    @Update("update production set pname=#{pname},detail=#{detail},price=#{price} where pid=#{pid}")
    public boolean updatePro(Production production);
    @Select("Select * from production")
    public List<Production> selectAllPro();
    @Select("Select * from orders")
    public List<Order> selectAllOrder();
    @Update("update production set pname=#{pname},detail=#{detail},price=#{price},image=#{image},url=#{url} where pid=#{pid}")
    public boolean updateImage(Production production);

}
