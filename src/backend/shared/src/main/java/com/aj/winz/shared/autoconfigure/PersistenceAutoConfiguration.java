package com.aj.winz.shared.autoconfigure;

import com.aj.winz.shared.persistence.PersistenceConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@ConditionalOnProperty(name = "app.shared.persistence-operations.enabled", havingValue = "true")
@Configuration
@Import(PersistenceConfiguration.class)
public class PersistenceAutoConfiguration {
}
