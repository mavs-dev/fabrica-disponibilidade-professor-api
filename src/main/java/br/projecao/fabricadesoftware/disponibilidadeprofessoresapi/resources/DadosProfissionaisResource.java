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

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model.DadosProfissionais;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository.DadosProfissionaisRepository;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

@RestController
@RequestMapping(value = "/dados-profissionais", produces = MediaType.APPLICATION_JSON_VALUE)
public class DadosProfissionaisResource implements Resource<DadosProfissionais> {

	@Autowired
	private DadosProfissionaisRepository repository;

	@Override
	public ResponseEntity<List<DadosProfissionais>> getAll() {
		List<DadosProfissionais> lista = repository.findAll();
		HttpStatus status = HttpStatus.OK;
		if (lista == null || lista.isEmpty()) {
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<List<DadosProfissionais>>(lista, status);
	}

	@Override
	public ResponseEntity<Optional<DadosProfissionais>> getOne(@PathVariable("id") Long id) {
		Optional<DadosProfissionais> model = repository.findById(id);
		HttpStatus status = HttpStatus.OK;
		if (!model.isPresent()) {
			model = null;
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<Optional<DadosProfissionais>>(model, status);
	}

	@Override
	public ResponseEntity<DadosProfissionais> post(@RequestBody DadosProfissionais entity) {
		HttpStatus status = HttpStatus.CREATED;
		try {
			repository.save(entity);
		} catch (Exception e) {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(entity, status);
	}

	@Override
	public ResponseEntity<DadosProfissionais> patch(@PathVariable("id") Long id, @RequestBody DadosProfissionais entity) {
		/*
		 * entity.setId(id); fillInBlankFields(entity); repository.save(entity);
		 * HttpStatus status = HttpStatus.ACCEPTED; if (entity.getId() == null ||
		 * entity.getId().longValue() <= 0) { status = HttpStatus.NOT_MODIFIED; }
		 */
		return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<DadosProfissionais> put(@PathVariable("id") Long id, @RequestBody DadosProfissionais entity) {
		entity.setId(id);
		repository.save(entity);
		HttpStatus status = HttpStatus.ACCEPTED;
		if (entity.getId() == null || entity.getId().longValue() <= 0) {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, status);
	}

	@Override
	public ResponseEntity<DadosProfissionais> delete(@PathVariable("id") Long id) {
		HttpStatus status = HttpStatus.NO_CONTENT;
		if (repository.existsById(id)) {
			repository.deleteById(id);
		} else {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, status);
	}

	@Override
	public void fillInBlankFields(DadosProfissionais entity) {

	}

	@Override
	public void merge(DadosProfissionais newEntity, DadosProfissionais oldEntity) {

	}

}
