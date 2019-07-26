package com.configuration;

import com.filter.BasicAuthenticationVUFilter;
import com.filter.EncodingFilter;
import com.models.KinoUser;
import com.service.KinUserService;
import com.service.KinUserServiceImpl;
import com.tokens.FilterToken;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


@EnableWebSecurity
@ComponentScan("com")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private KinUserService kinUserService;
    private ApplicationContext context;
    public SecurityConfig(ApplicationContext context, KinUserService kinUserService){
        this.kinUserService = kinUserService;
        this.context = context;
    }

    public ApplicationContext getContext() {
        return context;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.inMemoryAuthentication().withUser("user").password(bCryptPasswordEncoder().encode("user")).roles("USER");
//        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
//        auth.inMemoryAuthentication().withUser("superadmin").password("superadmin").roles("SUPERADMIN");
        auth.userDetailsService(kinUserService);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        final BasicAuthenticationVUFilter authenticationVUFilter = new BasicAuthenticationVUFilter(authenticationManagerBean(), jwtConfig());
        http
                .csrf().disable()
                .addFilterBefore(new FilterToken(jwtConfig(),kinUserService), UsernamePasswordAuthenticationFilter.class)
                .addFilter(authenticationVUFilter)
                .addFilterBefore(new EncodingFilter(), ChannelProcessingFilter.class)
                .authorizeRequests()
                .antMatchers("/protected/**").access("hasRole('ROLE_ADMIN')")
    //          .antMatchers("/KinoUser/all").access("hasAuthority('User')")
                .antMatchers("/user/create").permitAll()
                .anyRequest().permitAll()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin().disable()
       ;

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

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(500000);
        return multipartResolver;
    }


}
