package com.itheima.ssm.domain;

import com.itheima.ssm.utils.DateFormateUtils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product implements Serializable {
    //产品id
    private String id;
    //产品编号
    private String productNum;
    //产品名称
    private String productName;
    //出发点
    private String cityName;
    //出发时间
    private Date departureTime;
    private String departureTimeStr;
    //产品价格
    private String productPrice;
    //产品描述
    private String productDesc;
    //产品状态
    private Integer productStatus;
    private String productStatusStr;

    @Override
    public String toString() {
        return "product{" +
                "id='" + id + '\'' +
                ", productNum='" + productNum + '\'' +
                ", productName='" + productName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", departureTime=" + departureTime +
                ", departureTimeStr='" + departureTimeStr + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", productStatus=" + productStatus +
                ", productStatusStr='" + productStatusStr + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureTimeStr() {
        if (departureTime != null) {
            departureTimeStr = DateFormateUtils.dateToString(departureTime, "yyyy-MM-dd HH:mm");
        }

        return departureTimeStr;
    }

    public void setDepartureTimeStr(String departureTimeStr) {

        this.departureTimeStr = departureTimeStr;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getproductStatusStr() {
        if (productStatus != null) {
            if (productStatus == 0) {
                productStatusStr = "关闭";
            } else if (productStatus == 1) {
                productStatusStr = "开启";
            }
        }
        return productStatusStr;
    }

    public void setproductStatusStr(String productStatusStr) {

        this.productStatusStr = productStatusStr;
    }
}
