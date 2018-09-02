package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models.DisciplinaDeInteresse;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository.DisciplinaDeInteresseRepository;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

public class DisciplinaDeInteresseResource implements Resource<DisciplinaDeInteresse>{

	@Autowired
	private DisciplinaDeInteresseRepository repository;
	
	public ResponseEntity<List<DisciplinaDeInteresse>> getAll() {
		List<DisciplinaDeInteresse> lista = repository.findAll();
		HttpStatus status = HttpStatus.OK;
		if(lista == null || lista.isEmpty()) {
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<List<DisciplinaDeInteresse>>(lista, getHeader(), status);
	}
	
	public ResponseEntity<Optional<DisciplinaDeInteresse>> getOne(Long id) {
		Optional<DisciplinaDeInteresse> model = repository.findById(id);
		HttpStatus status = HttpStatus.OK;
		if(!model.isPresent()) {
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<Optional<DisciplinaDeInteresse>>(model, getHeader(), status);
	}
	
	public ResponseEntity<DisciplinaDeInteresse> post(@RequestBody @Valid DisciplinaDeInteresse entity) {
		HttpStatus status = HttpStatus.CREATED;
		Map<String, String> contents = new HashMap<>();
		try {
			repository.save(entity);
		} catch (Exception e) {
			status = HttpStatus.NOT_MODIFIED;
			contents.put(HttpHeaders.WARNING, e.getMessage());
		}
		
		return new ResponseEntity<>(null, getHeader(contents), status);
	}
	
	public ResponseEntity<DisciplinaDeInteresse> patch(@PathVariable("id") Long id, @RequestBody DisciplinaDeInteresse entity) {
		entity.setId(id);
		fillInBlankFields(entity);
		repository.save(entity);
		HttpStatus status = HttpStatus.ACCEPTED;
		if(entity.getId() == null || entity.getId().longValue() <= 0) {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, getHeader(), status);
	}
	
	public ResponseEntity<DisciplinaDeInteresse> put(@PathVariable("id") Long id, @RequestBody DisciplinaDeInteresse entity) {
		entity.setId(id);
		repository.save(entity);
		HttpStatus status = HttpStatus.ACCEPTED;
		if(entity.getId() == null || entity.getId().longValue() <= 0) {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, getHeader(), status);
	}
	
	public ResponseEntity<DisciplinaDeInteresse> delete(@PathVariable("id") Long id) {
		HttpStatus status = HttpStatus.NO_CONTENT;
		if(repository.existsById(id)) {
			repository.deleteById(id);
		}else {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, getHeader(), status);
	}
	
	public void fillInBlankFields(DisciplinaDeInteresse entity) {
		DisciplinaDeInteresse oldEntity = repository.findById(entity.getId()).get();
		merge(entity, oldEntity);
	}
	
	public void merge(DisciplinaDeInteresse newEntity, DisciplinaDeInteresse oldEntity) {
		// TODO Auto-generated method stub
		
	}

}
