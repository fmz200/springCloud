# springCloud
学习创建springCloud项目

可能用到的地址
* http://localhost:7001/
* http://localhost:8001/payment/get/1
* http://localhost:8001/payment/discovery
* http://localhost:8001/payment/feign/timeout
* http://localhost:8001/payment/hystrix/ok/1
* http://localhost:8001/payment/hystrix/timeout/2
* http://localhost:8004/payment/consul
* http://localhost:8500/ui/dc1/services
* http://localhost:6001/consumer/payment/get/1
* http://localhost:6001/consumer/payment/consul
* http://localhost:6001/consumer/feign/timeout
* http://localhost/consumer/payment/get/1
* http://localhost/consumer/payment/consul
* http://localhost/consumer/feign/timeout

可能用到的信息
* hosts文件：C:\Windows\System32\drivers\etc

###服务介绍
* cloudApiService 公共方法，类；无启动类，无需启动
* cloudCustomerService 服务提供端，端口：8001
* cloudCustomer2Service 服务提供端，与8001只是端口不同，用来测试调用方分发调用，端口：8002
* cloudCustomerHystrixService 端口：8001
* cloudEurekaService 服务注册中心，集群，customer、service和gateway启动后注册在此，用于调用。 端口：7001
* cloudEureka2Service 与7001只是端口不同。端口：7002
* cloudGatewayService 网关，动态从服务注册中心获取服务。端口：9527
* cloudSystemService 服务调用方。端口：6001
* cloudSystemFeignService 服务调用方。端口：6001
* cloudSystemFeignHystrixService 服务调用方，测试熔断，限流等。端口：6001
* cloudSystemHystrixDashboar 服务调用仪表盘页面。端口：9003
