package sun.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sun.pojo.CommonResult;
import sun.pojo.Payment;
import sun.service.PaymentService;

import java.util.List;
import java.util.concurrent.TimeUnit;

/*
 * 提供restful服务  供其他服务调用
 *
 *
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    //注入服务发现的注解
    @Autowired
    private DiscoveryClient discoveryClient;

    //获取服务信息
    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String s : services) {
            log.info("********注册到eureka中的服务中有:" + services);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("MCROSERVICE-PAYMENT");
        for (ServiceInstance s : instances) {
            log.info("当前服务的实例有" + s.getServiceId() + "\t" + s.getHost() + "\t" + s.getPort() + "\t" + s.getUri());
        }
        return this.discoveryClient;
    }


    @PostMapping("/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment dept) {
        int i = paymentService.create(dept);
        log.info("***************插入成功*******" + i);
        if (i > 0) {
            return new CommonResult<>(200, "插入数据库成功8001", i);
        } else {
            return new CommonResult<>(444, "插入数据库失败8001", null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> queryById(@PathVariable("id") Long id) {
        Payment payment = paymentService.queryById(id);
        log.info("***************查询成功*********" + payment);
        if (payment != null) {
            return new CommonResult<>(200, "查询成功8001", payment);
        } else {
            return new CommonResult<>(444, "查询失败8001", null);
        }
    }

    @GetMapping("/payment/getMenuList")
    public CommonResult<Payment> getMenuList() {
        Payment payment = new Payment();
        payment.setId(666L);
        payment.setSerial("测试菜单");
        log.info("***************查询成功*********" + payment);
        return new CommonResult<>(200, "查询成功8001", payment);
    }

    //模拟业务接口延时3秒
    @GetMapping("/payment/feign/timeout")
    public String PaymentFeignTimeOut() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return "8001";
    }

    @GetMapping("/payment/login")
    public CommonResult<Payment> login() {
        Payment payment = new Payment();
        payment.setId(666L);
        payment.setSerial("success");
        log.info("***************登录成功*********, {}", payment);
        return new CommonResult<>(200, "查询成功8001", payment);
    }
}
