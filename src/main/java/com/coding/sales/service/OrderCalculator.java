package com.coding.sales.service;

import com.coding.sales.entity.FullReduce;
import com.coding.sales.entity.PointsChange;
import com.coding.sales.entity.Product;
import com.coding.sales.input.OrderCommand;
import com.coding.sales.input.OrderItemCommand;
import com.coding.sales.input.PaymentCommand;
import com.coding.sales.output.DiscountItemRepresentation;
import com.coding.sales.output.OrderItemRepresentation;
import com.coding.sales.output.OrderRepresentation;
import com.coding.sales.output.PaymentRepresentation;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class OrderCalculator {

    public OrderRepresentation calculate(OrderCommand orderCommand){
        List<OrderItemRepresentation> orderItems=new ArrayList<>();
        List<DiscountItemRepresentation> discountItems=new ArrayList<>();
        BigDecimal finalAmount=BigDecimal.ZERO;
        BigDecimal totalOrder=BigDecimal.ZERO;
        for (OrderItemCommand item : orderCommand.getItems()) {
            BigDecimal finalProductAmt=BigDecimal.ZERO;
            BigDecimal discountResult =BigDecimal.ZERO;
            BigDecimal fullReduceResult=BigDecimal.ZERO;
            BigDecimal countFullReduceResult =BigDecimal.ZERO;

            Product product= InitData.productMap.get(item.getProduct());
            BigDecimal initAmount=product.getPrice().multiply(item.getAmount());
            totalOrder=totalOrder.add(initAmount);
            List<String> discounts=orderCommand.getDiscounts();
            List<FullReduce> allFullReduce = product.getFullReduce();
            if((discounts==null||discounts.size()==0)&&(allFullReduce==null||allFullReduce.size()==0)){
                finalProductAmt=initAmount;
                finalAmount=finalAmount.add(finalProductAmt);
                continue;
            }
            //优惠金额map
            Map<BigDecimal,BigDecimal> discountMap=new HashMap<>(6);
            if(product.getDiscount()!=null&&discounts!=null&&discounts.size()>0){
                if(product.getDiscount().getDisplay().equals(discounts.get(0))){
                   discountResult= initAmount.multiply(product.getDiscount().getValue());
                   discountMap.put(discountResult,initAmount.subtract(discountResult));
                }
            }
            //倒叙排列，先取最大的优惠 筛选出按金额满减的条件
            List<FullReduce> fullReduce= allFullReduce.stream().filter(obj-> !obj.getIsCount()).collect(Collectors.toList());
            //筛选出按件满减的条件
            List<FullReduce> countFullReduce= allFullReduce.stream().filter(obj-> obj.getIsCount()).collect(Collectors.toList());
            fullReduce.sort((o1,o2)->o2.getFull().compareTo(o1.getFull()));
            countFullReduce.sort((o1,o2)->o2.getReduceCount().compareTo(o1.getReduceCount()));
            if(fullReduce!=null&&fullReduce.size()>0){
                for (FullReduce reduce : fullReduce) {
                    if(initAmount.compareTo(reduce.getFull())>0){
                        fullReduceResult=initAmount.subtract(reduce.getReduce());
                        discountMap.put(fullReduceResult,reduce.getReduce());
                        break;
                    }
                }
            }
            if(countFullReduce!=null&&countFullReduce.size()>0){
                for (FullReduce reduce : countFullReduce) {
                    if (initAmount.compareTo(reduce.getFullCount())>0){
                        countFullReduceResult = initAmount.subtract(product.getPrice().multiply(reduce.getReduceCount()));
                        discountMap.put(countFullReduceResult,product.getPrice().multiply(reduce.getReduceCount()));
                        break;
                    }
                }
            }
            finalProductAmt=discountResult.compareTo(fullReduceResult.compareTo(countFullReduceResult)>0?fullReduceResult:countFullReduceResult)>0?discountResult:fullReduceResult;
            finalAmount=finalAmount.add(finalProductAmt);
            OrderItemRepresentation order=new OrderItemRepresentation(product.getProductNo(),product.getProductName(),product.getPrice(),item.getAmount(),finalProductAmt);
            orderItems.add(order);

            DiscountItemRepresentation discount=new DiscountItemRepresentation(product.getProductNo(),product.getProductName(),discountMap.get(finalProductAmt));
            discountItems.add(discount);

        }
        BigDecimal discountAmt= discountItems.stream().map(DiscountItemRepresentation::getDiscount).reduce(BigDecimal.ZERO, BigDecimal::add);

        PointsCalculator pointsCalculator = new PointsCalculator();
        PointsChange point= pointsCalculator.memberPAGCla(orderCommand.getMemberId(),finalAmount);
        return new OrderRepresentation(orderCommand.getOrderId(),new Date(),orderCommand.getMemberId(), InitData.memberMap.get(orderCommand.getMemberId()).getMemberName(),point.getOldMemberType(),
                point.getNewMemberType(),point.getMemberPointsIncreased().intValue(),point.getMemberPoints().intValue(),orderItems,totalOrder,discountItems,discountAmt,finalAmount,
                copyFromPayments(orderCommand.getPayments()), orderCommand.getDiscounts());
    }
    private List<PaymentRepresentation> copyFromPayments(List<PaymentCommand> list){
        List<PaymentRepresentation> result=new ArrayList<>();
        if(list!=null&&list.size()>0){
            for (PaymentCommand paymentCommand : list) {
                PaymentRepresentation pay=new PaymentRepresentation(paymentCommand.getType(),paymentCommand.getAmount());
                result.add(pay);
            }
        }
        return result;
    }
}
