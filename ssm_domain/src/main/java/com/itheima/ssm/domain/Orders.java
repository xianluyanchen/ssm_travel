package com.itheima.ssm.domain;

import com.itheima.ssm.utils.DateFormateUtils;

import java.util.Date;
import java.util.List;

public class Orders {
    /**
     * 额外自己补充的
     * private String productId;
     * private String  memberId
     */

    //无意义、主键uuid
    private String id;
    //订单编号，不为空且 唯一
    private String orderNum;
    //下单时间
    private Date orderTime;
    //下单时间的字符串表示形式
    private String orderTimeStr;

    //订单状态（0 未支付    1 已支付）
    private Integer orderStatus;
    //订单状态的字符串表示形式
    private String orderStatusStr;

    //出行人数
    private Integer peopleCount;

    //用于封装产品信息，数据库表没有
    private Product product;

    //用于封装游客信息，数据库表中没有
    private List<Traveller> travellers;

    //用于封装会员/联系人信息 数据库表中没有
    private Member member;

    //支付方式（0 支付宝    1 微信    2 其他）
    private Integer payType;
    //支付方式的对应表示方式
    private String payTypeStr;

    //订单描述（备注信息或其他信息）
    private String orderDesc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        //下单时间的字符串表示形式
        String pattern = "yyyy-MM-dd HH:mm";
        if (orderTime != null) {
            String dateToString = DateFormateUtils.dateToString(orderTime, pattern);
            orderTimeStr = dateToString;
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusStr() {
        //订单状态（0 未支付    1 已支付）
        if (orderStatus != null) {
            if (orderStatus == 0) {
                orderStatusStr = "未支付";
            } else if (orderStatus == 1) {
                orderStatusStr = "已支付";
            }
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {

        this.orderStatusStr = orderStatusStr;
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
        //支付方式（0 支付宝    1 微信    2 其他）
        if (payType != null) {
            if (payType == 0) {
                payTypeStr = "支付宝";
            } else if (payType == 1) {
                payTypeStr = "微信";

            } else if (payType == 2) {
                payTypeStr = "其他";

            }
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {

        this.payTypeStr = payTypeStr;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }
}
