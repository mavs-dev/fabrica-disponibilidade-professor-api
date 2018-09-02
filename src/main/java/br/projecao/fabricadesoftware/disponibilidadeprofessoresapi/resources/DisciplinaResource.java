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

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models.Disciplina;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository.DisciplinaRepository;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

@RestController
@RequestMapping(value="/disciplina", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
public class DisciplinaResource implements Resource<Disciplina>{

	@Autowired
	private DisciplinaRepository repository;
	
	public ResponseEntity<List<Disciplina>> getAll() {
		List<Disciplina> lista = repository.findAll();
		HttpStatus status = HttpStatus.OK;
		if(lista == null || lista.isEmpty()) {
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<List<Disciplina>>(lista, getHeader(), status);
	}
	
	public ResponseEntity<Optional<Disciplina>> getOne(Long id) {
		Optional<Disciplina> model = repository.findById(id);
		HttpStatus status = HttpStatus.OK;
		if(!model.isPresent()) {
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<Optional<Disciplina>>(model, getHeader(), status);
	}
	
	public ResponseEntity<Disciplina> post(@RequestBody @Valid Disciplina entity) {
		HttpStatus status = HttpStatus.CREATED;
		Map<String, String> contents = new HashMap<>();
		try {
			repository.save(entity);
		} catch (Exception e) {
			status = HttpStatus.NOT_MODIFIED;
			Disciplina disciplina = repository.findByDescricao(entity.getDescricao());
			contents.put(HttpHeaders.LINK, disciplina.getId().toString());
			contents.put(HttpHeaders.WARNING, e.getMessage());
		}
		
		return new ResponseEntity<>(null, getHeader(contents), status);
	}
	
	public ResponseEntity<Disciplina> patch(@PathVariable("id") Long id, @RequestBody Disciplina entity) {
		entity.setId(id);
		fillInBlankFields(entity);
		repository.save(entity);
		HttpStatus status = HttpStatus.ACCEPTED;
		if(entity.getId() == null || entity.getId().longValue() <= 0) {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, getHeader(), status);
	}
	
	public ResponseEntity<Disciplina> put(@PathVariable("id") Long id, @RequestBody Disciplina entity) {
		entity.setId(id);
		repository.save(entity);
		HttpStatus status = HttpStatus.ACCEPTED;
		if(entity.getId() == null || entity.getId().longValue() <= 0) {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, getHeader(), status);
	}
	
	public ResponseEntity<Disciplina> delete(@PathVariable("id") Long id) {
		HttpStatus status = HttpStatus.NO_CONTENT;
		if(repository.existsById(id)) {
			repository.deleteById(id);
		}else {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, getHeader(), status);
	}
	
	public void fillInBlankFields(Disciplina entity) {
		Disciplina oldEntity = repository.findById(entity.getId()).get();
		merge(entity, oldEntity);
	}
	
	public void merge(Disciplina newEntity, Disciplina oldEntity) {
		// TODO Auto-generated method stub
		
	}

}
