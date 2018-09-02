 package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models.TipoUsuario;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository.TipoUsuarioRepository;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

@RestController
@RequestMapping(value="/tipo-usuario", consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class TipoUsuarioResource implements Resource<TipoUsuario>{
	
	@Autowired
	private TipoUsuarioRepository repository;
	
	public ResponseEntity<List<TipoUsuario>> getAll() {
		List<TipoUsuario> listaTiposUsuario = repository.findAll();
		HttpStatus status = HttpStatus.OK;
		if(listaTiposUsuario == null || listaTiposUsuario.isEmpty()) {
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<List<TipoUsuario>>(listaTiposUsuario, getHeader(), status);
	}

	public ResponseEntity<Optional<TipoUsuario>> getOne(@PathVariable("id") Long id) {
		Optional<TipoUsuario> tipoUsuario = repository.findById(id);
		HttpStatus status = HttpStatus.OK;
		if(!tipoUsuario.isPresent()) {
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<Optional<TipoUsuario>>(tipoUsuario, getHeader(), status);
	}

	public ResponseEntity<TipoUsuario> post(@RequestBody @Valid TipoUsuario entity) {
		HttpStatus status = HttpStatus.CREATED;
		Map<String, String> contents = new HashMap<>();
		try {
			repository.save(entity);
		} catch (Exception e) {
			status = HttpStatus.NOT_MODIFIED;
			TipoUsuario tipoUsuario = repository.findByDescricao(entity.getDescricao());
			contents.put(HttpHeaders.LOCATION, tipoUsuario.getId().toString());
			contents.put(HttpHeaders.WARNING, e.getMessage());
		}
		
		return new ResponseEntity<>(null, getHeader(contents), status);
	}

	public ResponseEntity<TipoUsuario> patch(@PathVariable("id") Long id, @RequestBody TipoUsuario entity) {
		entity.setId(id);
		fillInBlankFields(entity);
		repository.save(entity);
		HttpStatus status = HttpStatus.ACCEPTED;
		if(entity.getId() == null || entity.getId().longValue() <= 0) {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, getHeader(), status);
	}
	
	public ResponseEntity<TipoUsuario> put(@PathVariable("id") Long id, @RequestBody TipoUsuario entity) {
		entity.setId(id);
		repository.save(entity);
		HttpStatus status = HttpStatus.ACCEPTED;
		if(entity.getId() == null || entity.getId().longValue() <= 0) {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, getHeader(), status);
	}

	public ResponseEntity<TipoUsuario> delete(@PathVariable("id") Long id) {
		HttpStatus status = HttpStatus.NO_CONTENT;
		if(repository.existsById(id)) {
			repository.deleteById(id);
		}else {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, getHeader(), status);
	}

	@Override
	public void fillInBlankFields(TipoUsuario entity) {
		TipoUsuario oldEntity = repository.findById(entity.getId()).get();
		merge(entity, oldEntity);
	}

	@Override
	public void merge(TipoUsuario newEntity, TipoUsuario oldEntity) {
		newEntity.setDescricao((newEntity.getDescricao() !=null && !newEntity.getDescricao().isEmpty())? newEntity.getDescricao(): oldEntity.getDescricao());
		newEntity.setNivelAcesso((newEntity.getNivelAcesso() !=null && !newEntity.getNivelAcesso().name().isEmpty())? newEntity.getNivelAcesso(): oldEntity.getNivelAcesso());
	}

}
