package es.inmolab.demo.security.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecSecurityConfig {

	@Bean
	public UserDetailsManager users(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .csrf().disable()
	        .authorizeRequests(authorize -> authorize
	            .requestMatchers(HttpMethod.GET, "/css/**", "/js/**", "/img/**", "/logos/**").permitAll()
	            .requestMatchers("/admin/**").hasRole("ADMIN")
	            .anyRequest().authenticated()
	        )
	        .headers(headers -> headers.frameOptions().sameOrigin())
	        .formLogin(form -> form
	            .loginPage("/login")
	            .failureUrl("/loginError")
	            .defaultSuccessUrl("/dashboard", true) // Redirigir a dashboard después de iniciar sesión exitosamente
	            .permitAll()
	        )
	        .exceptionHandling(exception -> exception
	            .accessDeniedPage("/accessDenied")
	        )
	        .logout(logout -> logout.permitAll());

	    return http.build();
	}


	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
