package ma.hotelbookingapp;

import org.h2.server.web.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import ma.hotelbookingapp.monolithic.data.entities.User_;
//import ma.hotelbookingapp.monolithic.security.UserAuditor;

@SpringBootApplication
//@ComponentScan(basePackages = {"monolithic.data.entities","monolithic.controllers","monolothic.services","monolithic.data.repositories", "monolithic.data.dtos"})
//(exclude = {DataSourceAutoConfiguration.class })
 
@EnableCaching
public class HotelBookingApp {

	public static void main(String[] args) {
		try{
		SpringApplication.run(HotelBookingApp.class, args);

		}
		catch (Exception e) {
            e.printStackTrace();
        }

		
	}
/*
	@Bean
    AuditorAware<User_> auditorProvider() {
        return new UserAuditor();
    }
	*/

}
