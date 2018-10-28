package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;


import java.util.HashMap;
import java.util.Map;

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
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.util.CriptografiaUtil;

@RestController
@RequestMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginResource {

	@Autowired
	private UsuarioRepository repository;
	
	@PostMapping
	public ResponseEntity<Map<String, String>> validarUsuario(@RequestBody Usuario entity){
		Usuario usuario = repository.findByEmail(entity.getEmail());
		entity.setSenha(CriptografiaUtil.getHash(entity.getSenha()));
		HttpStatus status = HttpStatus.NON_AUTHORITATIVE_INFORMATION;
		Map<String, String> resposta = new HashMap<>();
		if (usuario != null && usuario.getSenha().equals(entity.getSenha())) {
			status = HttpStatus.OK;
			resposta.put("sessionTime", "30");
			resposta.put("idUsuario", usuario.getId().toString());
			resposta.put("nomeUsuario", usuario.getNome());
			resposta.put("isDadosProfissionaisPreenchidos", usuario.getDadosProfissionais() != null ? "true" : "false");
			resposta.put("mensagem", "sucesso");
		} else {
			resposta.put("mensagemErro", "E-mail ou senha inválida");
		}
		return new ResponseEntity<Map<String, String>>(resposta, status);
	}
}
