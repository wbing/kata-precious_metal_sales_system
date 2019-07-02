package com.coding.sales.service;

import org.junit.Test;

import com.coding.sales.entity.PointsChange;

import java.math.BigDecimal;
import java.util.Map;
/*
 * 会员积分及等级更新计算测试类
 */
public class PointsCalculatorTest {
    @Test
    public void should_parse_command() {
    	//初始化用户数据
    	InitData.init();
    	PointsCalculator pointsCalculator = new PointsCalculator();
    	PointsChange pointsChange = pointsCalculator.memberPAGCla("6236609999", new BigDecimal("50000"));
    	
    	System.out.println("会员等级计算");
    	
    }

}