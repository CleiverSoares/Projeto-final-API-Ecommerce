package org.serratec.backend.projetoFinal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;

//import com.google.common.base.Predicate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.serratec.backend.TrabalhoFinal.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("API Ecommerce SerraTec")
                .description("API de site ecommerce do Grupo 03, Residência 2021.2, Serratec")
                .termsOfServiceUrl("/service.html")
                .version("0.0.0")
                .contact(new Contact("Ecommerce", "www.serratec.org", "fullstacksoares@gmail.com"))
                .build();

        return apiInfo;
    }

//	@Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("org.serratec.backend.projetoFinal.controller"))
//                //.paths(regex("/Pedido.*"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(metaInfo());
//    }
//
//	private ApiInfo metaInfo() {
//
//        @SuppressWarnings("rawtypes")
//		ApiInfo apiInfo = new ApiInfo(
//                "Ecommerce API REST",
//                "API REST de Ecommerce.", 
//                "1.0",
//                "Terms of Service",
//                new Contact("Grupo 03","fullstacksoares@gmail.com", " "),
//                "Apache License Version 2.0",
//                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
//        );
//
//        return apiInfo;
//    }
}
