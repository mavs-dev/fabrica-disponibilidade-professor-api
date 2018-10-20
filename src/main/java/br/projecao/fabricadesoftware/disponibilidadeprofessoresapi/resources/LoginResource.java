package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model.Usuario;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginResource {

	@Autowired
	private UsuarioRepository repository;
	
	@PostMapping
	public ResponseEntity<String> validarUsuario(@RequestBody Usuario entity){
		Usuario usuario = repository.findByEmail(entity.getEmail());
		HttpStatus status = HttpStatus.OK;
		String sessionTime = "{\"sessionTime\":30}";
		if (usuario == null || !usuario.getSenha().equals(entity.getSenha())) {
			status = HttpStatus.UNAUTHORIZED;
			sessionTime = "";
		}
		return new ResponseEntity<String>(sessionTime, status);
	}
}
