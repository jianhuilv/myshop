package com.shop.myshop.service;

import com.shop.myshop.entity.Order;
import com.shop.myshop.entity.Production;
import com.shop.myshop.mapper.ProMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IAdminService {

    public List<Production> getProducts();
    public boolean deleteProduct(int production);
    public boolean addProduct(Production production);
    public boolean updateProduct(Production production);
    public List<Order> selectOrder();
    public boolean changeImage(Production production);
}
