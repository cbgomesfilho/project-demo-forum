package br.com.cbgomes;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Forum API", version = "2.0",
		description = "This api represents the process of questions and answers about topics of doubts"))
public class DemoJwtSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoJwtSpringSecurityApplication.class, args);
	}

}
