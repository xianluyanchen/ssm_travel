package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.ProductDao;
import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.ProductService;
import com.itheima.ssm.utils.DateFormateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAll() {
        List<Product> productList = productDao.findAll();
        return productList;
    }

    /**
     * 保存产品信息
     * @param product
     */
    @Override
    public void saveProduct(Product product) {
        String departureTimeStr = product.getDepartureTimeStr();
        String pattern = "yyyy-MM-dd HH:mm";
        try {
            Date departureTime = DateFormateUtils.stringToDate(departureTimeStr, pattern);
            product.setDepartureTime(departureTime);
            System.out.println("====service===");
            System.out.println(product);
            productDao.saveProduct(product);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加商品信息（旅游线路）
     * @param product
     */
    @Override
    public String saveProductReturnId(Product product) {
        String s = productDao.saveProductReturnId(product);
        return s;
    }

    /**
     * 通过id查询产品信息
     * @param id
     * @return
     */
    @Override
    public Product findById(String id) {
        Product product = productDao.findById(id);
        return product;
    }
}
