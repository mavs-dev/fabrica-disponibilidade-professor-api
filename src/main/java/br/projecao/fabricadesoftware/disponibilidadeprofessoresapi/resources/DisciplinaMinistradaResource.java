package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models.DisciplinaMinistrada;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

public class DisciplinaMinistradaResource implements Resource<DisciplinaMinistrada>{

	@Override
	public ResponseEntity<List<DisciplinaMinistrada>> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Optional<DisciplinaMinistrada>> listOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<DisciplinaMinistrada> create(DisciplinaMinistrada entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<DisciplinaMinistrada> update(Long id, DisciplinaMinistrada entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<DisciplinaMinistrada> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fillInBlankFields(DisciplinaMinistrada entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void merge(DisciplinaMinistrada newEntity, DisciplinaMinistrada oldEntity) {
		// TODO Auto-generated method stub
		
	}

}
