package com.assement.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

import io.r2dbc.spi.ConnectionFactory;

@Configuration
public class DatabaseConfig
{
    @Value("classpath:/schema.sql")
    Resource schemaScript;

    @Bean
    ConnectionFactoryInitializer initializer( ConnectionFactory connectionFactory )
    {
        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory( connectionFactory );
        initializer.setDatabasePopulator( new ResourceDatabasePopulator( schemaScript ) );
        return initializer;
    }
}
