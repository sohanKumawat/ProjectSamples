package com.app.demo.services.gateway;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//https://stackoverflow.com/questions/42613899/inmemoryauthentication-with-spring-boot
@Configuration
@EnableWebSecurity
@Order(-10)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.formLogin()
        .loginPage("login")
        .permitAll()
        .loginProcessingUrl("/login")
        .failureUrl("/login.html?error=true")
        .defaultSuccessUrl("/user/index")
        .and()
    .exceptionHandling()
        .accessDeniedPage("/denied")
        .and()
    .authorizeRequests()
      //  .antMatchers("/mockup/**").permitAll()
        //.antMatchers("/books/**").permitAll()
        .antMatchers("/v1/api/service/**").authenticated()
        .and()
    .logout()
        .permitAll()
        .logoutSuccessUrl("/login.html");
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource);
//		auth.inMemoryAuthentication().withUser("root").password("password").roles("USER");
	}
	
}
