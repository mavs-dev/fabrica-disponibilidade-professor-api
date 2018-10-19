package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model.Interesse;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository.InteresseRepository;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

@RestController
@RequestMapping(value = "/interesse", produces = MediaType.APPLICATION_JSON_VALUE)
public class InteresseResource implements Resource<Interesse> {

	@Autowired
	private InteresseRepository repository;

	@Override
	public ResponseEntity<List<Interesse>> getAll() {
		List<Interesse> lista = repository.findAll();
		HttpStatus status = HttpStatus.OK;
		if (lista == null || lista.isEmpty()) {
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<List<Interesse>>(lista, status);
	}

	@Override
	public ResponseEntity<Optional<Interesse>> getOne(Long id) {
		Optional<Interesse> model = repository.findById(id);
		HttpStatus status = HttpStatus.OK;
		if (!model.isPresent()) {
			model = null;
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<Optional<Interesse>>(model, status);
	}

	@Override
	public ResponseEntity<Interesse> post(Interesse entity) {
		HttpStatus status = HttpStatus.CREATED;
		try {
			repository.save(entity);
		} catch (Exception e) {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, status);
	}

	@Override
	public ResponseEntity<Interesse> patch(Long id, Interesse entity) {
		/*
		 * entity.setId(id); fillInBlankFields(entity); repository.save(entity);
		 * HttpStatus status = HttpStatus.ACCEPTED; if (entity.getId() == null ||
		 * entity.getId().longValue() <= 0) { status = HttpStatus.NOT_MODIFIED; }
		 */
		return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<Interesse> put(Long id, Interesse entity) {
		entity.setId(id);
		repository.save(entity);
		HttpStatus status = HttpStatus.ACCEPTED;
		if (entity.getId() == null || entity.getId().longValue() <= 0) {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, status);
	}

	@Override
	public ResponseEntity<Interesse> delete(Long id) {
		HttpStatus status = HttpStatus.NO_CONTENT;
		if (repository.existsById(id)) {
			repository.deleteById(id);
		} else {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, status);
	}

	@Override
	public void fillInBlankFields(Interesse entity) {

	}

	@Override
	public void merge(Interesse newEntity, Interesse oldEntity) {

	}

}
