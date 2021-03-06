package com.example.e_tron.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.e_tron.filter.JwtFilter;
import com.example.e_tron.services.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class Securityconfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private CustomUserDetailsService userdetailsService;
	
	 @Autowired
	 private JwtFilter jwtFilter;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(auth);
		auth.userDetailsService(userdetailsService);
	}
	
	 @Bean
	    public PasswordEncoder passwordEncoder(){
	        return NoOpPasswordEncoder.getInstance();
	    }

	    
	    @Override
	    @Bean//(name = BeanIds.AUTHENTICATION_MANAGER)
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	 http.csrf().disable().authorizeRequests().antMatchers("/utilisateur/Inscription").permitAll();
	        http.csrf().disable().authorizeRequests().antMatchers("/utilisateur/connexion").permitAll().anyRequest().authenticated();
//	                .and().exceptionHandling().and().sessionManagement()
//	                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//	        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	    }

}
