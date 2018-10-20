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

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model.UnidadeAcademica;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository.UnidadeAcademicaRepository;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

@RestController
@RequestMapping(value = "/unidade-academica", produces = MediaType.APPLICATION_JSON_VALUE)
public class UnidadeAcademicaResource implements Resource<UnidadeAcademica> {

	@Autowired
	private UnidadeAcademicaRepository repository;

	@Override
	public ResponseEntity<List<UnidadeAcademica>> getAll() {
		List<UnidadeAcademica> lista = repository.findAll();
		HttpStatus status = HttpStatus.OK;
		if (lista == null || lista.isEmpty()) {
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<List<UnidadeAcademica>>(lista, status);
	}

	@Override
	public ResponseEntity<Optional<UnidadeAcademica>> getOne(@PathVariable("id") Long id) {
		Optional<UnidadeAcademica> model = repository.findById(id);
		HttpStatus status = HttpStatus.OK;
		if (!model.isPresent()) {
			model = null;
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<Optional<UnidadeAcademica>>(model, status);
	}

	@Override
	public ResponseEntity<UnidadeAcademica> post(@RequestBody UnidadeAcademica entity) {
		HttpStatus status = HttpStatus.CREATED;
		try {
			repository.save(entity);
		} catch (Exception e) {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, status);
	}

	@Override
	public ResponseEntity<UnidadeAcademica> patch(@PathVariable("id") Long id, @RequestBody UnidadeAcademica entity) {
		/*
		 * entity.setId(id); fillInBlankFields(entity); repository.save(entity);
		 * HttpStatus status = HttpStatus.ACCEPTED; if (entity.getId() == null ||
		 * entity.getId().longValue() <= 0) { status = HttpStatus.NOT_MODIFIED; }
		 */
		return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<UnidadeAcademica> put(@PathVariable("id") Long id, @RequestBody UnidadeAcademica entity) {
		entity.setId(id);
		repository.save(entity);
		HttpStatus status = HttpStatus.ACCEPTED;
		if (entity.getId() == null || entity.getId().longValue() <= 0) {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, status);
	}

	@Override
	public ResponseEntity<UnidadeAcademica> delete(@PathVariable("id") Long id) {
		HttpStatus status = HttpStatus.NO_CONTENT;
		if (repository.existsById(id)) {
			repository.deleteById(id);
		} else {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, status);
	}

	@Override
	public void fillInBlankFields(UnidadeAcademica entity) {

	}

	@Override
	public void merge(UnidadeAcademica newEntity, UnidadeAcademica oldEntity) {

	}

}
