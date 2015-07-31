package ru.local.dnevnik.config.application;

import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.servlet.MultipartConfigElement;

@Configuration
@PropertySources(value = {@PropertySource("classpath:/application.properties")})
@ComponentScan({"ru"})
@EnableAsync
public class WebConfig {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        return new CommonsMultipartResolver();    
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("102400KB");
        factory.setMaxRequestSize("102400KB");
        return factory.createMultipartConfig();
    }
}