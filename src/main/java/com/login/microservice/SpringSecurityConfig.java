package com.login.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//import com.login.microservice.services.JPAUserDetailsService;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
//	@Autowired
//	private JPAUserDetailsService userds;
	
//	private BCryptPasswordEncoder passwordEncoder;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	El autowired es necesario para importar el objeto AuthenticationManagerBuilder
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
		
		
//		In Memory
		PasswordEncoder encoder = passwordEncoder();
		UserBuilder users = User.builder().passwordEncoder(encoder::encode);
		
		builder.inMemoryAuthentication()
			.withUser(users.username("admin").password("1234").roles("ADMIN", "USER")) //en forma automática el 1234 se va a encriptar.
			.withUser(users.username("Pablo").password("1234").roles("USER"));
		
//		builder.userDetailsService(userds)
//		.passwordEncoder(passwordEncoder);
	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
		
//		http.authorizeRequests().antMatchers("/").permitAll();
//								.anyRequest().authenticated();
//								.and()
//								.formLogin().loginPage("/login")
//								.permitAll()
//								.and()
//								.logout().permitAll();	
							     
//	}
	
    @Override
protected void configure(HttpSecurity http) 
  throws Exception {
    http.csrf().disable()
      .authorizeRequests()
      .antMatchers("/login").permitAll()
      .anyRequest()
      .authenticated()
      .and()
      .httpBasic();
}

}
