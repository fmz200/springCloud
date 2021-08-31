package sun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import ribbonRule.MyselfRule;

/**
 * @author admin
 */
@SpringBootApplication
@EnableEurekaClient
//name为生产者服务的服务名称  configuration为配置类的类名
@RibbonClient(name = "cloudCustomerService", configuration = MyselfRule.class)
public class CloudSystemServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudSystemServiceApplication.class, args);
    }
}
