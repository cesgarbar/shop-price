package com.inditex.retail.shopprice.app.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Slf4j
@Configuration
@EnableJpaRepositories(
        basePackages = "com.inditex.retail.shopprice.module.infrastructure.out.db",
        entityManagerFactoryRef = "entityManager",
        transactionManagerRef = "transactionManager")
public class H2Config {

    @Bean
    @ConfigurationProperties(prefix = "datasources.h2")
    public DataSourceProperties dataSourceProperties() {

        log.warn("Database_profile: {}, datasource {}", "all", "H2Configurer");
        return new DataSourceProperties();
    }

    @Bean
    public DataSource dataSource() {
        return dataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManager() {

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setJpaVendorAdapter(vendorAdaptor());
        em.setDataSource(dataSource());
        em.setPersistenceUnitName("persistenceUnit");
        em.setPackagesToScan("com.inditex.retail.shopprice.module.infrastructure.out.db");
        em.afterPropertiesSet();
        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {

        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManager().getObject());
        return transactionManager;
    }

    private HibernateJpaVendorAdapter vendorAdaptor() {

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
        return vendorAdapter;
    }
}
