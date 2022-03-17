package br.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration // Tells spring that this class is configuration
@EnableWebSecurity // Tells spring that this class not only contains configurations, it also contains configurations for web
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/index").access("hasAnyAuthority('USERS', 'ADMIN')")
			.antMatchers("/private-page").access("hasAuthority('ADMIN')")
			.anyRequest().authenticated().and().formLogin()
			.and()
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/login").permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("ramon")
			.password(passwordEncoder().encode("123"))
			.authorities("ADMIN")
			.and()
			.withUser("maria")
			.password(passwordEncoder().encode("456"))
			.authorities("USER");
	}
	
	
}
