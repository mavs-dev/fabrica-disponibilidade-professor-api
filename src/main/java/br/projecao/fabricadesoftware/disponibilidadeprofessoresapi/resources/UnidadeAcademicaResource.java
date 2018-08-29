package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models.UnidadeAcademica;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

public class UnidadeAcademicaResource implements Resource<UnidadeAcademica>{

	@Override
	public ResponseEntity<List<UnidadeAcademica>> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Optional<UnidadeAcademica>> listOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<UnidadeAcademica> create(UnidadeAcademica entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<UnidadeAcademica> update(Long id, UnidadeAcademica entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<UnidadeAcademica> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fillInBlankFields(UnidadeAcademica entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void merge(UnidadeAcademica newEntity, UnidadeAcademica oldEntity) {
		// TODO Auto-generated method stub
		
	}

}
