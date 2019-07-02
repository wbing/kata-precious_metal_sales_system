package com.coding.sales.constant;

import java.math.BigDecimal;

public enum DiscountType {
    NINE(new BigDecimal("0.9"),"9折券"),NINEFIVE(new BigDecimal("0.95"),"95折券");
    DiscountType(BigDecimal value,String display){
        this.value=value;
        this.display=display;
    }
    private String display;
    private BigDecimal value;

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
