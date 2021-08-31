package sun.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sun.pojo.CommonResult;
import sun.pojo.Payment;

@ComponentScan
@FeignClient(value = "cloudCustomerService") // 使用Feign
public interface PaymentService {

    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> queryById(@PathVariable("id") Long id);

    //调用生产者微服务名称为mcroservice-payment下边的模拟超时的接口
    @GetMapping("/payment/feign/timeout")
    String PaymentFeignTimeOut() throws InterruptedException;
}
