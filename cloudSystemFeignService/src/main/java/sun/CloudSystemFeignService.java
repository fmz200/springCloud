package sun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author admin
 */
@SpringBootApplication
@EnableFeignClients//激活Feign的注解  需要加到主启动类上
public class CloudSystemFeignService {
    public static void main(String[] args) {
        SpringApplication.run(CloudSystemFeignService.class, args);
    }
}
