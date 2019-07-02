package com.coding.sales.service;

import com.coding.sales.constant.DiscountType;
import com.coding.sales.constant.MemberGrade;
import com.coding.sales.entity.FullReduce;
import com.coding.sales.entity.Member;
import com.coding.sales.entity.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InitData {

    public static Map<String, Product> productMap = new HashMap<String, Product>(8);
    public static Map<String, Member> memberMap = new HashMap<String, Member>(8);

    public static void init(){
        FullReduce threeThou=new FullReduce(new BigDecimal(3000),new BigDecimal(350),false);
        FullReduce twoThou=new FullReduce(new BigDecimal(2000),new BigDecimal(30),false);
        FullReduce oneThou=new FullReduce(new BigDecimal(1000),new BigDecimal(10),false);
        FullReduce oneFree=new FullReduce(new BigDecimal(4),new BigDecimal(1),true);
        FullReduce halfFree=new FullReduce(new BigDecimal(3),new BigDecimal(0.5),true);
        List list1=new ArrayList();
        list1.add(threeThou);
        list1.add(twoThou);
        list1.add(oneThou);
        productMap.put("002003",new Product("002003","中国银象棋12g",new BigDecimal(698.00),"套", DiscountType.NINE,list1));
        List list2=new ArrayList();
        list2.add(oneFree);
        list2.add(halfFree);
        productMap.put("002001",new Product("002001","守扩之羽比翼双飞4.8g",new BigDecimal(1080.00),"条", DiscountType.NINEFIVE,list2));
        List list3=new ArrayList();
        list3.add(twoThou);
        list3.add(oneThou);
        productMap.put("002002",new Product("002002","中国经典钱币套装",new BigDecimal(998.00),"套", null,list3));
        productMap.put("003002",new Product("003002","水晶之恋",new BigDecimal(980.00),"条", null,list2));
        productMap.put("003001",new Product("003001","招财进宝",new BigDecimal(1580.00),"条", DiscountType.NINEFIVE,null));
        productMap.put("001002",new Product("001002","2019北京世园会纪念银章大全40g",new BigDecimal(1380.00),"盒", DiscountType.NINE,null));
        productMap.put("001001",new Product("001001","世园会五十国钱币册",new BigDecimal(998.00),"册", null,null));

        //初始化会员
        memberMap.put("6236609999",new Member("6236609999","马丁", MemberGrade.ONE,new BigDecimal(9860)));
        memberMap.put("6630009999",new Member("6630009999","王立", MemberGrade.TWO,new BigDecimal(48860)));
        memberMap.put("8230009999",new Member("8230009999","李想", MemberGrade.THREE,new BigDecimal(98860)));
        memberMap.put("9230009999",new Member("9230009999","张三", MemberGrade.Four,new BigDecimal(198860)));
    }
}
