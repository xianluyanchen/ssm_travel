package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface ProductDao {

    /**
     * 查询所有商品路线信息
     * @return
     */
    @Select("select * from product")
    List<Product> findAll();

    /**
     * 插入商品并返回主键
     * @param product
     * @return
     */
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    @SelectKey(keyProperty = "id", keyColumn = "id",resultType = String.class,before=true,statement = "select last_insert_id()")
    public String saveProductReturnId(Product product);

    /**
     * 根据id查询商品
     * @param id
     * @return
     */
    @Select("select * from product where id = #{idd}")
    public Product findById(String id);

    /**
     * 增加/插入商品
     * @param product
     */
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void saveProduct(Product product);
}
