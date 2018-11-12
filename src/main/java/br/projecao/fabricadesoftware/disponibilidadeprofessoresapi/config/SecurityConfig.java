package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.security.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableAuthorizationServer
@EnableResourceServer
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final String[] PUBLIC_MATCHERS = {
			"/**/**"
	};
	
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.cors().and().csrf().disable();
		http.authorizeRequests()
			.antMatchers(PUBLIC_MATCHERS).permitAll()
			.anyRequest().authenticated();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	@Override
	public UserDetailsService userDetailsServiceBean() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		configuration.addAllowedMethod("PUT");
		configuration.addAllowedMethod("DELETE");
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceBean())
		.passwordEncoder(passwordEncoder());
	}
}
