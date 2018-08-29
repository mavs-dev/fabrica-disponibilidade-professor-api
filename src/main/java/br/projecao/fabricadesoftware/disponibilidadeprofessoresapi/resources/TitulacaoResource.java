package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models.Titulacao;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

public class TitulacaoResource implements Resource<Titulacao>{

	@Override
	public ResponseEntity<List<Titulacao>> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Optional<Titulacao>> listOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Titulacao> create(Titulacao entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Titulacao> update(Long id, Titulacao entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Titulacao> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fillInBlankFields(Titulacao entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void merge(Titulacao newEntity, Titulacao oldEntity) {
		// TODO Auto-generated method stub
		
	}

}
