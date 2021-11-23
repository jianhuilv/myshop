package com.shop.myshop.service;

import com.shop.myshop.entity.Cart;
import com.shop.myshop.entity.Order;
import com.shop.myshop.entity.Production;
import com.shop.myshop.entity.User;

import java.util.List;

public interface IUserService {
    public User login(User user);
    public List<Production> getProducts();
    public List<Order> getUserOrder(User user);
    public List<Cart> getUserCart(User user);
    public boolean deleteProFromCart(Cart cart);
    public boolean Pay(User user);
    //public boolean logout(User user);
    public boolean register(User user);
    //发送订单告知已经发送
    public boolean verityMail(Order order);
    public boolean updateCart(Cart cart);
    //todo 邮箱验证登陆，有时间就做
    //todo public boolean verityMailForRegister(User user);
    public boolean addToCart(Cart cart);
}
