package com.coding.sales.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.ValidationException;

import com.coding.sales.constant.MemberGrade;
import com.coding.sales.entity.Member;
import com.coding.sales.entity.PointsChange;

/*
 * 会员等级及积分计算 add by ycs 20190702
 */
public class PointsCalculator {
	public boolean isGo = true;
	
	public PointsChange memberPAGCla(String memberId, BigDecimal receivables)  throws ValidationException{
		
		PointsChange pointChange = new PointsChange();
		//会员等级及积分信息
		Map memberInfoMap = new HashMap();
		//会员积分计算
		Map pointsMap = pointCla(memberId,receivables);
		
		//会员等级计算
		Map gradeMap = gradeCla(memberId);
		
//		memberInfoMap.put("MemberNo", memberId);//会员ID
//		memberInfoMap.put("OldMemberType", gradeMap.get("OldMemberType"));//原会员等级
//		memberInfoMap.put("NewMemberType", gradeMap.get("NewMemberType"));//新会员等级
//		memberInfoMap.put("MemberPointsIncreased", pointsMap.get("MemberPointsIncreased"));//本次消费会员新增的积分
//		memberInfoMap.put("MemberPoints", pointsMap.get("MemberPoints"));//会员最新的积分
//		memberInfoMap.put("GradeChangeFlag", gradeMap.get("GradeChangeFlag"));//会员等级变化标志
		
		pointChange.setMemberId(memberId);//会员ID
		pointChange.setMemberPoints(new BigDecimal(pointsMap.get("MemberPoints").toString()));//会员最新的积分
		pointChange.setMemberPointsIncreased(new BigDecimal(pointsMap.get("MemberPointsIncreased").toString()));//本次消费会员新增的积分
		pointChange.setNewMemberType(gradeMap.get("NewMemberType").toString());//新会员等级
		pointChange.setOldMemberType(gradeMap.get("OldMemberType").toString());//原会员等级
		
		return pointChange;
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
		Member member = InitData.memberMap.get(memberId);
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
	private Map gradeCla(String memberId) throws ValidationException{
		Map gradeMap = new HashMap();
		//会员等级变化标志
		boolean gradeChangeFlag = false;
		Member member = InitData.memberMap.get(memberId);
		//老会员等级
		String oldMemberType = member.getMemberGrade().getGrade();
		//获取会员最新积分
		BigDecimal memberPoints = member.getMemberPoints();
		//获得用户对应会员等级的积分规则
		MemberGrade memberGrade = member.getMemberGrade();
		BigDecimal maxPoints = memberGrade.getMaxPoints();
		
		//新会员等级
		Map gradeChangeMap = new HashMap();
		if(memberPoints.compareTo(maxPoints) > 0){
			gradeChangeFlag = true;
			try {
				gradeChangeMap = gradeChange(memberPoints,maxPoints,memberGrade.getGrade(),memberGrade.getGradeType(),member);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		//更新会员等级至用户对象
//		memberGrade.setGrade(gradeChangeMap.get("NewGrade").toString());
//		memberGrade.setGradeType((int) gradeChangeMap.get("NewGradeType"));
//		member.setMemberGrade(memberGrade);
		String newGrade = oldMemberType;
		
		gradeMap.put("OldMemberType", oldMemberType);//原会员等级
		gradeMap.put("NewMemberType", memberGrade.getGrade());//新会员等级
		gradeMap.put("GradeChangeFlag", gradeChangeFlag);//会员等级变化标志
		
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
	private Map gradeChange(BigDecimal memberPoints,BigDecimal maxPoints,String grade,int gradeType,Member member) throws ValidationException{
		
		Map gradeChangeMap = new HashMap();
		String gradename = grade;
		if(memberPoints.compareTo(maxPoints) > 0){
			gradeType = gradeType + 1;//下一等级会员类型
			MemberGrade memberGrade = getEnum(gradeType);
			maxPoints = memberGrade.getMaxPoints();//下一等级最大积分
			grade = memberGrade.getGrade();//下一等级会员等级名称
			gradeType = memberGrade.getGradeType();//下一等级会员类型
			gradeChange(memberPoints,maxPoints,grade,gradeType,member);

		}else{
			MemberGrade memberGrade = member.getMemberGrade();
			memberGrade.setGrade(grade);
			memberGrade.setGradeType(gradeType);
			member.setMemberGrade(memberGrade);
			throw new ValidationException("更新对像，强制跳出递归");
		}
		
		return gradeChangeMap;
	}
	
	/*
	 * 根据会员类型获取会员等级实例
	 */
	public MemberGrade getEnum(int gradeType){

		MemberGrade memberGrade = MemberGrade.ONE;
		switch(gradeType){
			case 1:
				memberGrade = MemberGrade.ONE;
				break;
			case 2:
				memberGrade = MemberGrade.TWO;
				break;
			case 3:
				memberGrade = MemberGrade.THREE;
				break;
			case 4:
				memberGrade = MemberGrade.Four;
				break;
			default:
				memberGrade = MemberGrade.Four;
				break;
		}
		
		return memberGrade;
		
	}
	
}
