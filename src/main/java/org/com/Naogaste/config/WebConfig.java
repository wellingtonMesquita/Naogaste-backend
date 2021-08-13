package org.com.Naogaste.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class WebConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {

        return new BCryptPasswordEncoder();
    }

  public void addCorsMappings(CorsRegistry corsRegistry) {
    corsRegistry.addMapping("/**")
      .allowedOrigins("https://naogaste.herokuapp.com")
      .allowedMethods("*")
      .maxAge(3600L)
      .allowedHeaders("*")
      .exposedHeaders("Authorization")
      .allowCredentials(true);
  }
}
