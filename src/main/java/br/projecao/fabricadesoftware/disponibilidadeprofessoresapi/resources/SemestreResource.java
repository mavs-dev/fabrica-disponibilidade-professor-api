package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model.Semestre;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository.SemestreRepository;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

@RestController
@RequestMapping(value = "/semestre", produces = MediaType.APPLICATION_JSON_VALUE)
public class SemestreResource implements Resource<Semestre> {

	@Autowired
	private SemestreRepository repository;

	@Override
	public ResponseEntity<List<Semestre>> getAll() {
		List<Semestre> lista = repository.findAll();
		HttpStatus status = HttpStatus.OK;
		if (lista == null || lista.isEmpty()) {
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<List<Semestre>>(lista, status);
	}

	@Override
	public ResponseEntity<Optional<Semestre>> getOne(Long id) {
		Optional<Semestre> model = repository.findById(id);
		HttpStatus status = HttpStatus.OK;
		if (!model.isPresent()) {
			model = null;
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<Optional<Semestre>>(model, status);
	}

	@Override
	public ResponseEntity<Semestre> post(Semestre entity) {
		HttpStatus status = HttpStatus.CREATED;
		try {
			repository.save(entity);
		} catch (Exception e) {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, status);
	}

	@Override
	public ResponseEntity<Semestre> patch(Long id, Semestre entity) {
		/*
		 * entity.setId(id); fillInBlankFields(entity); repository.save(entity);
		 * HttpStatus status = HttpStatus.ACCEPTED; if (entity.getId() == null ||
		 * entity.getId().longValue() <= 0) { status = HttpStatus.NOT_MODIFIED; }
		 */
		return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<Semestre> put(Long id, Semestre entity) {
		entity.setId(id);
		repository.save(entity);
		HttpStatus status = HttpStatus.ACCEPTED;
		if (entity.getId() == null || entity.getId().longValue() <= 0) {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, status);
	}

	@Override
	public ResponseEntity<Semestre> delete(Long id) {
		HttpStatus status = HttpStatus.NO_CONTENT;
		if (repository.existsById(id)) {
			repository.deleteById(id);
		} else {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, status);
	}

	@Override
	public void fillInBlankFields(Semestre entity) {

	}

	@Override
	public void merge(Semestre newEntity, Semestre oldEntity) {

	}

}
