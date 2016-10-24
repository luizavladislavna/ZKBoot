package com.digi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by tymoshenkol on 24-Oct-16.
 */
@ComponentScan
@Configuration
@EnableWebSecurity
public class ZKSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;

	@Override
	protected void configure (HttpSecurity http) throws Exception {
		http.sessionManagement().sessionFixation().none();
		http.authorizeRequests()
				.antMatchers(
						"/zkau*",                // <--- for zk ajax (internal)
						"/zkau/**",
						"/login*", "/logout",    // <--- for login/logout
						"/js/**",    // <--- static resources...
						"/css/**",
						"/bootstrap/**",
						"/img/**",
						"/static/**"
				)
				.permitAll().anyRequest().authenticated()
				.and()
				.headers().frameOptions().disable()
				.and()
				.formLogin().loginPage("/app/login.zul")
				.permitAll().defaultSuccessUrl("/app/welcome.zul", true) // this redirect allways to welcome.zul page
				.and()
				.logout().permitAll()
				.and()
				.csrf().disable();
	}

	@Autowired
	public void configureGlobal (AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder())
			.and()
			.inMemoryAuthentication().withUser("test").password("123").roles("USER");

	}

}
