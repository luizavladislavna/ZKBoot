package com.digi.config;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
@PropertySource( value = "classpath:application-database.properties")
public class JpaRepositoryConfig extends HikariConfig {

    @Bean
    public DataSource dataSource() throws SQLException {
        return new HikariDataSource(this);
    }

}