package ru.dima.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "ru.dima.dao")
@PropertySource("classpath:db/connectionSettings.properties")
public class JavaConfig implements ApplicationContextAware {
    private ApplicationContext applicationContext;


    //Источник данных
    @Bean("poolConnectionDataSource")
    @Scope("singleton")
    public DataSource poolConnectionDataSource(
            @Value("${db.url}") String url,
            @Value("${db.user}") String user,
            @Value("${db.password}") String password,
            @Value("${db.driverClassName}") String driverClassName
    ) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    /*
    1. Создание фабрики entity manager-ов, на основе источника данных.
    2. Указание JPA Вендора.
    3. Где будем сканировать
     */
    @Bean("entityManagerFactory")
    @Scope("singleton")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        DataSource dataSource = applicationContext.getBean("poolConnectionDataSource", DataSource.class);

        LocalContainerEntityManagerFactoryBean manager = new LocalContainerEntityManagerFactoryBean();
        manager.setDataSource(dataSource);
        manager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        manager.setPackagesToScan("ru.dima.dao");
        return manager;
    }

    @Bean("transactionManager")
    @Scope("singleton")
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return transactionManager;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
