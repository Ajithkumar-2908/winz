package com.aj.winz.shared.persistence;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan
@EnableJpaRepositories
@EntityScan
@EnableTransactionManagement
@PropertySource("classpath:persistence/persistence.yaml")
public class PersistenceConfiguration {
}
