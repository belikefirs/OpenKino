package com.configuration;

import com.components.ListeningProperties;
import org.apache.log4j.Logger;
import org.h2.jdbcx.JdbcDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;

@Configuration
@EnableJpaRepositories(basePackages = "com")
@EnableTransactionManagement
public class JPAConfiguration {
    private static final Logger logger = Logger.getLogger(JPAConfiguration.class);
    ListeningProperties listeningProperties;
    @Bean
    public DataSource dataSource(){
        try {
            listeningProperties = new ListeningProperties();
            logger.info("database url found");
        } catch (IOException e) {
            logger.warn(e.getMessage());
        }
        JdbcDataSource jdbcDataSource = new JdbcDataSource();
        jdbcDataSource.setURL(listeningProperties.getUrl());
        jdbcDataSource.setUser("admin");
        jdbcDataSource.setPassword("admin");
        logger.info("Database connection successful");
        return jdbcDataSource;
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        HashMap<String, String > hibernatePropertys = new HashMap<>();
        hibernatePropertys.put("hibernate.hbm2ddl.auto","update");
        hibernatePropertys.put("hibernate.connection.driver_class","org.h2.Driver");
        hibernatePropertys.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
        hibernatePropertys.put("hibernate.show_sql","true");
        hibernatePropertys.put("hibernate.generate_statistics","true");
        hibernatePropertys.put("hibernate.connection.charSet","UTF-8");
        hibernatePropertys.put("hibernate.format_sql","true");
        hibernatePropertys.put("hibernate.use_sql_comments","true");
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setGenerateDdl(true);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(adapter);
        factory.setPackagesToScan("com");
        factory.setDataSource(dataSource());
        factory.setJpaPropertyMap(hibernatePropertys);
        logger.info("Hibernate is configured");
        return factory;
    }
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactory);
        manager.setDataSource(dataSource());
        return manager;
    }
}
