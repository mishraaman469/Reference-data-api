package com.mt.insurance.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration()
@EnableSwagger2()
public class SpringFoxSwaggerConfig {

	@Bean
	public Docket referenceDataApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.mt.insurance")).paths(PathSelectors.any()).build()
				.apiInfo(this.apiInfo());
	}

	public ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Reference Data APi")
				.description("This is the appliaction which will give the all application data").version("1.0.0")
				.contact(new Contact("Aman Mishra", "github.com", "mishraaman469@gmail.com")).license("MIT").build();
	}

}
