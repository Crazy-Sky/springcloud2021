package com.crazysky.springcloud.service;

import com.crazysky.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * 支付信息的业务逻辑处理接口
 * @author CrazySky
 * @date 2021/02/28 00:38
 */
public interface PaymentService {

    /**
     * 新增支付信息
     * @author CrazySky
     * @date 2021/02/28 00:54
     * @param payment 支付信息
     * @return java.lang.Integer
     */
    Integer create(Payment payment);

    /**
     * 根据id获取支付信息
     * @author CrazySky
     * @date 2021/02/28 00:54
     * @param id 支付信息编号
     * @return com.crazysky.springcloud.entities.Payment
     */
    Payment getPaymentById(@Param("id") Long id);
}





















