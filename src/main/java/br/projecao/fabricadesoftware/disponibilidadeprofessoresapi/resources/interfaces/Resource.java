package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces;


import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

public interface Resource<Model> {
	
	public ResponseEntity<List<Model>> listAll();
	public ResponseEntity<Optional<Model>> listOne(String id);
	public ResponseEntity<Model> create(Model entity);
	public ResponseEntity<Model> update(String id, Model entity);
	public ResponseEntity<Model> delete(String id);
	
	void fillInBlankFields(Model entity);
	void merge(Model newModel, Model oldModel);
	
}
