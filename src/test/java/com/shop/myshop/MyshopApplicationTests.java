package com.shop.myshop;

import com.shop.myshop.controller.UserController;
import com.shop.myshop.entity.Cart;
import com.shop.myshop.entity.Order;
import com.shop.myshop.entity.User;
import com.shop.myshop.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyshopApplicationTests {

    @Autowired
    IUserService userServiceImpl;

    @Autowired
    UserController userController;

    @Test
    void test(){
//        Cart cart=new Cart();
//        cart.setPid(10);
//        cart.setUid(1);
//        cart.setNum(1);
//        userController.updateCart(cart);
//        User user=new User();
//        user.setUid(1);
//        userController.pay(user);


    }



}