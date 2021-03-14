package com.crazysky.springcloud.controller;

import com.crazysky.springcloud.entities.CommonResult;
import com.crazysky.springcloud.entities.Payment;
import com.crazysky.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 支付服务访问控制类
 * @author CrazySky
 * @date 2021/02/28 01:03
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    /**
     * 增加支付信息
     * @author CrazySky
     * @date 2021/03/01 14:13
     * @param payment 支付信息
     * @return com.crazysky.springcloud.entities.CommonResult<java.lang.Integer>
     */
    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        Integer result = paymentService.create(payment);
        log.info("插入结果----------------{}", result);
        if (result > 0) {
            return new CommonResult<>(200, "插入成功", result);
        }
        return new CommonResult(444, "插入失败");
    }

    /**
     * 根据id获取支付信息
     * @author CrazySky
     * @date 2021/03/01 14:14
     * @param id 支付信息编号
     * @return com.crazysky.springcloud.entities.CommonResult<com.crazysky.springcloud.entities.Payment>
     */
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果----------------{}", payment);
        if (payment != null) {
            return new CommonResult<>(200, "查询成功", payment);
        }
        return new CommonResult(444, "查询失败");
    }
}
