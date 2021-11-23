package com.shop.myshop.service.impl;

import com.shop.myshop.entity.Cart;
import com.shop.myshop.entity.Order;
import com.shop.myshop.entity.Production;
import com.shop.myshop.entity.User;
import com.shop.myshop.mapper.UserMapper;
import com.shop.myshop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    JavaMailSender javaMailSender;
    @Override
    public User login(User user) {
        return userMapper.getUserByNameAndPass(user);
    }

    @Override
    public List<Production> getProducts() {
        return userMapper.selectAllPro();
    }

    @Override
    public List<Order> getUserOrder(User user) {
        return userMapper.selectAllOrder(user);
    }

    @Override
    public List<Cart> getUserCart(User user) {
        return userMapper.SelectCart(user);
    }

    @Override
    public boolean deleteProFromCart(Cart cart) {
        return userMapper.deletePro(cart)>0;

    }

    @Override
    public boolean Pay(User user) {
        List<Cart> cart=userMapper.SelectCart(user);
        for(Cart c:cart) {
            user=userMapper.getUserByUid(user.getUid());
            Order order=new Order();
            order.setNum(c.getNum());
            order.setUid(c.getUid());
            order.setPname(c.getPname());
            order.setUsername(user.getUsername());
            order.setMail(user.getMail());
            System.out.println(order);
            userMapper.insertProIntoOrder(order);
            userMapper.updateSold(c);
            this.verityMail(order);

        }
        return userMapper.deleteCart(user)>0;
    }

    @Override
    public boolean register(User user) {
        return userMapper.insertNewUser(user)>0;
    }

    @Override
    public boolean verityMail(Order order) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("shopmail_noreply@163.com");
        message.setSubject("订单提交成功通知");
        message.setTo(order.getMail());
        message.setSentDate(new Date());
        message.setText("用户"+order.getUsername()+",你的订单"+order.getOid()+"已经提交了,\n 您购买了"+order.getNum()+"件"+order.getPname()+",\n 谢谢您的惠顾");
        javaMailSender.send(message);
        return true;
    }

    @Override
    public boolean updateCart(Cart cart){
        return userMapper.updateProInCart(cart)>0;
    }

    @Override
    public boolean addToCart(Cart cart) {
        cart.setPrice(userMapper.getProByPid(cart.getPid()).getPrice());
        return userMapper.insertProIntoCart(cart)>0;
    }


}
