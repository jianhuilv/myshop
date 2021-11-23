package com.shop.myshop.controller;

import com.shop.myshop.controller.utils.R;
import com.shop.myshop.entity.Cart;
import com.shop.myshop.entity.Production;
import com.shop.myshop.entity.User;
import com.shop.myshop.service.IAdminService;
import com.shop.myshop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService UserServiceImpl;

    @PostMapping("/login")
    public R login(User user, HttpServletRequest request){
        user=UserServiceImpl.login(user);
        HttpSession session=request.getSession();
        session.setAttribute("user",user);
        return new R(true,user);
    }

    @PostMapping("/register")
    public R register(User user){
        return new R(UserServiceImpl.register(user));
    }

    @GetMapping("/showPro")
    public R showProductions(){
        return new R(true,UserServiceImpl.getProducts());
    }

    @GetMapping("/showOrder")
    public R showUserOrder(User user){
        return new R(true,UserServiceImpl.getUserOrder(user));
    }

    @GetMapping("/showCart")
    public R showUserCart(User user){
        return new R(true,UserServiceImpl.getUserCart(user));
    }

    @GetMapping("deleteProFromCart")
    public R deleteProFromCart(Cart cart){
        return new R(UserServiceImpl.deleteProFromCart(cart));
    }

    @GetMapping("/pay")
    public R pay(User user){
         return new R(UserServiceImpl.Pay(user));
    }

    @GetMapping("/logout")
    public R logout(User user,HttpServletRequest request) {
        request.getSession().invalidate();
        return new R(true);
    }

    @GetMapping("/updateCart")
    public R updateCart(Cart cart){
        return new R(UserServiceImpl.updateCart(cart));
    }

    @PostMapping("/addToCart")
    public R addToCart(Cart cart){
        return  new R(UserServiceImpl.addToCart(cart));
    }

}
