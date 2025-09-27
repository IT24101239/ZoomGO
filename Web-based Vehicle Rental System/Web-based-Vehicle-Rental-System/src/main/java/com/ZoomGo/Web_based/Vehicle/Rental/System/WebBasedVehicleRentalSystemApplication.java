package com.ZoomGo.Web_based.Vehicle.Rental.System;

import ch.qos.logback.core.model.Model;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebBasedVehicleRentalSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebBasedVehicleRentalSystemApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
