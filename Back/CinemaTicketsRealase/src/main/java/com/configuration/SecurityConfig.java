package com.configuration;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.filter.BasicAuthenticationVUFilter;
import com.filter.EncodingFilter;
import com.service.KinUserService;
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
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.io.IOException;
import java.time.LocalDateTime;


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
        auth.userDetailsService(kinUserService);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        final BasicAuthenticationVUFilter authenticationVUFilter = new BasicAuthenticationVUFilter(authenticationManagerBean(), jwtConfig());
        http
                .csrf().disable()
                .addFilterBefore(new FilterToken(jwtConfig(), kinUserService), UsernamePasswordAuthenticationFilter.class)
                .addFilter(authenticationVUFilter)
                .addFilterBefore(new EncodingFilter(), ChannelProcessingFilter.class)
                .authorizeRequests()
//                .antMatchers(HttpMethod.POST, "Film/image/**", "Film/save", "hall/**", "session/**", "reser/discount", "reser/setList/*").access("hasRole('ROLE_ADMIN')")
//                .antMatchers(HttpMethod.DELETE, "Film/**", "KinoUser/**", "buy/*", "hall/**", "session/**", "reser/deleteList/*").access("hasRole('ROLE_ADMIN')")
//                .antMatchers(HttpMethod.PUT, "Film/**", "KinoUser/block", "KinoUser/active", "hall/upd**", "session/**").access("hasRole('ROLE_ADMIN')")
//                .antMatchers(HttpMethod.PUT, "reser/**").permitAll()
//                .antMatchers("buy/save").access("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
//                .antMatchers(HttpMethod.GET, "KinoUser/*", "KinoUser/all").access("hasRole('ROLE_ADMIN')")
//                .antMatchers(HttpMethod.GET, "Film/**", "KinoUser/?**", "buy/**", "card/**",
//                        "hall/**", "session/**", "reser/**").permitAll()
//                .antMatchers("Film/rating/**", "KinoUser/save", "KinoUser/update", "buy", "card**", "hall/changeStatus**", "reser/delete/*", "reser/sav**").permitAll()
                .antMatchers("/**").permitAll()

                .anyRequest().permitAll()

                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin().disable()
                ;
    }
    public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {
        @Override
        public void serialize(LocalDateTime arg0, JsonGenerator arg1, SerializerProvider arg2) throws IOException {
            arg1.writeString(arg0.toString());
        }
    }

    public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
        @Override
        public LocalDateTime deserialize(JsonParser arg0, DeserializationContext arg1) throws IOException {
            return LocalDateTime.parse(arg0.getText());
        }
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
