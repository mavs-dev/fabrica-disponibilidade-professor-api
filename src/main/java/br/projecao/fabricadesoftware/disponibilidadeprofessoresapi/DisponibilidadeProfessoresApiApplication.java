package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.config.DatabaseConfig;

@SpringBootApplication
public class DisponibilidadeProfessoresApiApplication {
	
	private static final String INPUT_HOST = "-h=";
	private static final String INPUT_PORT = "-p=";
	private static final String INPUT_USER = "-u=";
	private static final String INPUT_PASS = "-s=";
	private static final String INPUT_DDL_AUTO = "-ddl=";
	private static final String INPUT_SHOW_SQL = "-show-sql=";

	public static void main(String[] args) {
		try {
			for(String arg: args) {
				if(arg.contains(INPUT_HOST) && !arg.replace(INPUT_HOST, "").isEmpty()) {
					DatabaseConfig.URL = DatabaseConfig.URL.replace("localhost", arg.replace(INPUT_HOST, ""));
				}else if(arg.contains(INPUT_PORT) && !arg.replace(INPUT_PORT, "").isEmpty()) {
					DatabaseConfig.URL = DatabaseConfig.URL.replace("5432", arg.replace(INPUT_PORT, ""));
				}else if(arg.contains(INPUT_USER) && !arg.replace(INPUT_USER, "").isEmpty()) {
					DatabaseConfig.USERNAME = arg.replace(INPUT_USER, "");
				}else if(arg.contains(INPUT_PASS) && !arg.replace(INPUT_PASS, "").isEmpty()) {
					DatabaseConfig.PASSWORD = arg.replace(INPUT_PASS, "");
				}else if(arg.contains(INPUT_DDL_AUTO) && !arg.replace(INPUT_DDL_AUTO, "").isEmpty()) {
					DatabaseConfig.DDL_AUTO = arg.replace(INPUT_DDL_AUTO, "");
				}else if(arg.contains(INPUT_SHOW_SQL) && !arg.replace(INPUT_SHOW_SQL, "").isEmpty()) {
					DatabaseConfig.SHOW_SQL = arg.replace(INPUT_SHOW_SQL, "");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		SpringApplication.run(DisponibilidadeProfessoresApiApplication.class, args);
	}
	
}
