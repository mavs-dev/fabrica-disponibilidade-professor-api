package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models.DisciplinaMinistrada;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository.DisciplinaMinistradaRepository;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

@RestController
@RequestMapping(value="/disciplina-ministrada", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
public class DisciplinaMinistradaResource implements Resource<DisciplinaMinistrada>{
	
	@Autowired
	private DisciplinaMinistradaRepository repository;

	public ResponseEntity<List<DisciplinaMinistrada>> getAll() {
		List<DisciplinaMinistrada> lista = repository.findAll();
		HttpStatus status = HttpStatus.OK;
		if(lista == null || lista.isEmpty()) {
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<List<DisciplinaMinistrada>>(lista, status);
	}
	
	public ResponseEntity<Optional<DisciplinaMinistrada>> getOne(Long id) {
		Optional<DisciplinaMinistrada> model = repository.findById(id);
		HttpStatus status = HttpStatus.OK;
		if(!model.isPresent()) {
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<Optional<DisciplinaMinistrada>>(model, status);
	}
	
	public ResponseEntity<DisciplinaMinistrada> post(@RequestBody @Valid DisciplinaMinistrada entity) {
		repository.save(entity);
		HttpStatus status = HttpStatus.CREATED;
		MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
		if(entity.getId() == null || entity.getId().longValue() <= 0) {
			status = HttpStatus.NOT_MODIFIED;
			header.set(HttpHeaders.LOCATION, entity.getId().toString());
		}
		
		return new ResponseEntity<>(null, header, status);
	}
	
	public ResponseEntity<DisciplinaMinistrada> patch(@PathVariable("id") Long id, @RequestBody DisciplinaMinistrada entity) {
		entity.setId(id);
		fillInBlankFields(entity);
		repository.save(entity);
		HttpStatus status = HttpStatus.ACCEPTED;
		if(entity.getId() == null || entity.getId().longValue() <= 0) {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, status);
	}
	
	public ResponseEntity<DisciplinaMinistrada> put(@PathVariable("id") Long id, @RequestBody DisciplinaMinistrada entity) {
		entity.setId(id);
		repository.save(entity);
		HttpStatus status = HttpStatus.ACCEPTED;
		if(entity.getId() == null || entity.getId().longValue() <= 0) {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, status);
	}
	
	public ResponseEntity<DisciplinaMinistrada> delete(@PathVariable("id") Long id) {
		HttpStatus status = HttpStatus.NO_CONTENT;
		if(repository.existsById(id)) {
			repository.deleteById(id);
		}else {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, status);
	}
	
	public void fillInBlankFields(DisciplinaMinistrada entity) {
		DisciplinaMinistrada oldEntity = repository.findById(entity.getId()).get();
		merge(entity, oldEntity);
	}
	
	public void merge(DisciplinaMinistrada newEntity, DisciplinaMinistrada oldEntity) {
		// TODO Auto-generated method stub
		
	}

}
