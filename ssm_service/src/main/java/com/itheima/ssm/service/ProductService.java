package com.itheima.ssm.service;

import com.itheima.ssm.domain.Product;

import java.util.List;

public interface ProductService {
    /**
     * 查询所有
     * @return
     */
    public List<Product> findAll();

    /**
     * 插入产品信息
     * @param product
     * @return
     */
    public String saveProductReturnId(Product product);


    /**
     * 通过id查询产品信息
     * @param id
     * @return
     */
    public Product findById(String id);

    /**
     * 插入产品信息
     * @param product
     */
    void saveProduct(Product product);
}
