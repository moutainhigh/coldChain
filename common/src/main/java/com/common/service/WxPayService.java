package com.common.service;


import com.common.vo.SBApi;

import java.math.BigDecimal;

/**
 * 微信支付服务接口
 */
public interface WxPayService {

    /**
     * @Description: 微信支付统一下单
     * @param orderNo: 订单编号
     * @param body: 订单描述
     * @Author:
     * @Date: 2019/8/1
     * @return
     */
    SBApi unifiedOrder(String orderNo, BigDecimal price,String tradeType, String body, String code,String callbackUrl) ;

    /**
     * @Description: 订单支付异步通知
     * @param notifyStr: 微信异步通知消息字符串
     * @Author:
     * @Date: 2019/8/1
     * @return
     */
    String notify(String notifyStr) throws Exception;

    /**
     * @Description: 退款
     * @param orderNo: 订单编号
     * @param amount: 实际支付金额
     * @param refundReason: 退款原因
     * @Author: XCK
     * @Date: 2019/8/6
     * @return
     */
    SBApi refund(String orderNo, double amount, String refundReason);

}