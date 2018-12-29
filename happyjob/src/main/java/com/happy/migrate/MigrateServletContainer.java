/**
 * @author chenwei
 * @date: 2018年8月1日 下午6:53:18
 * 
 */
package com.happy.migrate;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @TODO: 不同请求状态访问页面配置（404）
 */
@Configuration
public class MigrateServletContainer {
	//统一页码处理配置
	@Bean
	public WebServerFactoryCustomizer<?> containerCustomizer() {
	    
	    return new WebServerFactoryCustomizer<WebServerFactory>() {


            @Override
            public void customize(WebServerFactory factory) {
                ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/jsp/404.jsp");
                
                ((ConfigurableWebServerFactory)factory).addErrorPages( error404Page);
                 
            }

	    };
	}
}
