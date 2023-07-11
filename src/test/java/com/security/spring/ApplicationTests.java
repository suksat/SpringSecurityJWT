package com.security.spring;

import com.security.spring.configuration.WebSecurityConfig;
import com.security.spring.filter.JwtRequestFilter;
import com.security.spring.service.MyUserDetailsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private WebSecurityConfig webSecurityConfig;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	void contextLoads() {
		// Verify the presence of specific beans or configurations
		assertThat(webSecurityConfig).isNotNull();
		assertThat(jwtRequestFilter).isNotNull();
		assertThat(userDetailsService).isNotNull();
		assertThat(passwordEncoder).isNotNull();

		// Perform assertions or checks on the beans or configurations
		// For example, you can check if specific dependencies are injected correctly


		// Check if necessary Spring Security configurations are applied
		// For example, you can assert that CSRF protection is enabled
	}
}
