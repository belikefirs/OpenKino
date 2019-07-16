package com.configuration;

import com.filter.BasicAuthenticationVUFilter;
import com.filter.EncodingFilter;
import com.service.KinUserService;
import com.service.KinUserServiceImpl;
import com.tokens.FilterToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private KinUserService kinUserService;
    private ApplicationContext context;
    public SecurityConfig(KinUserService kinUserService){
        this.kinUserService = kinUserService;
    }

    public ApplicationContext getContext() {
        return context;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().withUser("user").password(bCryptPasswordEncoder().encode("user")).roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("superadmin").password("superadmin").roles("SUPERADMIN");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        final BasicAuthenticationVUFilter authenticationVUFilter = new BasicAuthenticationVUFilter(authenticationManagerBean(), jwtConfig());
        http
                .csrf().disable()
                .addFilterBefore(new FilterToken(jwtConfig()), UsernamePasswordAuthenticationFilter.class)
                .addFilter(authenticationVUFilter)
                .addFilterBefore(new EncodingFilter(), ChannelProcessingFilter.class)
                .authorizeRequests()
                .antMatchers("/protected/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/confidential/**").access("hasRole('ROLE_SUPERADMIN')")
                .antMatchers("/user/create").permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin().defaultSuccessUrl("/", false);

    }
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        AuthenticationManager manager =  super.authenticationManagerBean();
        return manager;
    }

    @Bean
    public JwtConfig jwtConfig() {
        return new JwtConfig();
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
