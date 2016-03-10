package com.escola.ministerios.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.escola.ministerios.repository")
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.escola.ministerios.domain"})
public class RepositoryConfig {
}
