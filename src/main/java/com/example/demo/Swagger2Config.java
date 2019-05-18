package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration   // 声明配置类
@EnableSwagger2  // 开启在线接口文档
public class Swagger2Config {
    @Bean //用在方法上告诉Spring容器，你可以从下面这个方法中拿到一个Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())                
                .select()  // 函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现
                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))  //扫描包下所有带Controller的api 除了@ApiIgnore
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 此方法会在页面展示api信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot利用swagger构建api文档")
                .description("用户的CRUD")
                .termsOfServiceUrl("放个链接")
                .version("1.0")
                .build();
    }
}
