package com.shop.myshop.mapper;

import com.shop.myshop.entity.Cart;
import com.shop.myshop.entity.Order;
import com.shop.myshop.entity.Production;
import com.shop.myshop.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface UserMapper {
    //向购物车添加一件商品
    @Insert("Insert into cart(pid,uid,num,pname,url,price) values(#{pid},#{uid},#{num},#{pname},#{url},#{price})")
    public int insertProIntoCart(Cart cart);//todo
    //从购物车中删除一件商品
    @Delete("delete from cart where pid=#{pid} and uid=#{uid}")
    public int deletePro(Cart cart);
    //获取个人订单
    @Select("select * from orders where uid=#{uid}")
    public List<Order> selectAllOrder(User user);
    //获取用户的购物车
    @Select("select * from cart where uid=#{uid}")
    public List<Cart> SelectCart(User user);
    //获取用户
    @Select("select * from user where username=#{username} and password=#{password}")
    public User getUserByNameAndPass(User user);
    //清空购物车
    @Delete("delete from cart where uid=#{uid}")
    public int deleteCart(User user);
    //把购物车的东西放到订单下
    @Insert("Insert into orders(pname,num,username,uid,mail) values(#{pname},#{num},#{username},#{uid},#{mail})")
    @Options(useGeneratedKeys = true,keyProperty = "oid")
    public int insertProIntoOrder(Order order);
    //获取所有商品信息
    @Select("Select pid,pname,detail,price,url from production")
    public List<Production> selectAllPro();
    //更新
    @Update("Update cart set num=#{num} where pid=#{pid}")
    public int updateProInCart(Cart cart);//todo
    @Update("Update production set sold=sold+#{num} where pid=#{pid}")
    public boolean updateSold(Cart cart);
    //注册账号
    @Insert("insert into user(username,password,mail) values(#{username},#{password},#{mail})")
    public int insertNewUser(User user);
    @Select("select * from user where uid=#{uid}")
    public User getUserByUid(int uid);
    @Select("Select * from production where pid=#{pid}")
    public Production getProByPid(int pid);


}
