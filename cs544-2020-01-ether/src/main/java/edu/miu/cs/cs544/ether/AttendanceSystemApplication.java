package edu.miu.cs.cs544.ether;

import com.google.common.base.Predicates;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableCircuitBreaker
@EnableEurekaClient
@EnableDiscoveryClient
@EnableSwagger2
@EnableAspectJAutoProxy
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AttendanceSystemApplication {


    public static void main(String[] args)  {
        SpringApplication.run(AttendanceSystemApplication.class, args);
    }

    @Bean
    public Docket api()
    {
        // @formatter:off
        return new Docket(DocumentationType.SWAGGER_2).select().paths(Predicates.not(PathSelectors.regex("/error"))) // Exclude
                // Spring
                // controllers
                .build();
        // @formatter:on

    }

    @LoadBalanced
    @Bean
    public  RestTemplate restTemplate(){
        return  new RestTemplate();
    }

}
