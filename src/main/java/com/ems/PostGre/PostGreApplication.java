package com.ems.PostGre;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PostGreApplication {
	@Bean
	public OpenAPI customOpenApi(){
		return new OpenAPI()
				.info(new Info()
						.title("MY EMS APP")
						.version("1.0.0")
						.description("This is a EMS APP"));
	}
	public static void main(String[] args) {
		SpringApplication.run(PostGreApplication.class, args);
	}

}
