package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models.AreaDeConhecimento;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

public class AreaDeConhecimentoResource implements Resource<AreaDeConhecimento>{

	@Override
	public ResponseEntity<List<AreaDeConhecimento>> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Optional<AreaDeConhecimento>> listOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<AreaDeConhecimento> create(AreaDeConhecimento entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<AreaDeConhecimento> update(Long id, AreaDeConhecimento entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<AreaDeConhecimento> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fillInBlankFields(AreaDeConhecimento entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void merge(AreaDeConhecimento newEntity, AreaDeConhecimento oldEntity) {
		// TODO Auto-generated method stub
		
	}

}
