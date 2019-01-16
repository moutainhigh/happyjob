package com.happy.migrate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MirgrateMyWebMvcConfigurerAdapter implements WebMvcConfigurer {

      @Autowired
      private StorageProperties storageProperties;
        
      @Override
      public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler(storageProperties.getVirtualPath() + "**")
                    .addResourceLocations("file:"+storageProperties.getLocation());
      }
}
