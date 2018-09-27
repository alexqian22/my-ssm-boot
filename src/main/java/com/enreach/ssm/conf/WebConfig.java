package com.enreach.ssm.conf;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * url 不区分大小写
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        AntPathMatcher matcher = new AntPathMatcher();
        matcher.setCaseSensitive(false);
        configurer.setPathMatcher(matcher);
    }

    /**
     * 参数不区分大小写
     * @return
     */
    @Bean
    public FilterRegistrationBean caseSensitiveParamFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CaseInsensitiveParameterFilter());
        registration.addUrlPatterns("/*");
        registration.setName("caseSensitiveParamFilter");
        return registration;
    }


}