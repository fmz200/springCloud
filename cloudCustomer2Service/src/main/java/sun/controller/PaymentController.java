package sun.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sun.pojo.CommonResult;
import sun.pojo.Payment;
import sun.service.PaymentService;

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

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment dept) {
        int i = paymentService.create(dept);
        log.info("***************插入成功*******" + i);
        if (i > 0) {
            return new CommonResult(200, "插入数据库成功", i);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping("/payment/get/{id}")

    public CommonResult queryById(@PathVariable("id") Long id) {
        Payment payment = paymentService.queryById(id);
        log.info("***************查询成功*********" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功8002", payment);
        } else {
            return new CommonResult(444, "查询失败8002", null);
        }
    }
}