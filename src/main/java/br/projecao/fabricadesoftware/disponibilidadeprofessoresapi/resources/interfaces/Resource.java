package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface Resource<Model> {
	
	@GetMapping
	public ResponseEntity<List<Model>> getAll();
	@GetMapping
	@RequestMapping(value ="/{id}")
	public ResponseEntity<Optional<Model>> getOne(Long id);
	@PostMapping
	public ResponseEntity<Model> post(Model entity);
	@PatchMapping(value = "/{id}")
	public ResponseEntity<Model> patch(Long id, Model entity);
	@PutMapping(value = "/{id}")
	public ResponseEntity<Model> put(Long id, Model entity);
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Model> delete(Long id);
	
	void fillInBlankFields(Model entity);
	void merge(Model newEntity, Model oldEntity);
	
	default MultiValueMap<String, String> getHeader(Map<String, String> contents){
		MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
		header.set("Access-Control-Allow-Origin", "*");
		header.set("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		if(contents != null) {
			contents.forEach((key,value) -> header.set(key, value));
		}
		return header;
	}
	
	default MultiValueMap<String, String> getHeader(){
		MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
		header.set("Access-Control-Allow-Origin", "*");
		header.set("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		return header;
	}
	
	
}
