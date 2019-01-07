package com.happy;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

import com.happy.util.ServiceConfig;
import com.happy.util.Util;
import com.happy.util.sms.SmsUtil;

@SpringBootApplication
@MapperScan({"com.happy.sqlMapper", "com.happy.sqlExMapper"})
@RestController
public class HappySpringBoot extends SpringBootServletInitializer implements EnvironmentAware, CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(HappySpringBoot.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return configureApplication(builder);
    }

    public static void main(String[] args) {
        configureApplication(new SpringApplicationBuilder()).run(args);

    }

    private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
        return builder.sources(HappySpringBoot.class).bannerMode(Banner.Mode.OFF);
    }

    @Override
    public void setEnvironment(Environment environment) {

        // 可使用反射替代
        String upload_base_path = environment.getProperty("serviceConfig.filePath.upload_base_path");// 根据自己定义的获取文件上传地址
        String upload_base_url = environment.getProperty("serviceConfig.filePath.upload_base_url");// 根据自己定义的获取文件上传后访问域名
        String swaggerEnabled = environment.getProperty("serviceConfig.swagger.enabled");// 根据自己定义的获取swagger接口是否开放
        logger.info("upload_base_path:{}", upload_base_path);
        logger.info("upload_base_url:{}", upload_base_url);
        logger.info("swaggerEnabled:{}", swaggerEnabled);
        if (!Util.isEmpty(upload_base_path)) {
            ServiceConfig.setUploadBasePath(upload_base_path);
        }
        if (!Util.isEmpty(upload_base_url)) {
            ServiceConfig.setUploadBaseUrl(upload_base_url);
        }
        if ("true".equals(swaggerEnabled)) {
            ServiceConfig.setSwaggerEnabled(true);
        }

    }

    /*
     * 启动后可以做一些动作
     */
    @Override
    public void run(String... args) throws Exception {

        logger.debug("==========启动成功!===========");

    }

}