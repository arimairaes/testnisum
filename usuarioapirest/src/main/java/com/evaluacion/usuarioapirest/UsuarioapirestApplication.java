package com.evaluacion.usuarioapirest;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(
		servers = {
				@Server(
						url="/",
						description = "Servidor local"
				)


		},
		info = @Info(
				title = "Servicios de Usuario para entrevista NISUM",
				version = "1.0.0",
				description = "Servicios de Usuario para entrevista NISUM"
		)
)
@SpringBootApplication
public class UsuarioapirestApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuarioapirestApplication.class, args);
	}

}
