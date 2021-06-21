package kr.or.connect.reservationProject.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "kr.or.connect.reservationProject.dao",  "kr.or.connect.reservationProject.service"})
@Import({ DBConfig.class })
public class ApplicationConfig {
	
}