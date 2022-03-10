package com.pump.pumpservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.TimeZone;

@SpringBootApplication
@EnableSwagger2
public class PumpServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PumpServiceApplication.class, args);
	}

	@Bean
	public Jackson2ObjectMapperBuilderCustomizer jacksonObjectMapperCustomization() {
		return jacksonObjectMapperBuilder ->
				jacksonObjectMapperBuilder.timeZone(TimeZone.getTimeZone("UTC"));
	}

}
