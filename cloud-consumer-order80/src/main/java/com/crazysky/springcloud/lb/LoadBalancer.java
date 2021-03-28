package com.crazysky.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 负载均衡接口
 * @author CrazySky
 * @date 2021/03/28 15:30
 */
public interface LoadBalancer {

    /**
     * 负载均衡算法
     * @author CrazySky
     * @date 2021/03/28 15:32
     * @param serviceInstances 服务实例
     * @return org.springframework.cloud.client.ServiceInstance
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
