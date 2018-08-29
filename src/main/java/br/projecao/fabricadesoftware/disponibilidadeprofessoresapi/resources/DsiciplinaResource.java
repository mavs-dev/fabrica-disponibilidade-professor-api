package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models.Disciplina;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

public class DsiciplinaResource implements Resource<Disciplina>{

	@Override
	public ResponseEntity<List<Disciplina>> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Optional<Disciplina>> listOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Disciplina> create(Disciplina entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Disciplina> update(Long id, Disciplina entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Disciplina> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fillInBlankFields(Disciplina entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void merge(Disciplina newEntity, Disciplina oldEntity) {
		// TODO Auto-generated method stub
		
	}

}
