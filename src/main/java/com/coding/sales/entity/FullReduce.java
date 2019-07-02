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
        if(isCount){
            this.fullCount=full;
            this.reduceCount=reduce;
        }else {
            this.full = full;
            this.reduce = reduce;
        }
        this.isCount=isCount;
    }

    public BigDecimal getFullCount() {
        return fullCount;
    }

    public void setFullCount(BigDecimal fullCount) {
        this.fullCount = fullCount;
    }

    public BigDecimal getReduceCount() {
        return reduceCount;
    }

    public void setReduceCount(BigDecimal reduceCount) {
        this.reduceCount = reduceCount;
    }

    public Boolean getIsCount() {
        return isCount;
    }

    public void setIsCount(Boolean count) {
        isCount = count;
    }
}
