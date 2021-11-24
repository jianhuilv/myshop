package com.shop.myshop.controller;

import com.shop.myshop.controller.utils.R;
import com.shop.myshop.entity.Production;
import com.shop.myshop.entity.User;
import com.shop.myshop.service.IAdminService;
import com.shop.myshop.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    IAdminService adminServiceImpl;

    @GetMapping("/showPro")
    public R showProductions(){
        return new R(true, adminServiceImpl.getProducts());
    }

    @GetMapping("showOrder")
    public R showUserOrder(User user){
        return new R(true,adminServiceImpl.selectOrder());
    }

    @GetMapping("deletePro/{pid}")
    public R deletePro(@PathVariable int pid){
        return new R(adminServiceImpl.deleteProduct(pid));
    }


    @PostMapping("/updatePro")
    public R updateProduct(Production production){
        return new R(adminServiceImpl.updateProduct(production));
    }

    @PostMapping("/changeImage")
    public R changeImage(Production production){
        if(production.getImage_file().isEmpty()){
            return new R(false);
        }
        String rand=(int)(Math.random()*100000)+"";
        String fileName=rand+production.getImage_file().getOriginalFilename();
        //String filePath="C:/Users/69060/Desktop/image/datatest/"+production.getPname()+"/";
        String filePath="/usr/local/nginx/html/shop/data/image/"+production.getPname()+"/";
        production.setImage(filePath+fileName);
        production.setUrl("http://121.40.202.71/shop/data/image/"+production.getPname()+"/"+fileName);
        if(!(fileName.endsWith(".jpg")||fileName.endsWith(".jpeg")||fileName.endsWith("png")))
        {
            return new R(false);
        }
        adminServiceImpl.changeImage(production);
        File folder=new File(filePath);
        if(!folder.isDirectory()){
            folder.mkdirs();
        }
        File image=new File(filePath+fileName);
        try {
            production.getImage_file().transferTo(image);
            return new R(true);
        } catch (IOException e) {
            e.printStackTrace();
            return new R(false);
        }
    }

    @PostMapping("/addPro")
    public R addPro(Production production){
        if(production.getImage_file().isEmpty()){
            return new R(false);
        }
        String rand=(int)(Math.random()*100000)+"";
        String fileName=rand+production.getImage_file().getOriginalFilename();
        //String filePath="/usr/local/nginx/html/shop/data/image/"+production.getPname()+"/";
        String filePath="/usr/local/nginx/html/shop/data/image/"+production.getPname()+"/";
        production.setImage(filePath+fileName);
        production.setUrl("http://121.40.202.71/shop/data/image/"+production.getPname()+"/"+fileName);
        if(!(fileName.endsWith(".jpg")||fileName.endsWith(".jpeg")||fileName.endsWith("png")))
        {
            return new R(false);
        }
        adminServiceImpl.addProduct(production);
        File folder=new File(filePath);
        if(!folder.isDirectory()){
            folder.mkdirs();
        }
        File image=new File(filePath+fileName);
        try {
            production.getImage_file().transferTo(image);
            return new R(true);
        } catch (IOException e) {
            e.printStackTrace();
            return new R(false);
        }
    }

}
