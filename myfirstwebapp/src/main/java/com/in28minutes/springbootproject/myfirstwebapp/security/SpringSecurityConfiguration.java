package com.in28minutes.springbootproject.myfirstwebapp.security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {

		UserDetails userDetails1 = createNewUser("Tamiz", "1234");
		UserDetails userDetails2 = createNewUser("Monesha", "5678");
		UserDetails userDetails3 = createNewUser("Vithya", "4321");
		return new InMemoryUserDetailsManager(userDetails1, userDetails2, userDetails3);
	}

	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passEncoder = input -> passWordEncoder().encode(input);
		UserDetails userDetails = User.builder().passwordEncoder(passEncoder).username(username).password(password)
				.roles("ADMIN", "USER").build();
		return userDetails;
	}

	@Bean
	public PasswordEncoder passWordEncoder() {

		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filerChain(HttpSecurity httpSecu) throws Exception {
		httpSecu.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
		httpSecu.formLogin(withDefaults());
		httpSecu.csrf().disable();
		httpSecu.headers().frameOptions().disable();
		return httpSecu.build();
	}
}
