package sun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *
 * @author admin
 */
@SpringBootApplication
@EnableEurekaServer
public class Eureka2ServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(Eureka2ServiceApplication.class, args);
    }
}