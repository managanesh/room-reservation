package gani.ms.rrs.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

/**
 * Created by ganesh.vallabhaneni on 4/13/2015.
 */
@Configuration
@EnableJpaRepositories(basePackages = "gani.ms.rrs.`    `   ")
public class DBConfiguration {

    @ConfigurationProperties(prefix = "spring.datasource.pg")
    @Bean
    @Primary
    @Profile(value = "cloud")
    public DataSource dataSource(){

        return DataSourceBuilder.create().build();
    }

    @ConfigurationProperties(prefix = "spring.datasource.h2")
    @Bean(name="h2DataSource")
    @Profile(value = "local")
    public DataSource h2DataSource(){
        return DataSourceBuilder.create().build();
    }
}
