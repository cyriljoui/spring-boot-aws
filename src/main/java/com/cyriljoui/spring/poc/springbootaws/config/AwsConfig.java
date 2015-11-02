package com.cyriljoui.spring.poc.springbootaws.config;

import org.springframework.cloud.aws.context.config.annotation.EnableContextCredentials;
import org.springframework.cloud.aws.context.config.annotation.EnableContextRegion;
import org.springframework.cloud.aws.jdbc.config.annotation.EnableRdsInstance;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("aws")
@EnableRdsInstance(databaseName = "${RDS_INSTANCE1_DBNAME}", dbInstanceIdentifier = "${RDS_INSTANCE1_DBIDENTIFIER}", username = "${RDS_INSTANCE1_USERNAME}", password = "${RDS_INSTANCE1_PASSWORD}")
@EnableContextCredentials(accessKey = "${CONTEXT_CREDENTIALS_KEY}", secretKey = "${CONTEXT_CREDENTIALS_SECRET}")
@EnableContextRegion(region = "${CONTEXT_REGION}")
@Configuration
public class AwsConfig {

}
