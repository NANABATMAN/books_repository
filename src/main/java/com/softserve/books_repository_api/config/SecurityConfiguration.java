package com.softserve.books_repository_api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * Created by ikar on 29.09.2016.
 *
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final static String ADMIN_ROLE = "ADMIN";

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser("ikar").password("ikar").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/books").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.PUT, "/books/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.DELETE, "/books/**").hasRole(ADMIN_ROLE)
                .and().csrf().disable();
    }

}