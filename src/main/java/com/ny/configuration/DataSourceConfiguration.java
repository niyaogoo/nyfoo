package com.ny.configuration;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.eclipse.persistence.jpa.PersistenceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.DefaultPersistenceUnitManager;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.persistence.SharedCacheMode;
import java.util.Properties;

/**
 * 数据库配置
 */
@Configuration
public class DataSourceConfiguration {

    private Logger logger = LoggerFactory.getLogger(DataSourceConfiguration.class);

    @Bean
    @ConfigurationProperties("datasource")
    public DataSource masterDataSource() {
        DataSource dataSource = new DataSource();
        return dataSource;
    }

    @Bean
    public DefaultPersistenceUnitManager defaultPersistenceUnitManager(
            DataSource dataSource) {
        DefaultPersistenceUnitManager unitManager = new DefaultPersistenceUnitManager();
        unitManager.setPackagesToScan("com.ny");
        //unitManager.setSharedCacheMode(SharedCacheMode.NONE);
        unitManager.setDefaultDataSource(dataSource);
        unitManager.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
        return unitManager;
    }

    @Bean(name = "entityManagerFactory")
    @Autowired
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(
            DefaultPersistenceUnitManager unitManager, EclipseLinkJpaVendorAdapter adapter) {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitManager(unitManager);
        factoryBean.setPersistenceProvider(new PersistenceProvider());
        factoryBean.setJpaVendorAdapter(adapter);
        Properties properties = new Properties();
        //properties.put("eclipselink.ddl-generation.output-mode", "sql-script");
        // properties.put("eclipselink.create-ddl-jdbc-file-name", "create.ddl");
        //properties.put("eclipselink.drop-ddl-jdbc-file-name", "drop.ddl");
//        properties.put("eclipselink.ddl-generation", "none");
//        properties.put("eclipselink.ddl-generation", "create-or-extend-tables");
        // properties.put("eclipselink.ddl-generation", "drop-and-create-tables");
        //        properties.put("eclipselink.cache.shared.default", "false");
        //properties.put("eclipselink.deploy-on-startup", "false");
        //properties.put("eclipselink.logging.level", "FINEST");//INFO, FINE, FINEST

        //properties.put("eclipselink.weaving.internal", "false");
        //properties.put("eclipselink.weaving.lazy", "true");
        //        properties.put("eclipselink.weaving.dynamic", "true");//static
        //        properties.put("eclipselink.cache.coordination.protocol", "rmi");
        factoryBean.setJpaProperties(properties);
        return factoryBean;
    }

    @Bean
    public EclipseLinkJpaVendorAdapter eclipseLinkJpaVendorAdapter() {
        EclipseLinkJpaVendorAdapter adapter = new EclipseLinkJpaVendorAdapter();
        adapter.setGenerateDdl(false);
        adapter.setShowSql(true);
        return adapter;
    }

    @Bean("transactionManager")
    @Autowired
    public JpaTransactionManager jpaTransactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

}
