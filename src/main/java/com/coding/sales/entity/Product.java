package com.coding.sales.entity;

import com.coding.sales.constant.DiscountType;

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

    private DiscountType discount;
    /**
     * 满减
     */
    private List<FullReduce> fullReduce;

    /**
     * @param productNo
     * @param productName
     * @param price
     * @param unit
     * @param discount
     * @param fullReduce
     */
    public Product(String productNo, String productName, BigDecimal price, String unit, DiscountType discount, List<FullReduce> fullReduce) {
        this.productNo = productNo;
        this.productName = productName;
        this.price = price;
        this.unit = unit;
        this.discount = discount;
        this.fullReduce = fullReduce;
    }

    public Product() {
    }

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

    public DiscountType getDiscount() {
        return discount;
    }

    public void setDiscount(DiscountType discount) {
        this.discount = discount;
    }

    public List<FullReduce> getFullReduce() {
        return fullReduce;
    }

    public void setFullReduce(List<FullReduce> fullReduce) {
        this.fullReduce = fullReduce;
    }
}

