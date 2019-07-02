package com.coding.sales.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/*
 * 会员等级及积分计算 add by ycs 20190702
 */
public class PointsCalculator {
	
	public Map memberPAGCla(String memberId, BigDecimal receivables){
		
		//会员等级及积分信息
		Map memberTypeInfo = new HashMap();
		//会员积分计算
		Map pointsMap = pointCla(memberId,receivables);
		//会员等级计算

		
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
		
		
		return pointClaMap;
		
	}
	/*
	 * 会员等级计算
	 * input 
	 * 		String memberId-会员ID
	 * 		BigDecimal memberPointsIncreased-本次新增积分
	 * output
	 * 		Map gradeMap-会员等级变化
	 * 
	 */
	private Map gradeCla(String memberId, BigDecimal memberPointsIncreased){
		Map gradeMap = new HashMap();
		
		return gradeMap;
		
	}
	
}
