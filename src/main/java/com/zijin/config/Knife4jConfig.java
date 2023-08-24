package com.zijin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Knife4j 接口文档配置
 * https://doc.xiaominfo.com/knife4j/documentation/get_start.html
 *
 */
@Configuration
@EnableSwagger2
//删除这个注解，不然接口文档没办法展示下面的配置
//@Profile({"dev","prod"})
public class  Knife4jConfig {

    @Bean
    public Docket defaultApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 指定 Controller 扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.zijin.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 接口文档的标题
                .title("数据开放接口平台")
                // 接口文档的描述信息
                .description("为前端提供的数据接口，帮助前端去更加有效的去测试程序，前端不再需要自己去mock数据")
                // 提供服务的是谁？可以填写你自己的地址因为是你自己提供的服务
                .termsOfServiceUrl("https://github.com/mzijin")
                .contact(new Contact("mzijin", "https://blog.csdn.net/m0_70638653?spm=1000.2115.3001.5343", "1602910132@qq.com"))
                // 版本
                .version("1.0")
                // 构建
                .build();
    }
}