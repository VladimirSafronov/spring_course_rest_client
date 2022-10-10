package com.zaurtregulov.spring.rest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("com.zaurtregulov.spring.rest")
public class MyConfig {

  //bean данного класса используется для осуществления http request
  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
