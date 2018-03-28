package com.demo.slk.application.cache;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
//https://www.mkyong.com/spring/spring-propertysources-example/
@Configuration
@PropertySource(value="classpath:apiurl.properties",ignoreResourceNotFound=true)
/*@PropertySources({
	@PropertySource("classpath:config.properties"),
	@PropertySource("classpath:db.properties")
})*/
//@PropertySource("file:${app.home}/app.properties")
public class PropertiesConfig {
   @Bean
   public static PropertySourcesPlaceholderConfigurer
     propertySourcesPlaceholderConfigurer() {
      return new PropertySourcesPlaceholderConfigurer();
   }
  /* @Bean
   public static PropertyPlaceholderConfigurer properties() {
     PropertyPlaceholderConfigurer ppc
       = new PropertyPlaceholderConfigurer();
     Resource[] resources = new ClassPathResource[]
       { new ClassPathResource( "foo.properties" ) };
     ppc.setLocations( resources );
     ppc.setIgnoreUnresolvablePlaceholders( true );
     return ppc;
   }*/
}
