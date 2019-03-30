package com.lcydream.project.springbootconfiguration;

import com.lcydream.project.springbootconfiguration.domain.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author LuoCY
 */
@SpringBootApplication
@EnableConfigurationProperties(Car.class)
public class SpringBootConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConfigurationApplication.class, args);
	}
}
