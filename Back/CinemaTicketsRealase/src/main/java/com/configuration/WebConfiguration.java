package com.configuration;

import com.filter.EncodingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("com")
public class WebConfiguration implements WebMvcConfigurer {

    @Bean

    public InternalResourceViewResolver setupViewResolver(){

        InternalResourceViewResolver resolver = new InternalResourceViewResolver();

        resolver.setPrefix("WEB-INF/pages/");

        resolver.setSuffix(".jsp");

        resolver.setViewClass(JstlView.class);

        return resolver;

    }

}