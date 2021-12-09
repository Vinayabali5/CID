package uk.ac.reigate.config.swagger;

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.context.annotation.Profile

import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@Profile(value = "swagger")
@EnableSwagger2
//@PropertySource("classpath:swagger.properties")
@Import(SwaggerUiConfiguration.class)
public class SwaggerConfig {
    
    @Value("\${info.build.version:'0.0.0'}")
    private String version;
    
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "College Information Database API",
                "The API documentation for the College Information Database",
                version,
                "",
                new Contact("Reigate College MIS Department", "", "mis@reigate.ac.uk"),
                "",
                "",
                []);
        return apiInfo;
    }
    
    @Bean
    public Docket customImplementation() {
        return new Docket(DocumentationType.SWAGGER_2)
                .ignoredParameterTypes(MetaClass.class)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                //.paths(PathSelectors.any())
                .paths(PathSelectors.ant('/**'))
                .build()
        
    }
}