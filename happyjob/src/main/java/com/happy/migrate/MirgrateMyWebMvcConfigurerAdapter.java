package com.happy.migrate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class MirgrateMyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

    @Autowired
    private StorageProperties storageProperties;

    @Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    // 对上传的图片路径进行映射
        registry.addResourceHandler(storageProperties.getVirtualPath() + "**")
                .addResourceLocations("file:" + storageProperties.getLocation());
        super.addResourceHandlers(registry);
    }
}
