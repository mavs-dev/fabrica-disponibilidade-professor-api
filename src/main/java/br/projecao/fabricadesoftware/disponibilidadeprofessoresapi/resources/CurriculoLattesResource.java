package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

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

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model.CurriculoLattes;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository.CurriculoLattesRepository;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

@RestController
@RequestMapping(value = "/curriculo-lattes", produces = MediaType.APPLICATION_JSON_VALUE)
public class CurriculoLattesResource implements Resource<CurriculoLattes> {
	
	@Autowired
	private CurriculoLattesRepository repository;

	@Override
	public ResponseEntity<List<CurriculoLattes>> getAll() {
		List<CurriculoLattes> lista = repository.findAll();
		HttpStatus status = HttpStatus.OK;
		if (lista == null || lista.isEmpty()) {
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<List<CurriculoLattes>>(lista, status);
	}

	@Override
	public ResponseEntity<Optional<CurriculoLattes>> getOne(@PathVariable("id") Long id) {
		Optional<CurriculoLattes> model = repository.findById(id);
		HttpStatus status = HttpStatus.OK;
		if (!model.isPresent()) {
			model = null;
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<Optional<CurriculoLattes>>(model, status);
	}

	@Override
	public ResponseEntity<CurriculoLattes> post(@RequestBody CurriculoLattes entity) {
		HttpStatus status = HttpStatus.CREATED;
		try {
			repository.save(entity);
		} catch (Exception e) {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(entity, status);
	}

	@Override
	public ResponseEntity<CurriculoLattes> patch(@PathVariable("id") Long id, @RequestBody CurriculoLattes entity) {
		/*
		 * entity.setId(id); fillInBlankFields(entity); repository.save(entity);
		 * HttpStatus status = HttpStatus.ACCEPTED; if (entity.getId() == null ||
		 * entity.getId().longValue() <= 0) { status = HttpStatus.NOT_MODIFIED; }
		 */
		return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<CurriculoLattes> put(@PathVariable("id") Long id, @RequestBody CurriculoLattes entity) {
		entity.setId(id);
		repository.save(entity);
		HttpStatus status = HttpStatus.ACCEPTED;
		if (entity.getId() == null || entity.getId().longValue() <= 0) {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, status);
	}

	@Override
	public ResponseEntity<CurriculoLattes> delete(@PathVariable("id") Long id) {
		HttpStatus status = HttpStatus.NO_CONTENT;
		if (repository.existsById(id)) {
			repository.deleteById(id);
		} else {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, status);
	}

	@Override
	public void fillInBlankFields(CurriculoLattes entity) {

	}

	@Override
	public void merge(CurriculoLattes newEntity, CurriculoLattes oldEntity) {

	}

}
