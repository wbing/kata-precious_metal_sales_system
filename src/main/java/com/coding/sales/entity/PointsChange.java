package com.coding.sales.entity;

import java.math.BigDecimal;

public class PointsChange {
    /**
     * 会员卡号
     */
    private String memberId;
    /*
     * 原会员等级
     */
    private String oldMemberType;
    /*
     * 新会员等级
     */
    private String newMemberType;
    /*
     * 本次消费会员新增的积分
     */
    private BigDecimal memberPointsIncreased;
    /*
     * 会员最新的积分
     */
    private BigDecimal memberPoints;
    
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getOldMemberType() {
		return oldMemberType;
	}
	public void setOldMemberType(String oldMemberType) {
		this.oldMemberType = oldMemberType;
	}
	public String getNewMemberType() {
		return newMemberType;
	}
	public void setNewMemberType(String newMemberType) {
		this.newMemberType = newMemberType;
	}
	public BigDecimal getMemberPointsIncreased() {
		return memberPointsIncreased;
	}
	public void setMemberPointsIncreased(BigDecimal memberPointsIncreased) {
		this.memberPointsIncreased = memberPointsIncreased;
	}
	public BigDecimal getMemberPoints() {
		return memberPoints;
	}
	public void setMemberPoints(BigDecimal memberPoints) {
		this.memberPoints = memberPoints;
	}
    
}
