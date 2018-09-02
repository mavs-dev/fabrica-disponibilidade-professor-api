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

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models.CurriculoLattes;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository.CurriculoLattesRepository;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

@RestController
@RequestMapping(value="/curriculo-lattes", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
public class CurriculoLattesResource implements Resource<CurriculoLattes> {

	@Autowired
	private CurriculoLattesRepository repository;
	
	public ResponseEntity<List<CurriculoLattes>> getAll() {
		List<CurriculoLattes> lista = repository.findAll();
		HttpStatus status = HttpStatus.OK;
		if(lista == null || lista.isEmpty()) {
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<List<CurriculoLattes>>(lista, getHeader(), status);
	}
	
	public ResponseEntity<Optional<CurriculoLattes>> getOne(Long id) {
		Optional<CurriculoLattes> model = repository.findById(id);
		HttpStatus status = HttpStatus.OK;
		if(!model.isPresent()) {
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<Optional<CurriculoLattes>>(model, getHeader(), status);
	}
	
	public ResponseEntity<CurriculoLattes> post(@RequestBody @Valid CurriculoLattes entity) {
		HttpStatus status = HttpStatus.CREATED;
		Map<String, String> contents = new HashMap<>();
		try {
			repository.save(entity);
		} catch (Exception e) {
			status = HttpStatus.NOT_MODIFIED;
			CurriculoLattes curriculo = repository.findByProfessor(entity.getProfessor());
			contents.put(HttpHeaders.LOCATION, curriculo.getId().toString());
			contents.put(HttpHeaders.WARNING, e.getMessage());
		}
		
		return new ResponseEntity<>(null, getHeader(contents), status);
	}
	
	public ResponseEntity<CurriculoLattes> patch(@PathVariable("id") Long id, @RequestBody CurriculoLattes entity) {
		entity.setId(id);
		fillInBlankFields(entity);
		repository.save(entity);
		HttpStatus status = HttpStatus.ACCEPTED;
		if(entity.getId() == null || entity.getId().longValue() <= 0) {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, getHeader(), status);
	}
	
	public ResponseEntity<CurriculoLattes> put(@PathVariable("id") Long id, @RequestBody CurriculoLattes entity) {
		entity.setId(id);
		repository.save(entity);
		HttpStatus status = HttpStatus.ACCEPTED;
		if(entity.getId() == null || entity.getId().longValue() <= 0) {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, getHeader(), status);
	}
	
	public ResponseEntity<CurriculoLattes> delete(@PathVariable("id") Long id) {
		HttpStatus status = HttpStatus.NO_CONTENT;
		if(repository.existsById(id)) {
			repository.deleteById(id);
		}else {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, getHeader(), status);
	}
	
	public void fillInBlankFields(CurriculoLattes entity) {
		CurriculoLattes oldEntity = repository.findById(entity.getId()).get();
		merge(entity, oldEntity);
	}

	
	public void merge(CurriculoLattes newEntity, CurriculoLattes oldEntity) {
		// TODO Auto-generated method stub
		
	}

}
