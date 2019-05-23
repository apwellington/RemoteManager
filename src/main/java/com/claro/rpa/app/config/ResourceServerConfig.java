package com.claro.rpa.app.config;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.bind.annotation.CrossOrigin;


//@Configuration
//@EnableResourceServer
public class ResourceServerConfig /*extends ResourceServerConfigurerAdapter*/ {
/*
    private static final String RESOURCE_ID = "resource_id";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID).stateless(false);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.
                anonymous().disable()
                .authorizeRequests()
                .antMatchers("/api/admin/**").access("hasRole('ADMIN')")
                .antMatchers("/api/service/**").access("hasRole('USER')")
                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
*/
}
