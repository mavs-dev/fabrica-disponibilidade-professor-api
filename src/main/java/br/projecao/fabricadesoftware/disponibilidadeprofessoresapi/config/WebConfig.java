package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	@Override
    public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**");
//		.allowedHeaders("Content-Type: application/json","Accept: application/json")
//		.allowedMethods("GET","POST","PUT","PATCH","DELETE");
    }

}
