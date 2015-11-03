package com.cyriljoui.spring.poc.springbootaws.config;

import org.springframework.cloud.aws.context.config.annotation.EnableContextCredentials;
import org.springframework.cloud.aws.context.config.annotation.EnableContextRegion;
import org.springframework.cloud.aws.jdbc.config.annotation.EnableRdsInstance;
import org.springframework.cloud.aws.jdbc.config.annotation.RdsInstanceConfigurer;
import org.springframework.cloud.aws.jdbc.datasource.DataSourceFactory;
import org.springframework.cloud.aws.jdbc.datasource.TomcatJdbcDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("aws")
@EnableRdsInstance(databaseName = "${RDS_INSTANCE1_DBNAME}", dbInstanceIdentifier = "${RDS_INSTANCE1_DBIDENTIFIER}", username = "${RDS_INSTANCE1_USERNAME}", password = "${RDS_INSTANCE1_PASSWORD}")
@EnableContextCredentials(accessKey = "${CONTEXT_CREDENTIALS_KEY}", secretKey = "${CONTEXT_CREDENTIALS_SECRET}")
@EnableContextRegion(region = "${CONTEXT_REGION}")
@Configuration
public class AwsConfig {

    @Bean
    public RdsInstanceConfigurer instanceConfigurer() {
        // Custom configuration for RDS Connection Pool
        // Specially for test-on-borrow & validation query
        return new RdsInstanceConfigurer() {
            @Override
            public DataSourceFactory getDataSourceFactory() {
                TomcatJdbcDataSourceFactory dataSourceFactory = new TomcatJdbcDataSourceFactory();
                dataSourceFactory.setInitialSize(2);
                dataSourceFactory.setMaxIdle(2);
                dataSourceFactory.setMaxActive(10);
                dataSourceFactory.setValidationQuery("SELECT 1 FROM DUAL");
                dataSourceFactory.setTestOnBorrow(true);
                return dataSourceFactory;
            }
        };
    }
}
