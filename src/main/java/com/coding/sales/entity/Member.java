package com.coding.sales.entity;

import com.coding.sales.constant.MemberGrade;

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
    private MemberGrade memberGrade;
    /**
     * 会员积分
     */
    private BigDecimal memberPoints;
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
    public BigDecimal getMemberPoints() {
        return memberPoints;
    }

    public void setMemberPoints(BigDecimal memberPoints) {
        this.memberPoints = memberPoints;
    }

    public MemberGrade getMemberGrade() {
        return memberGrade;
    }

    public void setMemberGrade(MemberGrade memberGrade) {
        this.memberGrade = memberGrade;
    }

    public Member() {
    }

    public Member(String memberId, String memberName, MemberGrade memberGrade, BigDecimal memberPoints) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberGrade = memberGrade;
        this.memberPoints = memberPoints;
    }
}
