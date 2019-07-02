package com.coding.sales.entity;

import java.math.BigDecimal;

public class FullReduce {
    private BigDecimal full;
    private BigDecimal reduce;
    private BigDecimal fullCount;
    private BigDecimal reduceCount;
    private Boolean isCount;

    public BigDecimal getFull() {
        return full;
    }

    public void setFull(BigDecimal full) {
        this.full = full;
    }

    public BigDecimal getReduce() {
        return reduce;
    }

    public void setReduce(BigDecimal reduce) {
        this.reduce = reduce;
    }

    public FullReduce() {
    }

    public FullReduce(BigDecimal full, BigDecimal reduce,Boolean isCount) {
        this.full = full;
        this.reduce = reduce;
        this.isCount=isCount;
    }



}
