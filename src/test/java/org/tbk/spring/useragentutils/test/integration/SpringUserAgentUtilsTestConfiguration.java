package org.tbk.spring.useragentutils.test.integration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.tbk.spring.useragentutils.UserAgentHandlerMethodArgumentResolver;
import org.tbk.spring.useragentutils.UserAgentResolverHandlerInterceptor;

import java.util.List;

@Configuration
@EnableWebMvc
class SpringUserAgentUtilsTestConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public UserAgentTestCtrl userAgentCtrl() {
        return new UserAgentTestCtrl();
    }

    @Bean
    public UserAgentResolverHandlerInterceptor userAgentResolverHandlerInterceptor() {
        return new UserAgentResolverHandlerInterceptor();
    }

    @Bean
    public UserAgentHandlerMethodArgumentResolver userAgentHandlerMethodArgumentResolver() {
        return new UserAgentHandlerMethodArgumentResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userAgentResolverHandlerInterceptor());
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(userAgentHandlerMethodArgumentResolver());
    }
}
