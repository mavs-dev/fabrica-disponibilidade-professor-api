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

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models.UnidadeAcademica;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository.UnidadeAcademicaRepository;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

@RestController
@RequestMapping(value="/unidade-academica", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
public class UnidadeAcademicaResource implements Resource<UnidadeAcademica>{

	@Autowired
	private UnidadeAcademicaRepository repository;
	
	public ResponseEntity<List<UnidadeAcademica>> getAll() {
		List<UnidadeAcademica> lista = repository.findAll();
		HttpStatus status = HttpStatus.OK;
		if(lista == null || lista.isEmpty()) {
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<List<UnidadeAcademica>>(lista, getHeader(), status);
	}
	
	public ResponseEntity<Optional<UnidadeAcademica>> getOne(Long id) {
		Optional<UnidadeAcademica> model = repository.findById(id);
		HttpStatus status = HttpStatus.OK;
		if(!model.isPresent()) {
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<Optional<UnidadeAcademica>>(model, getHeader(), status);
	}
	
	public ResponseEntity<UnidadeAcademica> post(@RequestBody @Valid UnidadeAcademica entity) {
		HttpStatus status = HttpStatus.CREATED;
		Map<String, String> contents = new HashMap<>();
		try {
			repository.save(entity);
		} catch (Exception e) {
			status = HttpStatus.NOT_MODIFIED;
			UnidadeAcademica unidade = repository.findByNome(entity.getNome());
			contents.put(HttpHeaders.LOCATION, unidade.getId().toString());
			contents.put(HttpHeaders.WARNING, e.getMessage());
		}
		
		return new ResponseEntity<>(null, getHeader(contents), status);
	}
	
	public ResponseEntity<UnidadeAcademica> patch(@PathVariable("id") Long id, @RequestBody UnidadeAcademica entity) {
		entity.setId(id);
		fillInBlankFields(entity);
		repository.save(entity);
		HttpStatus status = HttpStatus.ACCEPTED;
		if(entity.getId() == null || entity.getId().longValue() <= 0) {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, getHeader(), status);
	}
	
	public ResponseEntity<UnidadeAcademica> put(@PathVariable("id") Long id, @RequestBody UnidadeAcademica entity) {
		entity.setId(id);
		repository.save(entity);
		HttpStatus status = HttpStatus.ACCEPTED;
		if(entity.getId() == null || entity.getId().longValue() <= 0) {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, getHeader(), status);
	}
	
	public ResponseEntity<UnidadeAcademica> delete(@PathVariable("id") Long id) {
		HttpStatus status = HttpStatus.NO_CONTENT;
		if(repository.existsById(id)) {
			repository.deleteById(id);
		}else {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, getHeader(), status);
	}
	
	public void fillInBlankFields(UnidadeAcademica entity) {
		UnidadeAcademica oldEntity = repository.findById(entity.getId()).get();
		merge(entity, oldEntity);
	}
	
	public void merge(UnidadeAcademica newEntity, UnidadeAcademica oldEntity) {
		// TODO Auto-generated method stub
		
	}

}
