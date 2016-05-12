package ru.ekonomov.config;

import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@Configuration
@ComponentScan(basePackages={"ru.ekonomov"},
        excludeFilters={@Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)})
@PropertySource("classpath:application.properties")
public class RootConfig
{
        @Bean
        public static PropertySourcesPlaceholderConfigurer   propertySourcesPlaceholderConfigurer() {
                return new PropertySourcesPlaceholderConfigurer();
        }

}
