package edu.miu.cs.cs544.ether.auth;

import com.google.common.base.Predicates;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableSwagger2
public class EtherAuthApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(EtherAuthApplication.class, args);
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
}
