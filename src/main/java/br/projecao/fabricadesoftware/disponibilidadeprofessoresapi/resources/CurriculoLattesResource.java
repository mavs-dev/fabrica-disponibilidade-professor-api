package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models.CurriculoLattes;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

public class CurriculoLattesResource implements Resource<CurriculoLattes> {

	@Override
	public ResponseEntity<List<CurriculoLattes>> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Optional<CurriculoLattes>> listOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<CurriculoLattes> create(CurriculoLattes entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<CurriculoLattes> update(Long id, CurriculoLattes entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<CurriculoLattes> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fillInBlankFields(CurriculoLattes entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void merge(CurriculoLattes newEntity, CurriculoLattes oldEntity) {
		// TODO Auto-generated method stub
		
	}

}
