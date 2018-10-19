package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model.Disponibilidade;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

@RestController
@RequestMapping(value = "/disponibilidade", produces = MediaType.APPLICATION_JSON_VALUE)
public class DisponibilidadeResource implements Resource<Disponibilidade> {

	@Override
	public ResponseEntity<List<Disponibilidade>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Optional<Disponibilidade>> getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Disponibilidade> post(Disponibilidade entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Disponibilidade> patch(Long id, Disponibilidade entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Disponibilidade> put(Long id, Disponibilidade entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Disponibilidade> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fillInBlankFields(Disponibilidade entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void merge(Disponibilidade newEntity, Disponibilidade oldEntity) {
		// TODO Auto-generated method stub
		
	}

}
