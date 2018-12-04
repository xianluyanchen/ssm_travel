package com.itheima.ssm.dao;


import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.domain.Product;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import javax.naming.spi.ResolveResult;
import java.util.List;

public interface OrdersDao {

    @Select("select * from orders")
    @Results({
            @Result(id=true ,property ="id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one=@One(select="com.itheima.ssm.dao.ProductDao.findById")),
    })
    public List<Orders> findAll();

    @Select("select * from orders where id = #{orderId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "orderDesc", column = "orderDesc"),
            //查询该订单的产品信息
            @Result(property = "product", column = "productiId", one = @One(select="com.itheima.ssm.dao.productDao.findById")),
            //查询
            @Result()

    })
    Orders findById(Integer id);
}
