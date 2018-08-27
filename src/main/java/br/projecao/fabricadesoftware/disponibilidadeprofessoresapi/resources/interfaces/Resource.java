package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces;


import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

public interface Resource<Model> {
	
	public ResponseEntity<List<Model>> listAll();
	public ResponseEntity<Optional<Model>> listOne(Long id);
	public ResponseEntity<Model> create(Model entity);
	public ResponseEntity<Model> update(Long id, Model entity);
	public ResponseEntity<Model> delete(Long id);
	
	void fillInBlankFields(Model entity);
	void merge(Model newEntity, Model oldEntity);
	
}
