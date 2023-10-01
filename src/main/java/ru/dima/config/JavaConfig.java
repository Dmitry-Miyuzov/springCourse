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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.dima.dao.courseDao.CourseDao;
import ru.dima.dao.courseDao.concrete.JdbcCourseDao;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:db/connectionSettings.properties")
public class JavaConfig implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Bean("springDataSource")
    @Scope("singleton")
    public DataSource springDataSource(
            @Value("${db.url}") String url,
            @Value("${db.user}") String user,
            @Value("${db.password}") String password,
            @Value("${db.driverClassName}") String driverClassName
    ) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url, user, password);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

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

    @Bean("jdbcTemplate")
    @Scope("singleton")
    public JdbcTemplate jdbcTemplate() {
        //todo либо springDataSource, либо poolConnectionDataSource - сделал для примера
        var dataSource = applicationContext.getBean("poolConnectionDataSource", DataSource.class);
        return new JdbcTemplate(dataSource);
    }

    @Bean("jdbcCourseDao")
    @Scope("singleton")
    public CourseDao jdbcCourseDao() {
        var jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        return new JdbcCourseDao(jdbcTemplate);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
