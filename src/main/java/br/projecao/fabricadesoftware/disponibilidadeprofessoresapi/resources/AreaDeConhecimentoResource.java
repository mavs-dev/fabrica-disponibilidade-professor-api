package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models.AreaDeConhecimento;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository.AreaDeConhecimentoRepository;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

@RestController
@RequestMapping(value="/area-de-conhecimento", produces=MediaType.APPLICATION_JSON_VALUE)
public class AreaDeConhecimentoResource implements Resource<AreaDeConhecimento>{

	@Autowired
	HttpServletRequest servlet;
	
	@Autowired
	private AreaDeConhecimentoRepository repository;
	
	public ResponseEntity<List<AreaDeConhecimento>> getAll() {
		List<AreaDeConhecimento> lista = repository.findAll();
		HttpStatus status = HttpStatus.OK;
		if(lista == null || lista.isEmpty()) {
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<List<AreaDeConhecimento>>(lista, status);
	}

	public ResponseEntity<Optional<AreaDeConhecimento>> getOne(@PathVariable("id") Long id) {
		Optional<AreaDeConhecimento> model = repository.findById(id);
		HttpStatus status = HttpStatus.OK;
		if(!model.isPresent()) {
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<Optional<AreaDeConhecimento>>(model, status);
	}

	public ResponseEntity<AreaDeConhecimento> post(@RequestBody AreaDeConhecimento entity) {
		HttpStatus status = HttpStatus.CREATED;
		try {
			repository.save(entity);
		}catch(Exception e) {
			status = HttpStatus.NOT_MODIFIED;
		}
		
		return new ResponseEntity<>(null, status);
	}

	public ResponseEntity<AreaDeConhecimento> patch(@PathVariable("id") Long id, @RequestBody AreaDeConhecimento entity) {
		entity.setId(id);
		fillInBlankFields(entity);
		repository.save(entity);
		HttpStatus status = HttpStatus.ACCEPTED;
		if(entity.getId() == null || entity.getId().longValue() <= 0) {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, status);
	}
	
	public ResponseEntity<AreaDeConhecimento> put(@PathVariable("id") Long id, @RequestBody AreaDeConhecimento entity) {
		entity.setId(id);
		repository.save(entity);
		HttpStatus status = HttpStatus.ACCEPTED;
		if(entity.getId() == null || entity.getId().longValue() <= 0) {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, status);
	}

	public ResponseEntity<AreaDeConhecimento> delete(@PathVariable("id") Long id) {
		HttpStatus status = HttpStatus.NO_CONTENT;
		if(repository.existsById(id)) {
			repository.deleteById(id);
		}else {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, status);
	}

	public void fillInBlankFields(AreaDeConhecimento entity) {
		AreaDeConhecimento oldEntity = repository.findById(entity.getId()).get();
		merge(entity, oldEntity);
		
	}

	public void merge(AreaDeConhecimento newEntity, AreaDeConhecimento oldEntity) {
		//TODO implementar merge
	}

}
