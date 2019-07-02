package com.coding.sales.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.coding.sales.constant.MemberGrade;
import com.coding.sales.entity.Member;

/*
 * 会员等级及积分计算 add by ycs 20190702
 */
public class PointsCalculator {
	
	public Map memberPAGCla(String memberId, BigDecimal receivables){
		
		//会员等级及积分信息
		Map memberTypeInfo = new HashMap();
		//会员积分计算
		Map pointsMap = pointCla(memberId,receivables);
		BigDecimal memberPointsIncreased = (BigDecimal) pointsMap.get("MemberPointsIncreased");
		//会员等级计算
		Map gradeMap = gradeCla(memberId);
		
		return memberTypeInfo;
	}
	/*
	 * 会员积分计算
	 * input 
	 * 		String memberId-会员ID
	 * 		BigDecimal receivables-应收金额
	 * output
	 * 		Map pointClaMap-会员积分信息
	 */
	private Map pointCla(String memberId, BigDecimal receivables){
		
		Map pointClaMap = new HashMap();
		Member member = InitData.memberMap.get("memberId");
		//获得用户对应会员等级的积分规则
		MemberGrade memberGrade = member.getMemberGrade();
		BigDecimal multiple = memberGrade.getMultiple();//积分倍数
		BigDecimal memberPointsIncreased = receivables.multiply(multiple);//本次消费会员新增的积分
		BigDecimal memberPoints = member.getMemberPoints().add(memberPointsIncreased);//会员最新的积分
		//更新最新积分至用户对象
		member.setMemberPoints(memberPoints);
		
		pointClaMap.put("MemberPointsIncreased", memberPointsIncreased);//本次消费会员新增的积分
		pointClaMap.put("MemberId", member.getMemberId());//会员ID
		pointClaMap.put("MemberPoints", memberPoints);//会员最新积分
		
		return pointClaMap;
	}
	/*
	 * 会员等级计算
	 * input 
	 * 		String memberId-会员ID
	 * output
	 * 		Map gradeMap-会员等级变化
	 * 
	 */
	private Map gradeCla(String memberId){
		Map gradeMap = new HashMap();
		//会员等级变化标志
		boolean gradeChangeFlag = false;
		Member member = InitData.memberMap.get("memberId");
		//老会员等级
		String oldMemberType = member.getMemberGrade().getGrade();
		//获取会员最新积分
		BigDecimal memberPoints = member.getMemberPoints();
		//获得用户对应会员等级的积分规则
		MemberGrade memberGrade = member.getMemberGrade();
		BigDecimal maxPoints = memberGrade.getMaxPoints();
		
		//新会员等级
		String newMemberType = oldMemberType;
		if(memberPoints.compareTo(maxPoints) > 0){
			gradeChangeFlag = true;
			newMemberType = gradeChange(memberPoints,maxPoints,memberGrade.getGrade(),memberGrade.getGradeType());
			
		}
		
		
		gradeMap.put("OldMemberType", oldMemberType);
		gradeMap.put("NewMemberType", newMemberType);
		gradeMap.put("GradeChangeFlag", gradeChangeFlag);
		
		return gradeMap;
		
	}
	/*
	 * 根据积分计算会员等级
	 * input 
	 * 		BigDecimal memberPoints-当前积分
	 * 		BigDecimal maxPoints-当前等级对应的最大积分
	 * 		String grade-当前等级名称
	 * output
	 * 		String NewMemberType-新会员等级
	 * 
	 */
	private String gradeChange(BigDecimal memberPoints,BigDecimal maxPoints,String grade,int gradeType){

		String gradename = grade;
		
		return null;
		
	}
	
}
