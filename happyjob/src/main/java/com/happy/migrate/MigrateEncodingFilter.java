package com.happy.migrate;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.filter.CharacterEncodingFilter;
/**
 * 
 * @TODO: 编码过滤器
 *
 */
@Configuration
public class MigrateEncodingFilter {

	@Bean
	public FilterRegistrationBean<CharacterEncodingFilter> autoEncodingFilte() {
		FilterRegistrationBean<CharacterEncodingFilter> registration = new FilterRegistrationBean<CharacterEncodingFilter>();
		registration.setFilter(new CharacterEncodingFilter());
		registration.addInitParameter("encoding", "utf-8");
		registration.addUrlPatterns("/*");
		registration.setName("MirgrateEncodingFilter");
		registration.setOrder(Ordered.HIGHEST_PRECEDENCE); // 排序最前
		return registration;
	}
}
