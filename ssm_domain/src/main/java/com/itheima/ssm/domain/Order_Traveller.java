package com.itheima.ssm.domain;

/**
 * 本表无意义，用来表明数据库中的表
 * 数据库中此表的意义是：作为多对多关系的中间表
 */
public class Order_Traveller {
    private String orderId; //订单id
    private String travellerId;//旅客id
}
