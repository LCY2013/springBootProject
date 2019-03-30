package com.lcydream.project.restonspringmvc.config;

import com.lcydream.project.restonspringmvc.http.message.PropertiesPersonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * WebMvcConfig
 * webmvc 配置
 * @author Luo Chun Yun
 * @date 2018/11/21 21:39
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void extendMessageConverters(
            List<HttpMessageConverter<?>> converters) {
        converters.add(new PropertiesPersonHttpMessageConverter());
        //converters.add(0,new MappingJackson2XmlHttpMessageConverter());
        //converters.add(new MappingJackson2HttpMessageConverter());
        //System.out.println("converters:"+converters);
    }
}
