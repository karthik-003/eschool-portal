package amk.eschool.users.security.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import amk.eschool.users.service.UsersService;
import amk.eschool.users.utils.JwtUtil;
import net.bytebuddy.asm.Advice.This;

@Configuration
@EnableWebSecurity
public class UserSecurityConfig extends WebSecurityConfigurerAdapter{

	Logger logger = LoggerFactory.getLogger(This.class);
	@Autowired
	UsersService usrService;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(usrService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
		http
		.csrf().disable();

		http.headers().frameOptions().disable();
		
		http.authorizeRequests().antMatchers("/h2-console/**").permitAll()
		.and()
		.authorizeRequests().antMatchers("/users/**").permitAll()
		.anyRequest().authenticated();
	}
}
