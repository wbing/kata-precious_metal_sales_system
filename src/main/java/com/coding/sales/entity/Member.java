package com.coding.sales.entity;

import java.math.BigDecimal;

public class Member {
    /**
     * 会员卡号
     */
    private String memberId;
    /**
     * 会员姓名
     */
    private String memberName;
    /**
     * 会员等级
     */
    private String memberType;
    /**
     * 会员积分
     */
    private BigDecimal memberPoints;
    /**
     * 会员等级号
     */
    private String memberTypeNo;
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public BigDecimal getMemberPoints() {
        return memberPoints;
    }

    public void setMemberPoints(BigDecimal memberPoints) {
        this.memberPoints = memberPoints;
    }

	public String getMemberTypeNo() {
		return memberTypeNo;
	}

	public void setMemberTypeNo(String memberTypeNo) {
		this.memberTypeNo = memberTypeNo;
	}
    
}
