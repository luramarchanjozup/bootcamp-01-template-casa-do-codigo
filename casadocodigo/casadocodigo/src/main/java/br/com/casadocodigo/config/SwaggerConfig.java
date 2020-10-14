package br.com.casadocodigo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.casadocodigo"))
                .paths(PathSelectors.regex("/api.*"))
                .build();
    }

    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "API Casa do Código",
                "PI que atende as funcionalidades da Casa do código.",
                "1.0",
                "Terms of Service",
                new Contact("Cintya Amaral", "cintyaamaral22@gmail.com", null),
                "Apache License Version 2.0",
                "https://www.apache.org/licensen.html", new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }
}
