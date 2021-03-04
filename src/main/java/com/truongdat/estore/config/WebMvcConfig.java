package com.truongdat.estore.config;

import com.truongdat.estore.interceptors.AuthorizedInterceptor;
import com.truongdat.estore.interceptors.UserSessionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private AuthorizedInterceptor authorizedInterceptor;
    @Autowired
    private UserSessionInterceptor userSessionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(authorizedInterceptor).addPathPatterns("/admin/*").excludePathPatterns("/admin/login");
        registry.addInterceptor(userSessionInterceptor).addPathPatterns("/admin/login");
    }
}
