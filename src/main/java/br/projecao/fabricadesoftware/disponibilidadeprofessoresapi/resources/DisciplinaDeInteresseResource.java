package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

public class DisciplinaDeInteresseResource implements Resource<DisciplinaDeInteresseResource>{

	@Override
	public ResponseEntity<List<DisciplinaDeInteresseResource>> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Optional<DisciplinaDeInteresseResource>> listOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<DisciplinaDeInteresseResource> create(DisciplinaDeInteresseResource entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<DisciplinaDeInteresseResource> update(Long id, DisciplinaDeInteresseResource entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<DisciplinaDeInteresseResource> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fillInBlankFields(DisciplinaDeInteresseResource entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void merge(DisciplinaDeInteresseResource newEntity, DisciplinaDeInteresseResource oldEntity) {
		// TODO Auto-generated method stub
		
	}

}
