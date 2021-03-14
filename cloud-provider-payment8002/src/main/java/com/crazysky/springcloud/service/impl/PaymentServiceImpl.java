package com.crazysky.springcloud.service.impl;

import com.crazysky.springcloud.dao.PaymentDao;
import com.crazysky.springcloud.entities.Payment;
import com.crazysky.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 支付信息的业务逻辑处理实现类
 * @author CrazySky
 * @date 2021/02/28 00:56
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    /**
     * 新增支付信息
     * @author CrazySky
     * @date 2021/02/28 00:59
     * @param payment 支付信息
     * @return java.lang.Integer
     */
    @Override
    public Integer create(Payment payment) {
        return paymentDao.create(payment);
    }

    /**
     * 根据id获取支付信息
     * @author CrazySky
     * @date 2021/02/28 00:59
     * @param id 支付信息编号
     * @return com.crazysky.springcloud.entities.Payment
     */
    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
