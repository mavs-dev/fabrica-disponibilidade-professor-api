package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces;


import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface Resource<Model> {
	
	@GetMapping
	public ResponseEntity<List<Model>> listAll();
	@GetMapping
	@RequestMapping(value ="/{id}")
	public ResponseEntity<Optional<Model>> listOne(Long id);
	@PostMapping
	public ResponseEntity<Model> create(Model entity);
	@PatchMapping(value = "/{id}")
	public ResponseEntity<Model> update(Long id, Model entity);
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Model> delete(Long id);
	
	void fillInBlankFields(Model entity);
	void merge(Model newEntity, Model oldEntity);
	
}
