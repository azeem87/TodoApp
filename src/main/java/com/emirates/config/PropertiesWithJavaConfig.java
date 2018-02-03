package com.emirates.config;

import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.emirates.util.PropertiesUtils;


@Configuration
@PropertySource("classpath:application.properties")
public class PropertiesWithJavaConfig {
 
   @Bean
   public static PropertyPlaceholderConfigurer
     propertySourcesPlaceholderConfigurer() {
      return new PropertiesUtils();
   }
   
   @Bean
	public ServletRegistrationBean h2servletRegistration() {
	    ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
	    registration.addUrlMappings("/console/*");
	    return registration;
	}
	
}
