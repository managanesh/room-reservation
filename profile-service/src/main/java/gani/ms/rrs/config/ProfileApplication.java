package gani.ms.rrs.config;

import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import gani.ms.rrs.web.filters.CorrelationHeaderFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
@ComponentScan(basePackages = "gani.ms.rrs.*")
public class ProfileApplication {


    public static void main(String[] args) {
        SpringApplication.run(ProfileApplication.class, args);
    }


    @Bean
    public Jackson2ObjectMapperBuilder jacksonBuilder() {

        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();

        Hibernate4Module h4Module = new Hibernate4Module();
        h4Module.enable(Hibernate4Module.Feature.FORCE_LAZY_LOADING);
        builder.modules(h4Module);
        builder.indentOutput(true).dateFormat(new SimpleDateFormat("yyyy-MM-dd"));

        return builder;
    }

    @Bean
    public FilterRegistrationBean correlationHeaderFilter() {
        FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
        filterRegBean.setFilter(new CorrelationHeaderFilter());
        filterRegBean.setUrlPatterns(Arrays.asList("/*"));

        return filterRegBean;
    }

}


