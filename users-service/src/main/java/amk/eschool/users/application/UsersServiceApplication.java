package amk.eschool.users.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import amk.eschool.utils.JwtUtil;

@SpringBootApplication
@ComponentScan(basePackages = "amk")
@EntityScan("amk")
@EnableJpaRepositories("amk")
public class UsersServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersServiceApplication.class, args);
	}

	@Bean
	public JwtUtil getJwtUtil() {
		return new JwtUtil();
	}
}
