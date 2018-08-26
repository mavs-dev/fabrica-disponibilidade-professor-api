package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models.DisciplinasMinistradas;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository.DisciplinasMinistradasRepository;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

@RestController
@RequestMapping(value = "disciplinas-ministradas")
public class DisciplinasMinistradasResource implements Resource<DisciplinasMinistradas>{

	@Autowired
	private DisciplinasMinistradasRepository dmr;

	@GetMapping
	public ResponseEntity<List<DisciplinasMinistradas>> listAll() {
		List<DisciplinasMinistradas> lista = dmr.findAll();
		HttpStatus status = HttpStatus.OK;
		if(lista == null || lista.isEmpty()) {
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<List<DisciplinasMinistradas>>(lista, status);
	}

	@GetMapping
	@RequestMapping(value = "/{id}")
	public ResponseEntity<Optional<DisciplinasMinistradas>> listOne(@PathVariable("id") String id) {
		Optional<DisciplinasMinistradas> disciplina = dmr.findById(id);
		HttpStatus status = HttpStatus.OK;
		if(!disciplina.isPresent()) {
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<Optional<DisciplinasMinistradas>>(disciplina, status);
	}

	@PostMapping
	public ResponseEntity<DisciplinasMinistradas> create(@RequestBody DisciplinasMinistradas entity) {
		dmr.save(entity);
		HttpStatus status = HttpStatus.CREATED;
		MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
		if(entity.get_id() == null || entity.get_id().isEmpty()) {
			status = HttpStatus.NOT_MODIFIED;
			header.set(HttpHeaders.LOCATION, entity.get_id());
		}
		return new ResponseEntity<>(entity, header, status);
	}

	@PatchMapping(value = "/{id}")
	public ResponseEntity<DisciplinasMinistradas> update(@PathVariable("id") String id, @RequestBody DisciplinasMinistradas entity) {
		entity.set_id(id);
		fillInBlankFields(entity);
		dmr.save(entity);
		HttpStatus status = HttpStatus.ACCEPTED;
		if(entity.get_id() == null || entity.get_id().isEmpty()) {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>( null , status);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<DisciplinasMinistradas> delete(@PathVariable("id") String id) {
		HttpStatus status = HttpStatus.NO_CONTENT;
		if(dmr.existsById(id)) {
			dmr.deleteById(id);;
		}else {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, status);
	}

	@Override
	public void fillInBlankFields(DisciplinasMinistradas entity) {
		DisciplinasMinistradas oldEntity = dmr.findById(entity.get_id()).get();
		merge(entity, oldEntity);
	}

	@Override
	public void merge(DisciplinasMinistradas newEntity, DisciplinasMinistradas oldEntity) {
		
	}

}
