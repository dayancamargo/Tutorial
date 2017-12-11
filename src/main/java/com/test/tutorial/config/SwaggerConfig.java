package com.test.tutorial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
/**
 * This class will configure swagger options
 * @see https://springfox.github.io/springfox/docs/current/
 */
class SwaggerConfig {
    /**
     * This will start swagger
     * apiInfo - load informations about this api, like name, desc...
     * select  - Initiates a builder for api selection.
     * apis -  allows selection of RequestHandler's using a predicate. The example here uses an any predicate
     * paths - allows selection of Path's using a predicate.
     * useDefaultResponseMessages - Allows ignoring predefined response message defaults
     * @return
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                  .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                  .paths(PathSelectors.any())
                  .build()
                .useDefaultResponseMessages(false);

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring boot Tutorial ")
                .description("Some examples")
                .version("1.0")
                .build();
    }
}
