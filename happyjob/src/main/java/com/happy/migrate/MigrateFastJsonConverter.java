package com.happy.migrate;

import java.nio.charset.Charset;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * @TODO: fastjson 返回值null过滤
 *
 */
public class MigrateFastJsonConverter extends FastJsonHttpMessageConverter {
	
	public MigrateFastJsonConverter() {
        // 在这里配置 fastjson 特性
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat); // 默认null 值不显示
        fastJsonConfig.setCharset(Charset.defaultCharset());
        this.setFastJsonConfig(fastJsonConfig);
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return super.supports(clazz);
    }

}
