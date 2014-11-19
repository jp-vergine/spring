package com.tutorials.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:tutorials.properties")
/** 
 * @See <a href="http://www.baeldung.com/2012/02/06/properties-with-spring/#raw3_0">Configuration</a>
 */
 public class PropertyConfig {
 
   @Bean
   public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
      return new PropertySourcesPlaceholderConfigurer();
   }
}