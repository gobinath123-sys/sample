package com.onesoft;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class Configarationclass {
	@Profile(value = "dev")
	@Bean
	public String devConf() {
		return "this is dev profile";

	}
	
	@Profile(value="uat")
	@Bean
	public String uatconf() {
		return "this is uat profile";
	}
	@Profile(value="prop")
	@Bean
	public void propconf() {
		System.out.println("this is  proprietary");
	}

}
