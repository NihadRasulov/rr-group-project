package com.example.project.configuration.dbConfig;

import jakarta.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.project.repository.content",
        entityManagerFactoryRef = "contentEntityManagerFactory",
        transactionManagerRef = "contentTransactionManager"
)
public class ContentDbConfig {


    @Bean
    public DataSource contentDataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:postgresql://localhost:5434/contentDB")
                .username("contentDB")
                .password("root")
                .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean contentEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(contentDataSource())
                .packages("com.example.project.model.content") // User entities
                .persistenceUnit("contentdb")
                .build();
    }
    @Bean
    public PlatformTransactionManager contentTransactionManager(
            @Qualifier("contentEntityManagerFactory") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
