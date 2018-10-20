package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model.Usuario;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository.UsuarioRepository;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.util.CriptografiaUtil;

@RestController
@RequestMapping(value = "/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioResource implements Resource<Usuario> {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public ResponseEntity<List<Usuario>> getAll() {
		List<Usuario> lista = repository.findAll();
		HttpStatus status = HttpStatus.OK;
		if (lista == null || lista.isEmpty()) {
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<List<Usuario>>(lista, status);
	}

	@Override
	public ResponseEntity<Optional<Usuario>> getOne(@PathVariable("id") Long id) {
		Optional<Usuario> model = repository.findById(id);
		HttpStatus status = HttpStatus.OK;
		if (!model.isPresent()) {
			model = null;
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<Optional<Usuario>>(model, status);
	}

	public ResponseEntity<Usuario> post(@RequestBody Usuario entity) {
		criptografarSenha(entity);
		entity.setDataHoraCadastro(LocalDateTime.now());
		HttpStatus status = HttpStatus.CREATED;
		try {
			repository.save(entity);
		} catch (Exception e) {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, status);
	}

	@Override
	public ResponseEntity<Usuario> patch(@PathVariable("id") Long id, @RequestBody Usuario entity) {
		/*
		 * entity.setId(id); fillInBlankFields(entity); repository.save(entity);
		 * HttpStatus status = HttpStatus.ACCEPTED; if (entity.getId() == null ||
		 * entity.getId().longValue() <= 0) { status = HttpStatus.NOT_MODIFIED; }
		 */
		return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<Usuario> put(@PathVariable("id") Long id, @RequestBody Usuario entity) {
		entity.setId(id);
		repository.save(entity);
		HttpStatus status = HttpStatus.ACCEPTED;
		if (entity.getId() == null || entity.getId().longValue() <= 0) {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, status);
	}

	@Override
	public ResponseEntity<Usuario> delete(@PathVariable("id") Long id) {
		HttpStatus status = HttpStatus.NO_CONTENT;
		if (repository.existsById(id)) {
			repository.deleteById(id);
		} else {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, status);
	}

	@Override
	public void fillInBlankFields(Usuario entity) {

	}

	@Override
	public void merge(Usuario newEntity, Usuario oldEntity) {

	}
	
	private void criptografarSenha(Usuario entity) {
		entity.setSenha(CriptografiaUtil.getHash(entity.getSenha()));
	}

}
