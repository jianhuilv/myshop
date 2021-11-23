package com.shop.myshop.service.impl;

import com.shop.myshop.entity.Order;
import com.shop.myshop.entity.Production;
import com.shop.myshop.mapper.ProMapper;
import com.shop.myshop.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    ProMapper proMapper;

    @Override
    public List<Production> getProducts() {
        return proMapper.selectAllPro();
    }

    @Override
    public boolean deleteProduct(int pid) {
        return proMapper.deletePro(pid);
    }

    @Override
    public boolean addProduct(Production production) {
        return proMapper.insertPro(production);
    }

    @Override
    public boolean updateProduct(Production production) {
        return proMapper.updatePro(production);
    }

    @Override
    public List<Order> selectOrder() {
        return proMapper.selectAllOrder();
    }

    @Override
    public boolean changeImage(Production production) {
        return proMapper.updateImage(production);
    }


}
