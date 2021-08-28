package sun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 * @author admin
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudCustomer2ServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudCustomer2ServiceApplication.class, args);
    }
}
