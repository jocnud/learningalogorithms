package org.shahbaz.portal.security.portal.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfig
{
    @Bean
    public DataSource getDataSource()
    {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName( "com.mysql.jdbc.Driver" );
        driverManagerDataSource.setUrl( "jdbc:mysql://localhost:3306/portal" );
        driverManagerDataSource.setUsername( "root" );
        driverManagerDataSource.setPassword( "qaws12qaws" );
        return driverManagerDataSource;
    }

}
