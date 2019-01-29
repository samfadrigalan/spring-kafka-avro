package com.code.kafka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class ServiceConfig {

    @Bean
    public Docket provideSwaggerApiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.regex("/api/.*"))
                .build()
                .apiInfo(new ApiInfoBuilder()
                    .title("springKafkaAvro")
                    .description("Application to test Kafka + Avro")
                    .version("v1")
                    .build());

    }
}
