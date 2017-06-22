package edu.mum.coffee.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import edu.mum.coffee.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private UserDetailsServiceImpl uService;
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/", "/home", "/index", "/registration").permitAll()
			.antMatchers("/userPage").hasAuthority("USER")
			.antMatchers("/secure").hasAuthority("ADMIN")
			.anyRequest()
			.authenticated()
			.and()
				.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
				.logout()
				.permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
		
	}
}
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.ComponentScan;
// import org.springframework.context.annotation.Configuration;
// import
// org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import
// org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
// @Configuration
// @EnableWebSecurity
// @ComponentScan(basePackages = "edu.mum.coffee")
// @EnableGlobalMethodSecurity(prePostEnabled = true)
// public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
// @Bean
// public BCryptPasswordEncoder bCryptPasswordEncoder(){
// return new BCryptPasswordEncoder();
// }
// @Override
// protected void configure(HttpSecurity http) throws Exception {
// http
// .csrf().disable()
// .authorizeRequests()
// .antMatchers("/", "/home", "/index").permitAll()
//// .antMatchers("/secure").hasAnyRole("ADMIN")
//// .antMatchers("/userPage").hasAnyRole("USER")
//// .antMatchers("/userPage").hasAnyRole("USER")
// .anyRequest().authenticated()
// .and()
// .formLogin()
// .permitAll()
// .and()
// .logout()
// .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
// .logoutSuccessUrl("/")
// .permitAll();
// }
//
// @Autowired
// public void configureGlobal(AuthenticationManagerBuilder auth) throws
// Exception {
// auth.inMemoryAuthentication().withUser("super").password("pw").roles("ADMIN");
// auth.inMemoryAuthentication().withUser("user").password("pw").roles("USER");
//
//
// }
// }