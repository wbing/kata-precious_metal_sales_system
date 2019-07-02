package com.coding.sales.entity;

import java.math.BigDecimal;
import java.util.List;

public class Product {

    /**
     * 编号
     */
    private String productNo;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 单价
     */
    private BigDecimal price;
    /**
     * 单位
     */
    private String unit;
    /**
     * 折扣类型
     */

    private String discount;
    /**
     * 满减
     */
    private List fullReduce;

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public List getFullReduce() {
        return fullReduce;
    }

    public void setFullReduce(List fullReduce) {
        this.fullReduce = fullReduce;
    }
}

