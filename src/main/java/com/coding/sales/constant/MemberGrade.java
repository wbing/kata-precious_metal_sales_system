package com.coding.sales.constant;

import java.math.BigDecimal;
/*
 * 会员等级信息
 * 
 */
public enum MemberGrade {
    ONE(Integer.valueOf(1),"普卡",new BigDecimal("1"),new BigDecimal("0"),new BigDecimal("10000")),
    TWO(Integer.valueOf(2),"金卡",new BigDecimal("1.5"),new BigDecimal("10000"),new BigDecimal("50000")),
	THREE(Integer.valueOf(3),"白金卡",new BigDecimal("1.8"),new BigDecimal("50000"),new BigDecimal("100000")),
	Four(Integer.valueOf(4),"钻石卡",new BigDecimal("2"),new BigDecimal("100000"),new BigDecimal("999999999"));
    MemberGrade(int gradeType,String grade,BigDecimal multiple,BigDecimal minPoints,BigDecimal maxPoints){
        this.gradeType=gradeType;
        this.grade=grade;
        this.multiple=multiple;
        this.minPoints=minPoints;
        this.maxPoints=maxPoints;
    }
    /*
     * 会员类型
     */
    private int gradeType;
    /*
     * 会员等级
     */
    private String grade;
    /*
     * 积分倍数
     */
    private BigDecimal multiple;
    /*
     * 最小积分
     */
    private BigDecimal minPoints;
    /*
     * 最大积分
     */
    private BigDecimal maxPoints;

	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public BigDecimal getMultiple() {
		return multiple;
	}
	public void setMultiple(BigDecimal multiple) {
		this.multiple = multiple;
	}
	public BigDecimal getMinPoints() {
		return minPoints;
	}
	public void setMinPoints(BigDecimal minPoints) {
		this.minPoints = minPoints;
	}
	public BigDecimal getMaxPoints() {
		return maxPoints;
	}
	public void setMaxPoints(BigDecimal maxPoints) {
		this.maxPoints = maxPoints;
	}
	public int getGradeType() {
		return gradeType;
	}
	public void setGradeType(int gradeType) {
		this.gradeType = gradeType;
	}
	
}
