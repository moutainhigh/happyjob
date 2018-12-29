package com.happy;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.google.common.base.Predicate;
import com.happy.migrate.MigrateFastJsonConverter;
import com.happy.util.ServiceConfig;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @TODO: WEB自定义配置类
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer  {
	
	
	@Bean
    public Docket openApi() {
        Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
            @Override
            public boolean apply(RequestHandler input) {
                if(!ServiceConfig.isSwaggerEnabled()) {
                    return false;
                }
                if (input.getHandlerMethod().hasMethodAnnotation(ApiOperation.class))//只有添加了ApiOperation注解的method才在API中显示
                    return true;
                return false;
            }
        };
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("openApi")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .select()
                .apis(predicate)
//                .apis(RequestHandlerSelectors.basePackage("com.happy.appController.activity"))
                .paths(PathSelectors.any())//过滤的接口
                .build()
                .apiInfo(apiInfo());
    }
	

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("api文档")
                .description("restfun 风格接口")
                .version("1.0")
                .description("描述")
                .build();
    }
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowCredentials(true);
    }
    
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        converters.add(migrateFastJsonConverter());

    }

    @Bean
    public MigrateFastJsonConverter migrateFastJsonConverter() {
        return new MigrateFastJsonConverter();
    }
    
}

