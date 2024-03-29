package ca.gc.tc.hackathon.utils;

import ca.gc.tc.hackathon.controller.RatingTypeController;
import ca.gc.tc.hackathon.controller.ReviewController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.AbstractPathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
@ComponentScan(basePackageClasses = {
        ReviewController.class,
        RatingTypeController.class
})
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).pathProvider(new CustomPathProvider())
                .select()
                .apis(RequestHandlerSelectors.basePackage("ca.gc.tc.hackathon.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private class CustomPathProvider extends AbstractPathProvider {
        @Override
        protected String applicationPath() {
            return "";
        }

        @Override
        protected String getDocumentationPath() {
            return "";
        }
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "HOSA REST API",
                "Set of RESTFul APIs for Reviews and Rating Types.",
                "1.0.0.0",
                "Apache License Version 2.0",
                new Contact("HOSA REST API", "https://yiliu-hackathon.azurewebsites.net", "yi.liu@tc.gc.ca"),
                "License of API", "https://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
    }
}
