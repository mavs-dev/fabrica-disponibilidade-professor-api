package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model.Interesse;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

@RestController
@RequestMapping(value = "/interesse", produces = MediaType.APPLICATION_JSON_VALUE)
public class InteresseResource implements Resource<Interesse> {

	@Override
	public ResponseEntity<List<Interesse>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Optional<Interesse>> getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Interesse> post(Interesse entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Interesse> patch(Long id, Interesse entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Interesse> put(Long id, Interesse entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Interesse> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fillInBlankFields(Interesse entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void merge(Interesse newEntity, Interesse oldEntity) {
		// TODO Auto-generated method stub

	}

}
