package com.crazysky.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 负载均衡实现类
 * @author CrazySky
 * @date 2021/03/28 15:33
 */
@Slf4j
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 获取rest接口请求次数
     * @author CrazySky
     * @date 2021/03/28 16:12
     * @return int
     */
    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current > Integer.MAX_VALUE ? 0 : current + 1;
        } while(!this.atomicInteger.compareAndSet(current, next));
        log.info("第几次访问----------------next={}", next);
        return next;
    }

    /**
     * 负载均衡算法（rest接口第几次请求参数 % 服务器集群总数量 = 实际调用服务器位置下标，每次重启动后rest接口计数从1开始）
     * @author CrazySky
     * @date 2021/03/28 16:10
     * @param serviceInstances 服务实例
     * @return org.springframework.cloud.client.ServiceInstance
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
